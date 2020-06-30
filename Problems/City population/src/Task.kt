data class City(val name: String) {
    var population: Int = 0
        set(value) {
            field = when {
                value < 0 -> 0
                value > 50_000_000 -> 50_000_000
                else -> value
            }
        }
}

// Solutions from other students - thanks :)

//        set(value) {
//            field = if (value < 0) {
//                0
//            } else if (value > 50_000_000) {
//                50_000_000
//            } else {
//                value
//            }
//        }

//        set(value) {
//            field = maxOf(0, minOf(50_000_000, value))
//        }

//        set(value) {
//            field = value.coerceIn(0, 50_000_000)
//        }

//        set(value) {
//            field = value.coerceAtLeast(0).coerceAtMost(50_000_000)
//        }