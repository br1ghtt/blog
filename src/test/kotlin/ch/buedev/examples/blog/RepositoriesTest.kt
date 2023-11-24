package ch.buedev.examples.blog

import ch.buedev.examples.blog.model.Article
import ch.buedev.examples.blog.model.MyUser
import ch.buedev.examples.blog.repository.ArticleRepository
import ch.buedev.examples.blog.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val articleRepository: ArticleRepository,
    val userRepository: UserRepository
) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val johnDoe = MyUser(login = "johnDoe", firstname = "John", lastname = "Doe")
        entityManager.persist(johnDoe)
        val article = Article(title = "Lorem", headline = "Lorem", content = "loresim", author = johnDoe)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(id = article.id!!)
        assertEquals(found, article)
    }

    @Test
    fun `When findByLogin the return MyUser`() {
        val myUser = MyUser(login = "Me", firstname = "You", lastname = "He")
        entityManager.persist(myUser)
        entityManager.flush()
        userRepository.findByLogin(login = myUser.login).apply {
            assertEquals(this, myUser)
        }
    }
}