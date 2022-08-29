package generator.lib.generator.java

import generator.lib.generator.api.GeneratorConfig
import generator.lib.generator.api.IGenerator
import generator.lib.parser.getEndpoints
import generator.lib.util.toJSON
import io.swagger.v3.oas.models.OpenAPI
import org.slf4j.LoggerFactory

class JavaFeignGenerator : IGenerator {
    override fun getName(): String {
        return "java-feign"
    }

    override fun execute(config: GeneratorConfig, spec: OpenAPI) {
        println(config)

        println(spec.getEndpoints().toJSON())
        // println(spec)
    }

    companion object {
        private val log = LoggerFactory.getLogger(javaClass)
    }
}
