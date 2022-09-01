package me.jimmyberg.batch.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "MEMBERS")
data class Member(

    @GeneratedValue
    @Id
    val id: Long? = null,
    val name: String,
    val age: Long

)