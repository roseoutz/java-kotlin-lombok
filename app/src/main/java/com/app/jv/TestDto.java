package com.app.jv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class TestDto {

    private final String name;
    private final int age;
    private final String email;
}
