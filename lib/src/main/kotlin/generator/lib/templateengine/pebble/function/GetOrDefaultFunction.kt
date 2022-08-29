package generator.lib.templateengine.pebble.function

import com.mitchellbosecke.pebble.extension.Function
import com.mitchellbosecke.pebble.template.EvaluationContext
import com.mitchellbosecke.pebble.template.PebbleTemplate
import org.apache.commons.lang3.StringUtils

class GetOrDefaultFunction : Function {
    override fun getArgumentNames(): List<String> {
        return mutableListOf("get", "default")
    }

    override fun execute(
        args: Map<String, Any>,
        self: PebbleTemplate,
        context: EvaluationContext,
        lineNumber: Int
    ): Any? {
        val left = args["get"] as String
        return if (StringUtils.isEmpty(left)) { args["default"] } else left
    }
}
