class Application(val name: String) {

    fun run(strings: Array<String>) {
        println(name)
        for (str in strings) {
            println(str)
        }
    }
}