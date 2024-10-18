package org.dev.library.msvc.users.dev.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.dev.library.msvc.users.dev.Models.UsersModel;
import org.dev.library.msvc.users.dev.Services.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTest {

    private final Faker faker = new Faker();
    private final MockMvc mockMvc;
    private final ObjectMapper jacksonObjectMapper;

    @Autowired
    public UsersControllerTest(MockMvc mockMvc, UsersService usersService, ObjectMapper jacksonObjectMapper) {
        this.mockMvc = mockMvc;
        this.jacksonObjectMapper = jacksonObjectMapper;
    }

    @Test
    public void GetAllUsersTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    public void GetUserByIdTest() throws Exception {
        String id = "1";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/" + id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").exists());
    }

    @Test
    public void testGetByIdUserNotFound() throws Exception {
        String id = "99999";
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users/" + id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("User  not found with id " + id));
    }

    @Test
    public void SaverUserTest() throws Exception {

        UsersModel usersModel = UsersModel.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .birth(new Date())
                .email(faker.internet().emailAddress())
                .username(faker.name().username())
                .phonenumber(faker.phoneNumber().cellPhone())
                .address(faker.address().streetAddress())
                .password(faker.internet().password())
                .createdBy(UsersModel.builder().id(1L).build())
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users").contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonObjectMapper.writeValueAsString(usersModel)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("User created successfully."));
    }

    @Test
    public void SaverUserTestNotFound() throws Exception {

        UsersModel usersModel = UsersModel.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .birth(new Date())
                .email(faker.internet().emailAddress())
                .username(faker.name().username())
                .phonenumber(faker.phoneNumber().cellPhone())
                .address(faker.address().streetAddress())
                .password(faker.internet().password())
                .createdBy(UsersModel.builder().id(99L).build())
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users").contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonObjectMapper.writeValueAsString(usersModel)))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("The user created with id: " + usersModel.getCreatedBy().getId() + " does not exist."));
    }

    @Test
    public void UpdateUserTest() throws Exception {
        String id = "6";
        UsersModel usersModel = UsersModel.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .birth(new Date())
                .email(faker.internet().emailAddress())
                .username(faker.name().username())
                .phonenumber(faker.phoneNumber().phoneNumber())
                .address(faker.address().streetAddress())
                .password(faker.internet().password())
                .updatedBy(UsersModel.builder().id(1L).build())
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put("/api/users/" + id).contentType(MediaType.APPLICATION_JSON)
                        .content(jacksonObjectMapper.writeValueAsString(usersModel)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("User updated successfully."));
    }

    @Test
    public void UpdateUserTestNotFound() throws Exception {
        String id = "99";
        UsersModel usersModel = UsersModel.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .birth(new Date())
                .email(faker.internet().emailAddress())
                .username(faker.name().username())
                .phonenumber(faker.phoneNumber().phoneNumber())
                .address(faker.address().streetAddress())
                .password(faker.internet().password())
                .updatedBy(UsersModel.builder().id(1L).build())
                .build();

        mockMvc.perform(MockMvcRequestBuilders.put("/api/users/" + id).contentType(MediaType.APPLICATION_JSON).content(jacksonObjectMapper.writeValueAsString(usersModel)))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("User not found with id: " + id));
    }

    @Test
    public void DeleteUserTest() throws Exception {
        String id = "2";
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/users/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("User delete successfully."));
    }

    @Test
    public void DeleteUserTestNotFound() throws Exception {
        String id = "98987";
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/users/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("User not found with id: " + id));
    }
}
