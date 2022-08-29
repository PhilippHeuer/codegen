package generator.lib.templateengine.pebble.filter

import com.mitchellbosecke.pebble.extension.Filter
import com.mitchellbosecke.pebble.template.EvaluationContext
import com.mitchellbosecke.pebble.template.PebbleTemplate
import org.apache.commons.lang3.StringUtils

class PadRightFilter : Filter {
    override fun getArgumentNames(): List<String> {
        return mutableListOf("length")
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

        val length = args["length"] as Long?

        var input = inputObj.toString()
        if (input.length < length!!) {
            input += StringUtils.repeat(" ", (length - input.length).toInt())
            return input
        }
        return inputObj
    }
}
