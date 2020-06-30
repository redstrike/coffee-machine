class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value < -92 || value > 57) {
                when (name) {
                    "Moscow" -> 5
                    "Hanoi" -> 20
                    "Dubai" -> 30
                    else -> value
                }
            } else value
        }

    fun isMinOf(city1: City, city2: City): Boolean {
        return degrees < city1.degrees && degrees < city2.degrees
    }
}

fun main() {
    val dubai = City("Dubai")
    dubai.degrees = readLine()!!.toInt()
    val moscow = City("Moscow")
    moscow.degrees = readLine()!!.toInt()
    val hanoi = City("Hanoi")
    hanoi.degrees = readLine()!!.toInt()

    print(when {
        dubai.isMinOf(moscow, hanoi) -> dubai.name
        moscow.isMinOf(dubai, hanoi) -> moscow.name
        hanoi.isMinOf(dubai, moscow) -> hanoi.name
        else -> "neither"
    })
}