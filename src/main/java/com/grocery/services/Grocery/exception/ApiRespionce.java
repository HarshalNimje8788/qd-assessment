package com.grocery.services.Grocery.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ApiRespionce {
    private  String message;
    private boolean success;
    private HttpStatus status;
}
