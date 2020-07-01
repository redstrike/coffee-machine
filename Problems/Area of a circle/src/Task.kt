import java.util.Scanner
import kotlin.math.pow

fun main() {
    val scanner = Scanner(System.`in`)
    val radius = scanner.nextDouble()
    val areaOfCircle = 3.1415 * radius.pow(2)
    print(areaOfCircle)
}