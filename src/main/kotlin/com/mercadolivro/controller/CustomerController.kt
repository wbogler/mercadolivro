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

    val customers1 = mutableListOf<CustomerModel>()


    @GetMapping
    fun getCustomers(): List<CustomerModel> {

        return customers1
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postCustomers(@RequestBody customer:CustomerModel){
        var id = if(customers1.isEmpty()){
            1
        }else{
            customers1.last().id+1
        }
        customers1.add(CustomerModel(id,customer.name,customer.email))
    }
}