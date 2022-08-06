package org.example.dto.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AdviceExceptionDTO {

    private String error;
    private ZonedDateTime timestamp;
    private HttpStatus httpStatus;
    private String path;

}