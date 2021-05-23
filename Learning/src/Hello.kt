
import shapes.Rectangle
import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.util.*

fun max(a: Int, b: Int): Int{
    return if (a > b) a else b
}

fun getMnemonic(color: Color) =
    when (color){
        Color.RED -> "Every"
        Color.ORANGE -> "Hunter"
        Color.YELLOW -> "Wants"
        Color.GREEN -> "to Know"
        Color.BLUE -> "Where"
        Color.INDIGO -> "the Bird"
        Color.VIOLET -> "is sitting"
    }

fun getWarmth(color: Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "теплый"
    Color.GREEN -> "нейтральный"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "холодный"
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)){
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Грязный цвет")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == Color.RED && c2 == Color.YELLOW) || (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
        (c1 == Color.YELLOW && c2 == Color.BLUE) || (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET) || (c1 == Color.VIOLET && c2 == Color.BLUE) -> Color.INDIGO
        else -> throw Exception("Dirty color")

    }

fun eval(e: Expr): Int{
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun evalWithLogging(e: Expr): Int =
    when (e){
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

// Игра Fizz Buzz
fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0-> "Fizz"
    i % 5 == 0-> "Buzz"
    else -> "$i"
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch(e: NumberFormatException){
        return null
    }
    finally {
        reader.close()
    }
}


fun main(args: Array<String>){
//    val name = if (args.size > 0) args[0] else "Kotlin"
//
//    println("Hello, $name")
//
//    val person = Person("Bob", true)
//    println(person.isMarried)
//
//    val rectangle = Rectangle(41,43)
//    println(rectangle.isSquare)
//
//    println(Color.BLUE.rgb())
//
//    println(getMnemonic(Color.BLUE))
//
//    println(getWarmth(Color.ORANGE))
//
//    println(mix(Color.BLUE, Color.YELLOW))
//
//    println(mixOptimized(Color.BLUE, Color.YELLOW))
//
//    val num = Sum(Sum(Num(1), Num(2)), Num(4))
//    println(num)

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))

    println(evalWithLogging(Sum(Sum(Num(1),Num(2)), Num(4))))
//// Простая игра Fizz Buzz
//
//    for (i in 1..100) {
//        println(fizzBuzz(i))
//    }
//
//// Усложнили игру
//
//    for (i in 100 downTo 1 step 2) {
//        println(fizzBuzz(i))
//    }

//    Вывод кодов символов в двоичном представлении
//    val binaryReps = TreeMap<Char, String>()
//    for (c in 'A'..'F'){
//        val binary = Integer.toBinaryString((c.toInt()))
//        binaryReps[c] = binary
//    }
//
//    for ((letter, binary) in binaryReps){
//        println("$letter = $binary")
//    }

    println(isLetter('q'))
    println(isNotDigit('9'))

    println(recognize('8'))

    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
}