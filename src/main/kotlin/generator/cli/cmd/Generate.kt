package generator.cli.cmd

import kotlinx.cli.ArgType
import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand
import org.slf4j.LoggerFactory
import java.io.File

@OptIn(ExperimentalCli::class)
class Generate: Subcommand("gen", "Generate") {
    private val log = LoggerFactory.getLogger(javaClass)

    private val input by option(ArgType.String, fullName = "input", shortName = "i", description = "OpenAPI Spec")
    private val output by option(ArgType.String, fullName = "output", shortName = "o", description = "Output directory")

    override fun execute() {
        log.atInfo().addKeyValue("input", input).addKeyValue("output", output).log("cmd.generate")

        val content = File(input).readLines()
        println(content)
    }
}
