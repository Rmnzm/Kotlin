fun main() {
    runSimulation()
//    p(y = 10, printer = fun(x: Int) { println(2 * x)})
//    p(y = 10) { println(2 * it)}
//    p(y = 10) {
//        println(2 * it)
//        4 * it
//    }
}

fun p(y: Int, printer: (x: Int) -> Int) {
    printer(y)
}
fun runSimulation () {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Guyal"))
    println(greetingFunction("Guyal"))
}

fun prinlnConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construnction cost: ${cost * numBuildings}")
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcoe to SimVillage, $playerName! (copyright $currentYear)"
    }
}