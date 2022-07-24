package org.example.mapper.modif;

import lombok.RequiredArgsConstructor;
import org.example.dto.models.modif.StatusDTOModif;
import org.example.mapper.model.UserOrderMapper;
import org.example.model.obj.database.modif.StatusModif;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class StatusMapperModif {
    private final UserOrderMapper userOrderMapper;

    public StatusDTOModif toDTO(StatusModif statusModif) {
        return StatusDTOModif.builder()
                .id(statusModif.getId())
                .status(statusModif.getStatus())
                .userOrderDTOList(userOrderMapper.toDTO(statusModif.getUserOrderList()))
                .build();
    }

    public List<StatusDTOModif> toDTO(List<StatusModif> statusList) {
        return statusList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<StatusModif> toModel(List<StatusDTOModif> statusDTOModifList) {
        return statusDTOModifList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public StatusModif toModel(StatusDTOModif statusDTOModif) {
        return StatusModif.builder()
                .id(statusDTOModif.getId())
                .status(statusDTOModif.getStatus())
                .userOrderList(userOrderMapper.toModel(statusDTOModif.getUserOrderDTOList()))
                .build();
    }
}
