import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val num = scanner.nextInt()
    var n = 1
    do {
        val square = n * n
        if (square <= num) {
            println(square)
        }
        n++
    } while (square < num)
}