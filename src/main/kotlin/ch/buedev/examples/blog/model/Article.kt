package ch.buedev.examples.blog.model

import ch.buedev.examples.blog.extensions.toSlug
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDateTime
import java.util.*

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne var author: MyUser,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.UUID) @JdbcTypeCode(SqlTypes.VARCHAR) var id: UUID? = null
)