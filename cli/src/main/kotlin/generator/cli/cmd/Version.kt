package generator.cli.cmd

import kotlinx.cli.ExperimentalCli
import kotlinx.cli.Subcommand

@OptIn(ExperimentalCli::class)
class Version: Subcommand("version", "") {
    override fun execute() {
        println("generator v0.0.0")
    }
}
