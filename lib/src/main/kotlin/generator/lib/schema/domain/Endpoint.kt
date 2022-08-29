package generator.lib.schema.domain

import io.swagger.v3.oas.models.servers.ServerVariables

class Endpoint(
    val extensions: MutableMap<String, Any?>,
    val name: String,
    val description: String?,
    val url: String,
    val variables: ServerVariables?,
)
