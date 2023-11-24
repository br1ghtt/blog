package ch.buedev.examples.blog.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class MyUser(
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id @GeneratedValue var id: Long? = null
)
