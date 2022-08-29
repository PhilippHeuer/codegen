package generator.lib.generator

import generator.lib.generator.api.GeneratorConfig
import generator.lib.generator.api.IGenerator
import generator.lib.generator.java.JavaFeignGenerator
import io.swagger.v3.oas.models.OpenAPI
import org.slf4j.LoggerFactory

class GeneratorService {
    companion object {
        private val log = LoggerFactory.getLogger(javaClass)

        private val generators = listOf<IGenerator>(JavaFeignGenerator())

        fun generate(config: GeneratorConfig, spec: OpenAPI) {
            val generator = generators.find { g -> g.getName() == config.generator }
            generator?.let {
                log.atInfo().addKeyValue("generator", config.generator).log("generator.run")
                it.execute(config, spec)
            }
        }
    }
}
