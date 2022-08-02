package org.example.dto.page.modelPage;

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
    private String name;
    private String lastname;
    private String passportNumber;
    private List<UserOrderPage> userOrderPageList;
}

