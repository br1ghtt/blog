package ch.buedev.examples.blog.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class Book(
    var title: String,
    @ManyToOne var author: MyUser,
    @Id @GeneratedValue var id: Long? = null
)
