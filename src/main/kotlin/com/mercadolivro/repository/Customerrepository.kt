package com.mercadolivro.repository

import com.mercadolivro.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface Customerrepository : CrudRepository<CustomerModel, Int>{

    fun findByNameContainig(name:String): List<CustomerModel>
}