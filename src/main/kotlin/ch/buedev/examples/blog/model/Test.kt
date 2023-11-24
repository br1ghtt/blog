package ch.buedev.examples.blog.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*

@Entity
class Test(
    @Id @GeneratedValue(strategy = GenerationType.UUID) var id: UUID? = null
)