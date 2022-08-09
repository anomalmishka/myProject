package org.example.rest.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.dto.filter.FilterDTO;
import org.example.dto.models.FlightRouteDTO;
import org.example.model.FlightRoute;
import org.example.service.filter.api.FilterFlightRouteService;
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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class FilterFlightRouteControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FilterFlightRouteService filterFlightRouteService;

    @SneakyThrows
    private Long parseStringToLong(String stringToDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(stringToDate).getTime();
    }

    private static final ObjectMapper mapper = new ObjectMapper();
    private final FlightRoute ANSWER = FlightRoute.builder()
            .id(1L)
            .routeStart("Minsk")
            .routeEnd("Moskva")
            .distance(1000)
            .flightDateStart(new Timestamp(parseStringToLong("2022-09-03 12:00:00")))
            .flightDateEnd(new Timestamp(parseStringToLong("2022-09-03 13:00:00")))
            .price(200)
            .duration(60)
            .isActive(true)
            .build();
    private final FilterDTO GIVEN = FilterDTO.builder()
            .routeStart("Minsk")
            .build();
    private final List<FlightRoute> ANSWER_LIST = List.of(ANSWER);
    private final FlightRouteDTO EXPECTED = FlightRouteDTO.builder()
            .id(1L)
            .routeStart("Minsk")
            .routeEnd("Moskva")
            .distance(1000)
            .flightDateStart(new Timestamp(parseStringToLong("2022-09-03 12:00:00")))
            .flightDateEnd(new Timestamp(parseStringToLong("2022-09-03 13:00:00")))
            .price(200)
            .duration(60)
            .isActive(true)
            .build();
    private final List<FlightRouteDTO> EXPECTED_LIST = List.of(EXPECTED);
    private final Long GIVEN_ID = 1L;

    @Test
    public void testGetFindById() throws Exception {
        Mockito.when(filterFlightRouteService.findById(ArgumentMatchers.any())).thenReturn(ANSWER_LIST);
        MvcResult requestResult = mockMvc.perform(get("/buisness/filter/flight/route/find/" + GIVEN_ID + "/")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_LIST);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void testPostFind() throws Exception {
        Mockito.when(filterFlightRouteService.filter(ArgumentMatchers.any())).thenReturn(ANSWER_LIST);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN);
        MvcResult requestResult = mockMvc.perform(post("/buisness/filter/flight/route/find")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(GIVEN_JSON)
                        .characterEncoding("utf-8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_LIST);
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }
}
