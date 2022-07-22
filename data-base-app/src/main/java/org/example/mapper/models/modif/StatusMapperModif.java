package org.example.mapper.models.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.StatusDTOModif;
import org.example.mapper.models.UserOrderMapper;
import org.example.model.entity.Status;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StatusMapperModif {
    private final UserOrderMapper userOrderMapper;

    public StatusDTOModif toDTO(Status status) {
        return StatusDTOModif.builder()
                .id(status.getId())
                .status(status.getStatus())
                .userOrderDTOList(userOrderMapper.toDTO(status.getUserOrderList()))
                .build();
    }

    public List<StatusDTOModif> toDTO(List<Status> statusList) {
        return statusList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Status> toModel(List<StatusDTOModif> statusDTOModifList) {
        return statusDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Status toModel(StatusDTOModif statusDTOModif) {
        return Status.builder()
                .id(statusDTOModif.getId())
                .status(statusDTOModif.getStatus())
                .userOrderList(userOrderMapper.toModel(statusDTOModif.getUserOrderDTOList()))
                .build();
    }
}
