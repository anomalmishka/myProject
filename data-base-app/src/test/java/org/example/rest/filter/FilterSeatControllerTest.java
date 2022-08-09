package org.example.rest.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.models.SeatDTO;
import org.example.dto.models.UserProfileDTO;
import org.example.model.Seat;
import org.example.model.UserProfile;
import org.example.service.filter.api.FilterSeatService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class FilterSeatControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FilterSeatService filterSeatService;

    private static final ObjectMapper mapper = new ObjectMapper();


    private final SeatDTO EXPECTED = SeatDTO.builder().build().builder()
            .id(1L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final List<SeatDTO> EXPECTED_LIST = List.of(EXPECTED);
    private final Seat ANSWER = Seat.builder()
            .id(1L)
            .type("Lowcost")
            .place("1A")
            .isOrdered(true)
            .build();
    private final List<Seat> ANSWER_LIST = List.of(ANSWER);
    private final Long GIVEN_ID = 1L;

    @Test
    public void testGetFindById() throws Exception {
        Mockito.when(filterSeatService.findSeatWhereAirPlaneId(ArgumentMatchers.any())).thenReturn(ANSWER_LIST);
        MvcResult requestResult = mockMvc.perform(get("/buisness/filter/seat/where/air/plane/" + GIVEN_ID + "/")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_LIST);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }
}
