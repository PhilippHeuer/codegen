package generator.lib.templateengine.pebble.operator

import com.mitchellbosecke.pebble.node.expression.BinaryExpression
import com.mitchellbosecke.pebble.template.EvaluationContextImpl
import com.mitchellbosecke.pebble.template.PebbleTemplateImpl

/**
 * checks if the left argument starts with the right argument
 */
class StartsWithExpression : BinaryExpression<Any?>() {
    override fun evaluate(self: PebbleTemplateImpl, context: EvaluationContextImpl): Any {
        // left & right value
        val left = leftExpression.evaluate(self, context).toString()
        val right = rightExpression.evaluate(self, context).toString()

        return left.startsWith(right)
    }
}
