package generator.cli

import kotlin.test.Test

/**
 * CLI Tests
 */
class CLITest {

    @Test
    fun generateCmd() {
        main(arrayOf("gen", "--input", "./files/petstore.yaml", "--output", "generated", "--generator", "java-feign"))
    }

    @Test
    fun versionCmd() {
        main(arrayOf("version"))
    }

}
