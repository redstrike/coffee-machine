import java.util.Scanner

const val EURO = "Euro"
const val XOF = "CFA franc"
const val XCD = "Eastern Caribbean dollar"
const val CAD = "Canadian dollar"
const val AUD = "Australian dollar"
const val BRL = "Brazilian real"

enum class Country(val currency: String) {
    Germany(EURO),
    Mali(XOF),
    Dominica(XCD),
    Canada(CAD),
    Spain(EURO),
    Australia(AUD),
    Brazil(BRL),
    Senegal(XOF),
    France(EURO),
    Grenada(XCD),
    Kiribati(AUD);
}

fun main() {
    val input = Scanner(System.`in`)
    val country1 = input.next()
    val country2 = input.next()
    try {
        val c1Currency = Country.valueOf(country1).currency
        val c2Currency = Country.valueOf(country2).currency
        print(c1Currency == c2Currency)
    } catch (err: IllegalArgumentException) {
        print(false)
    }
}