import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val tempInC = scanner.nextDouble()
    // fahrenheit = celsius * 1.8 + 32
    val tempInF = tempInC * 1.8 + 32
    println(tempInF)
}