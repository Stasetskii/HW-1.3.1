package ru.netology

fun main() {

    val idleTime = 1000000

    agoToText(idleTime)
}

fun agoToText(idleTime: Int) {
    when (idleTime) {
        in 0..60 -> println("Был(а) только что")
        in 61..3600 -> {
            val time = idleTime / 60
            val minutesToText = minutes(time)
            println("Был(а) $time $minutesToText назад")
        }
        in 3_601..86400 -> {
            val time = (idleTime / 3600)
            val hoursToText = hours(time)
            println("Был(а) $time $hoursToText назад")
        }
        in 86401..172800 -> println("Был(а) сегодня")
        in 172801..259200 -> println("Был(а) вчера")
        else -> println("Был(а) давно")
    }
}

fun minutes(time: Int): String {
    return when (time) {
        1, 21, 31, 41, 51 -> "минуту"
        in 2..4 -> "минуты"
        in 5..20, in 22..30, in 32..40, in 42..50, in 52..60 -> "минут"
        else -> ""
    }
}

fun hours(time: Int): String {
    return when (time) {
        1, 21 -> "час"
        in 2..4, 22, 23 -> "часа"
        in 5..20 -> "часов"
        else -> ""
    }
}