package generator.lib.generator

import generator.lib.api.IGenerator
import io.swagger.v3.oas.models.OpenAPI

class Generator {
    companion object {
        private val generators = listOf<IGenerator>(JavaFeignGenerator())

        fun generate(name: String, spec: OpenAPI) {
            val generator = generators.find { g -> g.getName() == name }
            generator?.execute(spec)
        }
    }
}