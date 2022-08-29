package generator.lib.templateengine.pebble

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.mitchellbosecke.pebble.PebbleEngine
import com.mitchellbosecke.pebble.loader.ClasspathLoader
import com.mitchellbosecke.pebble.loader.DelegatingLoader
import generator.lib.templateengine.api.ITemplateEngine
import org.slf4j.LoggerFactory
import java.io.StringWriter

class PebbleTemplateEngine : ITemplateEngine {
    private val log = LoggerFactory.getLogger(javaClass)
    private val engine: PebbleEngine = PebbleEngine.Builder()
        .cacheActive(false)
        .newLineTrimming(true)
        .extension(CodeGenPebbleExtension())
        .autoEscaping(false)
        .loader(DelegatingLoader(listOf(ClasspathLoader())))
        .build()
    override val name: String = "pebble"
    override val fileExtensions: Array<String> = arrayOf("peb", "pebble")

    override fun renderTemplate(file: String, data: Map<String, Any>): String {
        log.debug("Processing Pebble Template: {}", file);
        if (log.isTraceEnabled) {
            log.debug("Bundle Data: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
        }

        // render
        val writer = StringWriter()
        val compiledTemplate = engine.getTemplate(file);
        compiledTemplate.evaluate(writer, data);
        return writer.toString();
    }

    companion object {
        private val objectMapper = ObjectMapper()

        fun init() {
            objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        }
    }
}
