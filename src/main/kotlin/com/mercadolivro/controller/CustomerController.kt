package com.mercadolivro.controller

import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController {

    val customers1 = mutableListOf<CustomerModel>()


    @GetMapping
    fun getCustomers(): ResponseEntity<List<CustomerModel>> {

        return ResponseEntity.ok(customers1)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id:Long): ResponseEntity<CustomerModel>{
        return ResponseEntity.ok(customers1.filter { it.id == id }.first())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id:Long, @RequestBody customer: CustomerModel): ResponseEntity<CustomerModel> {
       customers1.filter { it.id == id }.first().let {
            it.id = id
            it.name = customer.name
            it.email = customer.email
        }
        return ResponseEntity.ok( customers1.filter { it.id == id }.first())
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