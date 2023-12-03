package com.example.ktormexamplespringboot.usecase

import com.example.ktormexamplespringboot.domain.AddRequest
import com.example.ktormexamplespringboot.domain.Department
import com.example.ktormexamplespringboot.domain.UpdateRequest

class DepartmentUsecase {

    fun addDepartment(addRequest: AddRequest) {
//        departmentRepositoryImpl.insert(addRequest)
    }

    fun updateDepartment(updateRequest: UpdateRequest) {
//        departmentRepositoryImpl.update(updateRequest)
    }

    fun getDepartments(id: Int): List<Department> = emptyList()
//        if (id == 0) departmentRepositoryImpl.fetchAll() else departmentRepositoryImpl.fetchById(id)

    fun deleteDepartment(id: Int) {
//        departmentRepositoryImpl.delete(id)
    }
}