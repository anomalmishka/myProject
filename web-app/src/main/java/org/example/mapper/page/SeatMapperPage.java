package org.example.mapper.page;

import org.example.dto.modelsDTO.SeatDTO;
import org.example.dto.page.modelPage.SeatPage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SeatMapperPage {
    public SeatDTO toDTO(SeatPage seatPage) {
        return SeatDTO.builder()
                .id(seatPage.getId())
                .place(seatPage.getPlace())
                .type(seatPage.getType())
                .isOrdered(seatPage.getIsOrdered())
                .build();
    }

    public List<SeatDTO> toDTO(List<SeatPage> seatPageList) {
        return Optional.ofNullable(seatPageList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<SeatPage> toPage(List<SeatDTO> seatDTOList) {
        return Optional.ofNullable(seatDTOList)
                .map(airCompanyDTOList1 -> airCompanyDTOList1.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public SeatPage toPage(SeatDTO seatDTO) {
        return SeatPage.builder()
                .id(seatDTO.getId())
                .place(seatDTO.getPlace())
                .type(seatDTO.getType())
                .isOrdered(seatDTO.getIsOrdered())
                .build();
    }
}
