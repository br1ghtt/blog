package ch.buedev.examples.blog

import ch.buedev.examples.blog.extensions.toSlug
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeAll
    fun setup() {
        println(">> Setup")

    }

    @Test
    fun `Assert blog page title, content and status code`() {
        val entity = restTemplate.getForEntity<String>("/")
        assertEquals(entity.statusCode, HttpStatus.OK)
        assertTrue(entity.body?.contains("<h1>Blog</h1>")!!)
        println(entity.body)
    }

    @Test
    fun `Assert article page title, content and status code`() {
        val title = "Lorem"
        val entity = restTemplate.getForEntity<String>("/article/${title.toSlug()}")
        assertEquals(entity.statusCode, HttpStatus.OK)
        assertTrue(entity.body?.contains(title)!!)
        assertTrue(entity.body?.contains("Lorem")!!)

    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }

}