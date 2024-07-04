package com.app.kt

import com.app.jv.TestDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TestKtController {

    @GetMapping("/{message}")
    fun getMessage(@PathVariable message: String): ResponseEntity<TestDto> =
        ResponseEntity.ok(
            TestDto.builder()
                .name(message)
                .age(20)
                .email("kt@test.com")
                .build()
        )

}