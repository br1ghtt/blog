package ch.buedev.examples.blog.model

import ch.buedev.examples.blog.extensions.toSlug
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: MyUser,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue var id: Long? = null
)