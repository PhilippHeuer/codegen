package generator.lib.templateengine.pebble

import com.mitchellbosecke.pebble.attributes.AttributeResolver
import com.mitchellbosecke.pebble.extension.Extension
import com.mitchellbosecke.pebble.extension.Filter
import com.mitchellbosecke.pebble.extension.Function
import com.mitchellbosecke.pebble.extension.NodeVisitorFactory
import com.mitchellbosecke.pebble.extension.Test
import com.mitchellbosecke.pebble.operator.BinaryOperator
import com.mitchellbosecke.pebble.operator.UnaryOperator
import com.mitchellbosecke.pebble.tokenParser.TokenParser
import generator.lib.templateengine.pebble.filter.LinePrefixFilter
import generator.lib.templateengine.pebble.filter.PadRightFilter
import generator.lib.templateengine.pebble.filter.WrapInFilter
import generator.lib.templateengine.pebble.operator.StartsWithOperator

class CodeGenPebbleExtension : Extension {
    override fun getFilters(): MutableMap<String, Filter> {
        return mutableMapOf(
            "padright" to PadRightFilter(),
            "wrapin" to WrapInFilter(),
            "lineprefix" to LinePrefixFilter()
        )
    }

    override fun getTests(): MutableMap<String, Test> {
        return mutableMapOf()
    }

    override fun getFunctions(): MutableMap<String, Function> {
        return mutableMapOf()
    }

    override fun getTokenParsers(): MutableList<TokenParser> {
        return mutableListOf()
    }

    override fun getBinaryOperators(): MutableList<BinaryOperator> {
        return mutableListOf(StartsWithOperator())
    }

    override fun getUnaryOperators(): MutableList<UnaryOperator> {
        return mutableListOf()
    }

    override fun getGlobalVariables(): MutableMap<String, Any> {
        return mutableMapOf()
    }

    override fun getNodeVisitors(): MutableList<NodeVisitorFactory> {
        return mutableListOf()
    }

    override fun getAttributeResolver(): MutableList<AttributeResolver> {
        return mutableListOf()
    }

}
