fun main() {
    val name ="Marginal"
    var healthPoints = 100
    var karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()
    var isBlessed = true
    val isImmortal = false
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    healthPoints -= 17

    val auraColor = if (auraVisible) {
        when (karma) {
            in 0..5 -> "RED"
            in 6..10 -> "ORANGE"
            in 11..15 -> "PURPLE"
            in 16..20 -> "GREEN"
            else -> ""
        }
    } else {
        "NONE"
    }

    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "elf "
    }

    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "Yes" else "NO"})")

    println("$name $healthStatus")

    val HP = "$healthPoints"
    val A = "$auraColor"
    val H = "$name + $healthStatus"

    val statusFormatString = "(HP: $HP)(A: $A) -> $H"
    println(statusFormatString)
}