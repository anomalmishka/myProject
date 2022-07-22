package org.example.mapper.models;

import org.example.dto.models.StatusDTO;
import org.example.model.entity.Status;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusMapper {
    public StatusDTO toDTO(Status status) {
        return StatusDTO.builder()
                .id(status.getId())
                .status(status.getStatus())
                .build();
    }

    public List<StatusDTO> toDTO(List<Status> statusList) {
        return statusList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Status> toModel(List<StatusDTO> statusDTOList) {
        return statusDTOList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Status toModel(StatusDTO statusDTO) {
        return Status.builder()
                .id(statusDTO.getId())
                .status(statusDTO.getStatus())
                .build();
    }
}
