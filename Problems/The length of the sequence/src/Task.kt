import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var length = 0
    while (scanner.nextInt() > 0) {
        length++
    }
    print(length)
}