package org.example.study.Controllers;

import org.example.study.Models.JpaModels.User;
import org.example.study.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.security.test.context.support.WithMockUser;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class AccountControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @MockitoBean
    private UserRepository userRepository;

    @Test
    @WithMockUser(username = "testUser")
    public void getAccountDetails_ShouldReturnAccountDTO() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@test.com");
        user.setFullname("Test User");

        given(userRepository.findByUsername("testUser")).willReturn(Optional.of(user));

        mockMvc.perform(get("/api/account"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("testUser"))
                .andExpect(jsonPath("$.email").value("test@test.com"))
                .andExpect(jsonPath("$.fullname").value("Test User"));
    }
}
