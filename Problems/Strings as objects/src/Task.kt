fun main() {
    val input = readLine()!!
    if (input.isEmpty()) {
        return println()
    }
    println(when (input.first()) {
        'i' -> {
            input.drop(1).toInt() + 1
        }
        's' -> {
            input.drop(1).reversed()
        }
        else -> input
    })
}