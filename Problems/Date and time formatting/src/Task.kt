import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val h = scanner.nextInt()
    val m = scanner.nextInt()
    val s = scanner.nextInt()
    val d = scanner.nextInt()
    val month = scanner.nextInt()
    val y = scanner.nextInt()
    print("$h:$m:$s $d/$month/$y")
}