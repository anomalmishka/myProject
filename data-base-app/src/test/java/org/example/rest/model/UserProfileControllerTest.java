package org.example.rest.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.models.UserProfileDTO;
import org.example.model.UserProfile;
import org.example.service.models.api.UserProfileService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserProfileService userProfileService;

    private static ObjectMapper mapper = new ObjectMapper();
    private final UserProfile ANSWER = UserProfile.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(7788)
            .isBlockedProfile(false)
            .userId(1L)
            .email("admin@gmail.com")
            .build();
    private final UserProfileDTO GIVEN = UserProfileDTO.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(7788)
            .isBlockedProfile(false)
            .userId(1L)
            .email("admin@gmail.com")
            .build();
    private final List<UserProfile> ANSWER_LIST = List.of(ANSWER);
    private final UserProfileDTO EXPECTED = UserProfileDTO.builder()
            .id(1L)
            .profilename("Admin")
            .lastname("Admin")
            .phone(7788)
            .isBlockedProfile(false)
            .userId(1L)
            .email("admin@gmail.com")
            .build();
    private final List<UserProfileDTO> EXPECTED_LIST = List.of(EXPECTED);
    private final Long GIVEN_ID = 1L;
    private final List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);

    @Test
    public void testGetReadAll() throws Exception {
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_LIST);
        Mockito.when(userProfileService.readAll()).thenReturn(ANSWER_LIST);
        MvcResult requestResult =
                mockMvc.perform(get("/user/profile/read/all")
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void testGetReadById() throws Exception {
        Mockito.when(userProfileService.readById(ArgumentMatchers.any())).thenReturn(ANSWER);
        MvcResult requestResult = mockMvc.perform(get("/user/profile/read/" + GIVEN_ID + "/")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void testGetReadAllById() throws Exception {
        Mockito.when(userProfileService.readAllByIds(ArgumentMatchers.any())).thenReturn(ANSWER_LIST);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN_ID_LIST);
        MvcResult requestResult = mockMvc.perform(post("/user/profile/read/all/id")
                        .content(GIVEN_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_LIST);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void testPostCreate() throws Exception {
        Mockito.when(userProfileService.create(ArgumentMatchers.any())).thenReturn(ANSWER);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN);
        MvcResult requestResult = mockMvc.perform(post("/user/profile/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(GIVEN_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void testPutUpdate() throws Exception {
        Mockito.when(userProfileService.update(ArgumentMatchers.any())).thenReturn(ANSWER);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN);
        MvcResult requestResult = mockMvc.perform(put("/user/profile/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(GIVEN_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void testDeleteDeleteById() throws Exception {
        Mockito.when(userProfileService.deleteById(ArgumentMatchers.any())).thenReturn(ANSWER);
        MvcResult requestResult = mockMvc.perform(delete("/user/profile/delete/" + GIVEN_ID + "/")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void testDeleteDeleteAllById() throws Exception {
        Mockito.when(userProfileService.deleteAllByIds(ArgumentMatchers.any())).thenReturn(ANSWER_LIST);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN_ID_LIST);
        MvcResult requestResult = mockMvc.perform(delete("/user/profile/delete/all/id")
                        .content(GIVEN_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_LIST);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }
}
