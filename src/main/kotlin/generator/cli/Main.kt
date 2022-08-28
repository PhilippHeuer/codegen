package generator.cli;

import generator.cli.cmd.Generate
import generator.cli.cmd.Version
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.ExperimentalCli

@OptIn(ExperimentalCli::class)
fun main(args: Array<String>) {
    val parser = ArgParser("codegen", strictSubcommandOptionsOrder = true)
    val loglevel by parser.option(ArgType.String, "loglevel", "l", "LogLevel")
    parser.subcommands(Generate(), Version())
    parser.parse(args)
}
