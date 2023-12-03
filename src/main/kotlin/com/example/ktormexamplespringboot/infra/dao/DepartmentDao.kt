package com.example.ktormexamplespringboot.infra.dao

import com.example.ktormexamplespringboot.domain.AddRequest
import com.example.ktormexamplespringboot.domain.UpdateRequest
import com.example.ktormexamplespringboot.infra.model.Department
import com.example.ktormexamplespringboot.infra.model.Departments
import com.example.ktormexamplespringboot.infra.model.departments
import org.ktorm.dsl.eq
import org.ktorm.dsl.insert
import org.ktorm.dsl.update
import org.ktorm.entity.firstOrNull
import org.ktorm.entity.removeIf
import org.ktorm.entity.toList
import org.springframework.stereotype.Component

@Component
class DepartmentDao : BaseDao<Department, Departments>() {

    fun insert(addRequest: AddRequest) {
        database.insert(Departments) {
            set(Departments.name, addRequest.name)
            set(Departments.location, addRequest.location)
        }
    }

    fun update(updateRequest: UpdateRequest) {
        database.update(Departments) {
            set(Departments.name, updateRequest.name)
            set(Departments.location, updateRequest.location)
            where {
                Departments.id eq updateRequest.id
            }
        }
    }

    fun fetchAll(): List<Department> = database.departments.toList()

    fun delete(id: Int) {
        database.departments.removeIf { id eq Departments.id }
    }

    fun fetchById(id: Int): Department? {
        return database.departments.firstOrNull { Departments.id eq id }
    }
}