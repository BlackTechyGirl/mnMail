package com.semicolonAfrica.mnEmail.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorDetails {
    private ZonedDateTime timeStamp;
    private String message;
    private String description;
}
