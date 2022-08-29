package generator.lib.templateengine.pebble.filter

import com.mitchellbosecke.pebble.extension.Filter
import com.mitchellbosecke.pebble.template.EvaluationContext
import com.mitchellbosecke.pebble.template.PebbleTemplate

class WrapInFilter : Filter {
    override fun getArgumentNames(): List<String> {
        return mutableListOf("left", "right")
    }

    override fun apply(
        inputObj: Any?,
        args: Map<String, Any>,
        self: PebbleTemplate,
        context: EvaluationContext,
        lineNumber: Int
    ): Any? {
        if (inputObj == null) {
            return null
        }

        val left = args["left"] as String?
        val right = args["right"] as String?
        return left + inputObj + right
    }
}
