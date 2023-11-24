package ch.buedev.examples.blog.repository

import ch.buedev.examples.blog.model.Article
import ch.buedev.examples.blog.model.MyUser
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ArticleRepository : CrudRepository<Article, UUID> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

interface UserRepository : CrudRepository<MyUser, UUID> {
    fun findByLogin(login: String): MyUser?
}