package com.example.ktormexamplespringboot.infra.repository

import com.example.ktormexamplespringboot.domain.AddRequest
import com.example.ktormexamplespringboot.domain.Department
import com.example.ktormexamplespringboot.domain.UpdateRequest
import com.example.ktormexamplespringboot.infra.dao.DepartmentDao
import org.springframework.stereotype.Repository

@Repository
class DepartmentRepositoryImpl(
    private val departmentDao: DepartmentDao
) {

    fun insert(addRequest: AddRequest) {
        departmentDao.insert(addRequest)
    }

    fun update(updateRequest: UpdateRequest) {
        departmentDao.update(updateRequest)
    }

    fun fetchAll(): List<Department> = departmentDao.fetchAll().map {
        Department(
            id = it.id,
            name = it.name,
            location = it.location
        )
    }

    fun delete(id: Int) {
        departmentDao.delete(id)
    }

    fun fetchById(id: Int): List<Department> = departmentDao.fetchById(id)?.let {
        listOf(
            Department(
                id = it.id,
                name = it.name,
                location = it.location
            )
        )
    } ?: run {
        emptyList()
    }
}