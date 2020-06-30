import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val str = scanner.nextLine()
    val index = scanner.nextInt()
    println("Symbol # $index of the string \"$str\" is '${str[index - 1]}'")
}