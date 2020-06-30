package machine

import java.util.Scanner

fun main() {
    val storage = MachineStorage(400, 540, 120, 9, 550)
    val coffeeMachine = CoffeeMachine(storage)
    coffeeMachine.on()
}

enum class Recipe(val water: Int, val milk: Int, val beans: Int, val price: Int) {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);
}

data class MachineStorage(var water: Int = 0, var milk: Int = 0, var beans: Int = 0, var cups: Int, var money: Int)

enum class MachineState {
    OFF, WAITING_FOR_ACTION, WAITING_BUY_OPTION, SERVING_COFFEE, WAITING_FOR_FILLING
}

class CoffeeMachine(private val storage: MachineStorage) {
    var state = MachineState.OFF
    private val scanner = Scanner(System.`in`)

    fun on() {
        state = MachineState.WAITING_FOR_ACTION
        while (state != MachineState.OFF) {
            if (state == MachineState.WAITING_FOR_ACTION) {
                print("Write action (buy, fill, take, remaining, exit): ")
            }
            process(scanner.next())
        }
    }

    private fun process(input: String) {
        when (input) {
            "buy" -> {
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                state = MachineState.WAITING_BUY_OPTION
            }
            "1" -> serve(Recipe.ESPRESSO)
            "2" -> serve(Recipe.LATTE)
            "3" -> serve(Recipe.CAPPUCCINO)
            "back" -> {
                println()
                state = MachineState.WAITING_FOR_ACTION
            }
            "fill" -> fill()
            "take" -> take()
            "remaining" -> printMachineStorage()
            "exit" -> off()
        }
    }

    private fun serve(recipe: Recipe) {
        state = MachineState.SERVING_COFFEE
        val lackingSupply = when {
            storage.water < recipe.water -> "water"
            storage.milk < recipe.milk -> "milk"
            storage.beans < recipe.beans -> "coffee beans"
            storage.cups < 1 -> "cup"
            else -> ""
        }
        if (lackingSupply != "") {
            println("Sorry, not enough $lackingSupply!\n")
        } else {
            println("I have enough resources, making you a coffee!\n")
            storage.cups -= 1
            storage.water -= recipe.water
            storage.milk -= recipe.milk
            storage.beans -= recipe.beans
            storage.money += recipe.price
        }
        state = MachineState.WAITING_FOR_ACTION
    }

    private fun fill() {
        state = MachineState.WAITING_FOR_FILLING
        print("Write how many ml of water do you want to add: ")
        storage.water += scanner.nextInt()
        print("Write how many ml of milk do you want to add: ")
        storage.milk += scanner.nextInt()
        print("Write how many grams of coffee beans do you want to add: ")
        storage.beans += scanner.nextInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        storage.cups += scanner.nextInt()
        println()
        state = MachineState.WAITING_FOR_ACTION
    }

    private fun take() {
        println("I gave you $${storage.money}\n")
        storage.money = 0
    }

    private fun off() {
        state = MachineState.OFF
        println("Turning off coffee machine...")
    }

    private fun printMachineStorage() {
        println("\nThe coffee machine has:")
        println("${storage.water} of water")
        println("${storage.milk} of milk")
        println("${storage.beans} of coffee beans")
        println("${storage.cups} of disposable cups")
        println("$${storage.money} of money\n")
    }
}
