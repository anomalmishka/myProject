package org.example.dto.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExceptionHandlerBodyDTO {

    private String error;
    private ZonedDateTime timestamp;
    private Integer httpStatus;
    private String path;

}