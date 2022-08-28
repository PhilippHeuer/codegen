package generator.lib.api

import io.swagger.v3.oas.models.OpenAPI

interface IGenerator {

    fun getName(): String

    fun execute(spec: OpenAPI)

}
