package ch.buedev.examples.blog

import ch.buedev.examples.blog.config.BlogProperties
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class BlogApplication

fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}
