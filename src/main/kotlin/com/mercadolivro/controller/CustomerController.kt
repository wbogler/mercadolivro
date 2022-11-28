package com.mercadolivro.controller

import com.mercadolivro.dto.CustomerDTO
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
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
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun getCustomers(@RequestParam name:String?): List<CustomerModel> {
        return customerService.getCustomers(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id:Int): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@RequestBody customer: CustomerModel): ResponseEntity<CustomerModel> {
        return ResponseEntity.ok(customerService.updateCustomer(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id:Int) {
        customerService.deleteCustomer(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun creatCustomers(@RequestBody customer: CustomerDTO) {
        customerService.postCustomers(customer)
    }
}