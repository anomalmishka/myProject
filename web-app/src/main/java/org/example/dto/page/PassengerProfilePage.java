package org.example.dto.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PassengerProfilePage {
    private Long id;
    private String passengername;
    private String passengerlastname;
    private String passportNumber;
    private List<UserOrderPage> userOrderList;
}

