package generator.lib.util

import java.text.Normalizer
import java.util.regex.Pattern

private val NONLATIN = Pattern.compile("[^\\w-]")
private val WHITESPACE = Pattern.compile("[\\s]")

fun String.toSlug(): String {
    val noWhiteSpace = WHITESPACE.matcher(this).replaceAll("-")
    val normalized: String = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD)
    val slug = NONLATIN.matcher(normalized).replaceAll("")
    return slug.lowercase()
}

