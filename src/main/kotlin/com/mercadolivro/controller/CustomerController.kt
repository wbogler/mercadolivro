package com.mercadolivro.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {

    @GetMapping("/fun")
    fun helloWorld():String{
        return "Hello world"
    }
}