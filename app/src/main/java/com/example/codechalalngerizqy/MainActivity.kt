package com.example.codechalalngerizqy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), Callback {
    private lateinit var btnBatu: ImageButton
    private lateinit var btnKertas: ImageButton
    private lateinit var btnGunting: ImageButton
    private lateinit var btnRefresh: ImageButton
    private lateinit var imageStatus: ImageView
    private lateinit var pilihanComBatu: ImageView
    private lateinit var pilihanComGunting: ImageView
    private lateinit var pilihanComKertas: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBatu = findViewById(R.id.btnBatu)
        btnKertas = findViewById(R.id.btnKertas)
        btnGunting = findViewById(R.id.btnGunting)
        btnRefresh = findViewById(R.id.btnRefresh)
        imageStatus = findViewById(R.id.status)
        pilihanComBatu = findViewById(R.id.batuPc)
        pilihanComKertas = findViewById(R.id.kertasPc)
        pilihanComGunting = findViewById(R.id.guntingPc)

        val controller = Controller(this)
        val pilihan = mutableListOf("Batu", "Gunting", "Kertas")


        btnBatu.setOnClickListener {
            btnBatu.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
            val computer = pilihan.random()
            controller.aturan("Batu", computer)
            when (computer) {
                "Gunting" -> {
                    pilihanComGunting.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
                }
                "Batu" -> {
                    pilihanComBatu.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
                }
                else -> {
                    pilihanComKertas.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
                }
            }
            btnBatu.isEnabled = false
            btnKertas.isEnabled = false
            btnGunting.isEnabled = false
        }

        btnKertas.setOnClickListener {
            btnKertas.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
            val computer = pilihan.random()
            controller.aturan("Kertas", computer)
            when (computer) {
                "Gunting" -> {
                    pilihanComGunting.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
                }
                "Batu" -> {
                    pilihanComBatu.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
                }
                else -> {
                    pilihanComKertas.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
                }
            }
            btnBatu.isEnabled = false
            btnKertas.isEnabled = false
            btnGunting.isEnabled = false
        }

        btnGunting.setOnClickListener {
            btnGunting.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
            val computer = pilihan.random()
            controller.aturan("Gunting", computer)
            when (computer) {
                "Gunting" -> {
                    pilihanComGunting.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
                }
                "Batu" -> {
                    pilihanComBatu.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
                }
                else -> {
                    pilihanComKertas.setBackgroundColor(ContextCompat.getColor(this, R.color.pilihanbg))
                }
            }
            btnBatu.isEnabled = false
            btnKertas.isEnabled = false
            btnGunting.isEnabled = false
        }

        btnRefresh.setOnClickListener {
            imageStatus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_vs))
            btnBatu.setBackgroundColor(ContextCompat.getColor(this, R.color.transparan))
            btnGunting.setBackgroundColor(ContextCompat.getColor(this, R.color.transparan))
            btnKertas.setBackgroundColor(ContextCompat.getColor(this, R.color.transparan))
            pilihanComGunting.setBackgroundColor(ContextCompat.getColor(this, R.color.transparan))
            pilihanComKertas.setBackgroundColor(ContextCompat.getColor(this, R.color.transparan))
            pilihanComBatu.setBackgroundColor(ContextCompat.getColor(this, R.color.transparan))
            btnBatu.isEnabled = true
            btnKertas.isEnabled = true
            btnGunting.isEnabled = true
        }
    }

    override fun kirimStatus(status: String) {
        when {
            status.contains("1") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.p1menang
                    )
                ) // src
            }
            status.contains("2") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.p2menang
                    )
                ) // src

            }
            status.contains("w") -> {
                imageStatus.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.draw
                    )
                ) // src
            }
        }
    }
}