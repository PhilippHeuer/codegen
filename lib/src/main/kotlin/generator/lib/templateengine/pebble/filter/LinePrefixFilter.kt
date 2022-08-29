package generator.lib.templateengine.pebble.filter

import com.mitchellbosecke.pebble.extension.Filter
import com.mitchellbosecke.pebble.template.EvaluationContext
import com.mitchellbosecke.pebble.template.PebbleTemplate

class LinePrefixFilter : Filter {
    override fun getArgumentNames(): List<String> {
        return mutableListOf("prefix")
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

        val prefix = args["prefix"] as String?
        val output = StringBuffer()
        inputObj.toString().split("\n").map { it -> output.append(prefix + it + "\r\n") }
        return output.toString()
    }
}
