package generator.lib.generator.api

class GeneratorConfig(
    val generator: String,
    val inputSpec: String,
    val outputDirectory: String
) {
    override fun toString(): String {
        return "GeneratorConfig(generator='$generator', inputSpec='$inputSpec', outputDirectory='$outputDirectory')"
    }
}
