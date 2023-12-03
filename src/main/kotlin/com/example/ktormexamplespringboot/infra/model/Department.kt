package com.example.ktormexamplespringboot.infra.model

import org.ktorm.entity.Entity
import org.ktorm.ksp.api.Column
import org.ktorm.ksp.api.PrimaryKey
import org.ktorm.ksp.api.Table

@Table(tableName = "t_department", schema = "main")
interface Department : Entity<Department> {

    @PrimaryKey
    @Column(columnName = "id")
    val id: Int

    @Column(columnName = "name")
    val name: String

    @Column(columnName = "location")
    val location: String
}