package generator.lib.templateengine.api

interface ITemplateEngine {
    val name: String
    val fileExtensions: Array<String>

    fun renderTemplate(file: String, context: Map<String, Any>): String
}
