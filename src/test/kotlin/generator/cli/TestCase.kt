package generator.cli

import kotlin.test.Test

class TestCase {

    @Test
    fun generateCmd() {
        main(arrayOf("gen", "--input", "files/petstore.yaml", "--output", "generated"))
    }

    @Test
    fun versionCmd() {
        main(arrayOf("version"))
    }

}