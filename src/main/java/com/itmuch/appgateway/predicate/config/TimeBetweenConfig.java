package com.itmuch.appgateway.predicate.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeBetweenConfig {
    private LocalTime start;
    private LocalTime end;
}
