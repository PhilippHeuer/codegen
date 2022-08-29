package generator.lib.templateengine

import generator.lib.templateengine.api.ITemplateEngine
import generator.lib.templateengine.pebble.PebbleTemplateEngine
import io.swagger.v3.oas.models.OpenAPI

class TemplateEngineService {
    companion object {
        private val templateEngines = listOf<ITemplateEngine>(PebbleTemplateEngine())

        fun render(engine: String, file: String, data: Map<String, Any>): String? {
            val engine = templateEngines.find { g -> g.name == engine }
            return engine?.renderTemplate(file, data)
        }
    }
}
