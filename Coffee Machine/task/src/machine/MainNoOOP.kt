package machine

import java.util.Scanner

const val ESPRESSO = "1"
const val WATER_PER_ESPRESSO = 250
const val MILK_PER_ESPRESSO = 0
const val BEANS_PER_ESPRESSO = 16
const val COST_PER_ESPRESSO = 4

const val LATTE = "2"
const val WATER_PER_LATTE = 350
const val MILK_PER_LATTE = 75
const val BEANS_PER_LATTE = 20
const val COST_PER_LATTE = 7

const val CAPPUCCINO = "3"
const val WATER_PER_CAPPUCCINO = 200
const val MILK_PER_CAPPUCCINO = 100
const val BEANS_PER_CAPPUCCINO = 12
const val COST_PER_CAPPUCCINO = 6

var water = 400
var milk = 540
var beans = 120
var cups = 9
var money = 550

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        when (scanner.next()) {
            "remaining" -> printMachineState(water, milk, beans, cups, money)
            "exit" -> return
            "buy" -> {
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                when (scanner.next()) {
                    ESPRESSO -> checkSupplyAndServe(WATER_PER_ESPRESSO, MILK_PER_ESPRESSO, BEANS_PER_ESPRESSO, COST_PER_ESPRESSO)
                    LATTE -> checkSupplyAndServe(WATER_PER_LATTE, MILK_PER_LATTE, BEANS_PER_LATTE, COST_PER_LATTE)
                    CAPPUCCINO -> checkSupplyAndServe(WATER_PER_CAPPUCCINO, MILK_PER_CAPPUCCINO, BEANS_PER_CAPPUCCINO, COST_PER_CAPPUCCINO)
                }
            }
            "fill" -> {
                print("Write how many ml of water do you want to add: ")
                water += scanner.nextInt()
                print("Write how many ml of milk do you want to add: ")
                milk += scanner.nextInt()
                print("Write how many grams of coffee beans do you want to add: ")
                beans += scanner.nextInt()
                print("Write how many disposable cups of coffee do you want to add: ")
                cups += scanner.nextInt()
            }
            "take" -> {
                println("I gave you $money")
                money = 0
            }
        }
    }
}

fun checkSupplyAndServe(waterPerCup: Int, milkPerCup: Int, beansPerCup: Int, costPerCup: Int) {
    val lackingSupply = when {
        water < waterPerCup -> "water"
        milk < milkPerCup -> "milk"
        beans < beansPerCup -> "coffee beans"
        cups < 1 -> "cup"
        else -> ""
    }
    if (lackingSupply != "") {
        println("Sorry, not enough $lackingSupply!\n")
    } else {
        println("I have enough resources, making you a coffee!\n")
        cups -= 1
        water -= waterPerCup
        milk -= milkPerCup
        beans -= beansPerCup
        money += costPerCup
    }
}

fun printMachineState(water: Int, milk: Int, beans: Int, cups: Int, money: Int) {
    println("\nThe coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$beans of coffee beans")
    println("$cups of disposable cups")
    println("$$money of money\n")
}
