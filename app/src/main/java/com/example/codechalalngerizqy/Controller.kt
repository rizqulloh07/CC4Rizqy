package com.example.codechalalngerizqy

class Controller(private val callback: MainActivity) {
    fun aturan(pemain1: String, computer: String) {
        val status = when {
            computer == "Gunting" && pemain1 == "Kertas" ||
                    computer == "Batu" && pemain1== "Gunting" ||
                    computer == "Kertas" && pemain1 == "Batu" -> "Player 2 Winner"
            pemain1 == "Gunting" && computer == "Kertas" ||
                    pemain1 == "Batu" && computer == "Gunting" ||
                    pemain1 == "Kertas" && computer == "Batu" -> "Player 1 Winner"
            else -> "Draw"
        }
        callback.kirimStatus(status)
    }
}
