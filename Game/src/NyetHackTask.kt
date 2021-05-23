fun main() {
    val name ="Marginal"
    var healthPoints = 100
    val isBlessed = true
    val isImmortal = false
    healthPoints -= 17

    //Аура
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    val race = "gnome"
    val faction = when (race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "elf "
    }
    // Состояние игрока
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFureball((0..50).random())
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "Yes" else "NO"})"
    )

    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
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


private fun castFureball(numFireballs: Int = 2) {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
    val drinkyStatus = when (numFireballs) {
        in 1..10 -> "Tispy (навеселе)"
        in 11..20 -> "Sloshed (выпивший)"
        in 21..30 -> "Soused (пьяный)"
        in 31..40 -> "Stewed (сильно пьяный)"
        in 41..50 -> "..t0aSt3d (в стельку)"
        else -> ""
    }
    println(drinkyStatus)
}
