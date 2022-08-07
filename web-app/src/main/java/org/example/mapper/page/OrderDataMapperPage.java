package org.example.mapper.page;

import lombok.RequiredArgsConstructor;
import org.example.dto.OrderDataDTO;
import org.example.dto.OrderDataPage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class OrderDataMapperPage {
    private final ModelMapper modelMapper;

    public OrderDataDTO toDTO(OrderDataPage orderDataPage) {
        return modelMapper.map(orderDataPage, OrderDataDTO.class);

    }

    public List<OrderDataDTO> toDTO(List<OrderDataPage> orderDataPageList) {
        return Optional.ofNullable(orderDataPageList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<OrderDataPage> toPage(List<OrderDataDTO> orderDataDTOList) {
        return Optional.ofNullable(orderDataDTOList)
                .map(list -> list.stream()
                        .map(this::toPage).collect(Collectors.toList())).orElse(null);
    }

    public OrderDataPage toPage(OrderDataDTO orderDataDTO) {
        return modelMapper.map(orderDataDTO, OrderDataPage.class);
    }
}
