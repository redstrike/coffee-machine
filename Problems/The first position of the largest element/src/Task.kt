import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var largestNum = Int.MIN_VALUE
    var largestNumPos = 1
    var numPos = 1
    while (scanner.hasNextInt()) {
        val num = scanner.nextInt()
        if (largestNum < num) {
            largestNum = num
            largestNumPos = numPos
        }
        numPos++
    }
    print("$largestNum $largestNumPos")
}