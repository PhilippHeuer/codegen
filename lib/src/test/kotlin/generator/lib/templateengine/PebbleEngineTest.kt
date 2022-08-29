package generator.lib.templateengine

import kotlin.test.Test
import kotlin.test.assertEquals

class PebbleEngineTest {

    @Test
    fun pebbleRender() {
        assertEquals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", TemplateEngineService.render("pebble", "templates/pebble_test/basic.peb", mapOf()))
    }

}
