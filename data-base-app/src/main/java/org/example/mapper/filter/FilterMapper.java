package org.example.mapper.filter;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDTO;
import org.example.dto.filter.FilterObj;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FilterMapper {
    private final ModelMapper modelMapper;

    public FilterObj toModel(FilterDTO filterDTO) {
        return modelMapper.map(filterDTO, FilterObj.class);
    }
}
