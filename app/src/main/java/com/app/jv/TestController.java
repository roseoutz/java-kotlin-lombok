package com.app.jv;

import com.app.kt.KtTestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test/{message}")
    public ResponseEntity<TestDto> test(@PathVariable String message) {
        return ResponseEntity.ok(
                new TestDto(message, 20, message + "@test.com")
        );

    }


    @GetMapping("/test2/{message}")
    public ResponseEntity<TestDto> test2(@PathVariable String message) {
        return ResponseEntity.ok(
                TestDto.builder()
                        .name(message)
                        .age(20)
                        .email(message + "@test.com")
                        .build()
        );

    }

    @GetMapping("/test3/{message}")
    public ResponseEntity<KtTestDto> test3(@PathVariable String message) {
        return ResponseEntity.ok(
                new KtTestDto(
                        message,
                        20,
                        message + "@test.com")
        );

    }
}
