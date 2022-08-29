package generator.lib.generator.api

import io.swagger.v3.oas.models.OpenAPI

interface IGenerator {

    fun getName(): String

    fun execute(config: GeneratorConfig, spec: OpenAPI)

}
