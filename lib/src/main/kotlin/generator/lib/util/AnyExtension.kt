package generator.lib.util

import com.fasterxml.jackson.databind.ObjectMapper

private val objectMapper = ObjectMapper()

fun Any.toJSON(): String {
    return objectMapper.writeValueAsString(this)
}
