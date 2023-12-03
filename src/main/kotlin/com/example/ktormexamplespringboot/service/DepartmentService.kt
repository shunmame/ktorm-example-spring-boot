package com.example.ktormexamplespringboot.service

import com.example.ktormexamplespringboot.domain.AddRequest
import com.example.ktormexamplespringboot.domain.Department
import com.example.ktormexamplespringboot.domain.UpdateRequest
import com.example.ktormexamplespringboot.infra.repository.DepartmentRepositoryImpl
import org.springframework.stereotype.Service

@Service
class DepartmentService(
    private val departmentRepositoryImpl: DepartmentRepositoryImpl
) {

    fun addDepartment(addRequest: AddRequest) {
        departmentRepositoryImpl.insert(addRequest)
    }

    fun updateDepartment(updateRequest: UpdateRequest) {
        departmentRepositoryImpl.update(updateRequest)
    }

    fun getDepartments(id: Int): List<Department> =
        if (id == 0) departmentRepositoryImpl.fetchAll() else departmentRepositoryImpl.fetchById(id)

    fun deleteDepartment(id: Int) {
        departmentRepositoryImpl.delete(id)
    }
}