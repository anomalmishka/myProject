package org.example.mapper;

import org.example.dto.GetIdDTO;
import org.example.model.GetIdObj;
import org.springframework.stereotype.Component;

@Component
public class GetIdMapper {
    public GetIdObj toModel(GetIdDTO getIdDTO) {
        return GetIdObj.builder()
                .id(getIdDTO.getId())
                .idlist(getIdDTO.getIdlist())
                .build();
    }
}
