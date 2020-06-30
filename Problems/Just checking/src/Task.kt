import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val num = scanner.nextInt()
    print(when (num) {
        2 -> "Yes!"
        1, 3, 4 -> "No!"
        else -> "Unknown number"
    })
}