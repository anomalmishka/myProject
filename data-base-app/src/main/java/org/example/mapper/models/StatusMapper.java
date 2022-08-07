package org.example.mapper.models;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.StatusDTO;
import org.example.model.Status;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StatusMapper {
    private final ModelMapper modelMapper;

    public StatusDTO toDTO(Status status) {
        return modelMapper.map(status, StatusDTO.class);
    }

    public List<StatusDTO> toDTO(List<Status> statusList) {
        return Optional.ofNullable(statusList)
                .map(list -> list.stream()
                        .map(this::toDTO).collect(Collectors.toList())).orElse(null);
    }

    public List<Status> toModel(List<StatusDTO> statusDTOList) {
        return Optional.ofNullable(statusDTOList)
                .map(list -> list.stream()
                        .map(this::toModel).collect(Collectors.toList())).orElse(null);
    }

    public Status toModel(StatusDTO statusDTO) {
        return modelMapper.map(statusDTO, Status.class);
    }
}
