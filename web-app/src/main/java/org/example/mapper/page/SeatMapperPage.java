package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.SeatDTO;
import org.example.dto.page.SeatPage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SeatMapperPage {
    private final ModelMapper modelMapper;
    public SeatDTO toDTO(SeatPage seatPage) {
        return modelMapper.map(seatPage, SeatDTO.class);
    }

    public List<SeatDTO> toDTO(List<SeatPage> seatPageList) {
        return Optional.ofNullable(seatPageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<SeatPage> toPage(List<SeatDTO> seatDTOList) {
        return Optional.ofNullable(seatDTOList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public SeatPage toPage(SeatDTO seatDTO) {
        return modelMapper.map(seatDTO, SeatPage.class);
    }
}
