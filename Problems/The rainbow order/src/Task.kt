enum class Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }

fun main() {
    val color = readLine()!!.toUpperCase()
    print(Rainbow.valueOf(color).ordinal + 1)
}
