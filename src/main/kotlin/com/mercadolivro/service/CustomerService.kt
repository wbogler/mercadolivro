package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class CustomerService {
    val customers1 = mutableListOf<CustomerModel>()

    @GetMapping
    fun getCustomers(name:String?): List<CustomerModel> {
        name?.let {
            return customers1.filter {
                it.name.contains(name, true)
            }
        }
        return customers1
    }

    fun getCustomer( id:Long): ResponseEntity<CustomerModel> {
        return ResponseEntity.ok(customers1.filter { it.id == id }.first())
    }

    fun updateCustomer( id:Long, customer: CustomerModel): CustomerModel {
        customers1.filter { it.id == id }.first().let {
            it.id = id
            it.name = customer.name
            it.email = customer.email
        }
        return customers1.filter { it.id == id }.first()
    }

    fun deleteCustomer(id:Long) {
        customers1.removeIf { it.id == id }
    }

    fun postCustomers( customer:CustomerModel){
        var id = if(customers1.isEmpty()){
            1
        }else{
            customers1.last().id+1
        }
        customers1.add(CustomerModel(id,customer.name,customer.email))
    }

}