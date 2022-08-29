package generator.lib.templateengine.pebble.function

import com.mitchellbosecke.pebble.extension.Function
import com.mitchellbosecke.pebble.template.EvaluationContext
import com.mitchellbosecke.pebble.template.PebbleTemplate

class NewLineFunction : Function {
    override fun getArgumentNames(): List<String> {
        return mutableListOf()
    }

    override fun execute(
        args: Map<String, Any>,
        self: PebbleTemplate,
        context: EvaluationContext,
        lineNumber: Int
    ): Any {
        return "\r\n"
    }
}
