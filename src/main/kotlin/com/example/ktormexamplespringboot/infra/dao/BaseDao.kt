package com.example.ktormexamplespringboot.infra.dao

import org.ktorm.database.Database
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.springframework.beans.factory.annotation.Autowired

abstract class BaseDao<E : Entity<E>, T : Table<E>> {

    @Autowired
    protected lateinit var database: Database
}