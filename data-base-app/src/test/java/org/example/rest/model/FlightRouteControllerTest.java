package org.example.rest.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.dto.models.FlightRouteDTO;
import org.example.model.FlightRoute;
import org.example.service.models.api.FlightRouteService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightRouteControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FlightRouteService flightRouteService;

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
    private final FlightRouteDTO GIVEN = FlightRouteDTO.builder()
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
    private final List<Long> GIVEN_ID_LIST = List.of(GIVEN_ID);

    @Test
    public void testGetReadAll() throws Exception {
        String EXPECTED_JSON = mapper.writeValueAsString(EXPECTED_LIST);
        Mockito.when(flightRouteService.readAll()).thenReturn(ANSWER_LIST);
        MvcResult requestResult =
                mockMvc.perform(get("/flight/route/read/all")
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();
        String ACTUAL = requestResult.getResponse().getContentAsString();
        assertEquals(EXPECTED_JSON, ACTUAL);
    }

    @Test
    public void testGetReadById() throws Exception {
        Mockito.when(flightRouteService.readById(ArgumentMatchers.any())).thenReturn(ANSWER);
        MvcResult requestResult = mockMvc.perform(get("/flight/route/read/" + GIVEN_ID + "/")
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
        Mockito.when(flightRouteService.readAllByIds(ArgumentMatchers.any())).thenReturn(ANSWER_LIST);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN_ID_LIST);
        MvcResult requestResult = mockMvc.perform(post("/flight/route/read/all/id")
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
        Mockito.when(flightRouteService.create(ArgumentMatchers.any())).thenReturn(ANSWER);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN);
        MvcResult requestResult = mockMvc.perform(post("/flight/route/create")
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
        Mockito.when(flightRouteService.update(ArgumentMatchers.any())).thenReturn(ANSWER);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN);
        MvcResult requestResult = mockMvc.perform(put("/flight/route/update")
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
        Mockito.when(flightRouteService.deleteById(ArgumentMatchers.any())).thenReturn(ANSWER);
        MvcResult requestResult = mockMvc.perform(delete("/flight/route/delete/" + GIVEN_ID + "/")
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
        Mockito.when(flightRouteService.deleteAllByIds(ArgumentMatchers.any())).thenReturn(ANSWER_LIST);
        String GIVEN_JSON = mapper.writeValueAsString(GIVEN_ID_LIST);
        MvcResult requestResult = mockMvc.perform(delete("/flight/route/delete/all/id")
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
