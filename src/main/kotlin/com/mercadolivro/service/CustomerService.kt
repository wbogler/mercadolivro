package com.mercadolivro.service

import com.mercadolivro.dto.CustomerDTO
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.Customerrepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@Service
class CustomerService(
    val customerRepository: Customerrepository
) {

    @GetMapping
    fun getCustomers(name:String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContainig(name).toList()
        }
        return customerRepository.findAll().toList()
    }

    fun getCustomer( id:Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun updateCustomer( customer: CustomerModel): CustomerModel {
        if(!customerRepository.existsById(customer.id!!)){
            throw Exception()
        }
        return customerRepository.save(customer)
    }

    fun deleteCustomer(id:Int) {
        if(!customerRepository.existsById(id)){
            throw Exception()
        }
        customerRepository.deleteById(id)
    }

    fun postCustomers( customer: CustomerDTO){
        var customerCreat: CustomerModel = CustomerModel(null,customer.name,customer.email)
        customerRepository.save(customerCreat)
    }

}