package org.example.rest.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.dto.filter.FilterDTO;
import org.example.dto.models.FlightRouteDTO;
import org.example.dto.models.UserProfileDTO;
import org.example.model.FlightRoute;
import org.example.model.UserProfile;
import org.example.service.filter.api.FilterUserProfileService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FilterUserProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FilterUserProfileService filterUserProfileService;

    private static final ObjectMapper mapper = new ObjectMapper();

    private final UserProfileDTO EXPECTED = UserProfileDTO.builder()
            .id(1L)
            .profilename("Manager")
            .lastname("Manager")
            .phone(998877)
            .email("manager@gmail.com")
            .isBlockedProfile(false)
            .userId(1L)
            .build();
    private final UserProfile ANSWER = UserProfile.builder()
            .id(1L)
            .profilename("Manager")
            .lastname("Manager")
            .phone(998877)
            .email("manager@gmail.com")
            .isBlockedProfile(false)
            .userId(1L)
            .build();
    private final Long GIVEN_ID = 1L;

    @Test
    public void testGetFindById() throws Exception {
        Mockito.when(filterUserProfileService.findWhereUserId(ArgumentMatchers.any())).thenReturn(ANSWER);
        MvcResult requestResult = mockMvc.perform(get("/buisness/filter/user/profile/where/user/" + GIVEN_ID + "/")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }
}
