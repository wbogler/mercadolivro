package com.mercadolivro.controller

import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController {

    @GetMapping
    fun getCustomers():CustomerModel{

        return CustomerModel(1,"Willian","email@email.com")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun posttCustomers(@RequestBody customer:CustomerModel):CustomerModel{

        return customer
    }
}