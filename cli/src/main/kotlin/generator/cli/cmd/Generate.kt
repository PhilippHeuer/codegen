package generator.cli.cmd

import generator.lib.generator.GeneratorService
import generator.lib.generator.api.GeneratorConfig
import generator.lib.parser.OpenAPIParser
import kotlinx.cli.ArgType
import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand
import kotlinx.cli.required
import org.slf4j.LoggerFactory
import kotlin.system.exitProcess


@OptIn(ExperimentalCli::class)
class Generate: Subcommand("generate", "Generate") {
    private val log = LoggerFactory.getLogger(javaClass)

    private val input by option(ArgType.String, fullName = "input", shortName = "i", description = "OpenAPI Spec").required()
    private val output by option(ArgType.String, fullName = "output", shortName = "o", description = "Output directory").required()
    private val generator by option(ArgType.String, fullName = "generator", shortName = "g", description = "Generator").required()

    override fun execute() {
        log.atInfo().addKeyValue("input", input).addKeyValue("output", output).addKeyValue("generator", generator).log("cmd.generate")

        // openapi spec
        val result = OpenAPIParser.parse(input)
        if (result.openAPI == null) {
            log.error("failed to load openapi spec: {}", result.messages.joinToString(","))
            exitProcess(1)
        }

        val config = GeneratorConfig(
            inputSpec = input,
            outputDirectory = output,
            generator = generator,
        )
        GeneratorService.generate(config, result.openAPI)
    }
}
