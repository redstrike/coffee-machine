import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val num = scanner.nextInt()
    if (num % 2 == 0) {
        print("EVEN")
    } else {
        print("ODD")
    }
}