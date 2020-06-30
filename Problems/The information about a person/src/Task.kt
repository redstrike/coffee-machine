import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val firstName = scanner.next()
    val lastName = scanner.next()
    val age = scanner.nextByte()
    print("${firstName.first()}. $lastName, $age years old")
}