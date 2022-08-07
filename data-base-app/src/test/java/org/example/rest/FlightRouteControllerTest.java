package org.example.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.example.dao.crud.FlightRouteDAO;
import org.example.dao.custom.userProfile.UserPrifileCustomDAO;
import org.example.model.FlightRoute;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FlightRouteControllerTest {
    @LocalServerPort
    private Integer port;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private FlightRouteDAO flightRouteDAO;
    @Autowired
    private MockMvc mockMvc;
//
//    @SneakyThrows
//    private Long parseStringToLong(String stringToDate) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return dateFormat.parse(stringToDate).getTime();
//    }
//
//    @AfterEach
//    public void resetDataBase() {
//        flightRouteDAO.deleteAll();
//    }
//
//
//    @Test
//   public void givenFlightRoute_whenCreate_thenStatus201andPersonReturned() throws Exception {
//        FlightRoute flightRoute = FlightRoute.builder()
//                .routeStart("Minsk")
//                .routeEnd("Moskva")
//                .distance(1000)
//                .flightDateStart(new Timestamp(parseStringToLong("2022-09-03 12:00:00")))
//                .flightDateEnd(new Timestamp(parseStringToLong("2022-09-03 13:00:00")))
//                .price(200)
//                .duration(60)
//                .isActive(true)
//                .build();
//        mockMvc.perform(
//                        post("/flight/route/create")
//                                .content(objectMapper.writeValueAsString(flightRoute))
//                                .contentType(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id").isNumber())
//                .andExpect(jsonPath("$.name").value("Michail"));
//    }
//
//    @Test
//    public void givenId_whenGetExistingFlightRoute_thenStatus200andFlightRouteReturned() throws Exception {
//        long id = createTestFlightRoute("Minsk").getId();
//        mockMvc.perform(
//                        get("/flight/route/read/{id}/", id))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(id))
//                .andExpect(jsonPath("$.name").value("Minsk"));
//    }
//
//    private FlightRoute createTestFlightRoute(String routeStart) {
//        FlightRoute newflightRoute = FlightRoute.builder()
//                .routeStart(routeStart)
//                .routeEnd("Moskva")
//                .distance(1000)
//                .flightDateStart(new Timestamp(parseStringToLong("2022-09-03 12:00:00")))
//                .flightDateEnd(new Timestamp(parseStringToLong("2022-09-03 13:00:00")))
//                .price(200)
//                .duration(60)
//                .isActive(true)
//                .build();
//        return flightRouteDAO.save(newflightRoute);
//    }
}
