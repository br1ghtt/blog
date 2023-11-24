package ch.buedev.examples.blog.repository

import ch.buedev.examples.blog.model.Article
import ch.buedev.examples.blog.model.MyUser
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

interface UserRepository : CrudRepository<MyUser, Long> {
    fun findByLogin(login: String): MyUser?
}