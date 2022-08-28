package generator.lib.generator

import generator.lib.api.IGenerator
import io.swagger.v3.oas.models.OpenAPI

class JavaFeignGenerator : IGenerator {
    override fun getName(): String {
        return "java-feign"
    }

    override fun execute(spec: OpenAPI) {
        println(spec)
    }
}