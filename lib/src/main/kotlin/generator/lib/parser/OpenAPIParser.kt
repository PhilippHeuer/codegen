package generator.lib.parser

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.parser.OpenAPIV3Parser
import io.swagger.v3.parser.core.models.ParseOptions
import io.swagger.v3.parser.core.models.SwaggerParseResult

class OpenAPIParser {
    companion object {
        /**
         * parse the openapi spec
         */
        fun parse(input: String): SwaggerParseResult {
            val parseOptions = ParseOptions()
            parseOptions.isResolve = true
            parseOptions.isResolveFully = true
            return OpenAPIV3Parser().readLocation(input, null, parseOptions)
        }
    }

}
