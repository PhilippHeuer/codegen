package generator.lib.schema

import io.swagger.v3.oas.models.OpenAPI

open class GenericTemplateData(
    val spec: OpenAPI
) {
    fun init() {
        spec.servers.forEach { s ->
            s.url
        }
    }
}
