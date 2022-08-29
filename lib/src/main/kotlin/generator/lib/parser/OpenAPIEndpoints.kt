package generator.lib.parser

import generator.lib.schema.domain.Endpoint
import generator.lib.util.toSlug
import io.swagger.v3.oas.models.OpenAPI

fun OpenAPI.getEndpoints(): List<Endpoint> {
    val endpoints = mutableListOf<Endpoint>()

    servers.forEach { server ->
        var urlWithoutPrefix = server.url.removePrefix("http://").removePrefix("https://")
        if (server.variables?.isNotEmpty() == true) {
            // use default values
            var url = server.url
            server.variables.forEach { v ->
                url = url.replace("{${v.key}}", v.value.default)
                urlWithoutPrefix = urlWithoutPrefix.replace("{${v.key}}", v.value.default)
            }

            // add endpoint
            endpoints.add(Endpoint(
                extensions = server.extensions ?: mutableMapOf(),
                name = urlWithoutPrefix.toSlug(),
                description = server.description,
                url = url,
                variables = server.variables
            ))
        } else {
            endpoints.add(Endpoint(
                extensions = server.extensions ?: mutableMapOf(),
                name = urlWithoutPrefix.toSlug(),
                description = server.description,
                url = server.url,
                variables = server.variables
            ))
        }
    }

    return endpoints
}




