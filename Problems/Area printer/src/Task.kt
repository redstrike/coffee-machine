data class Rectangle(val width: Int, val height: Int)

fun printArea(rect: Rectangle) {
    print(rect.width * rect.height)
}