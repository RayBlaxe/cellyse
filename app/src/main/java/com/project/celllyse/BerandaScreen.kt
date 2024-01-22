package com.project.celllyse

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.celllyse.databinding.BerandaScreenBinding
import com.project.celllyse.databinding.LoginScreenBinding

class BerandaScreen : AppCompatActivity (){

    lateinit var binding : BerandaScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BerandaScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_artikel)

        val items = ArrayList<ArtikelItem>()
        items.add(ArtikelItem(R.drawable.ic_photo, "Sel mantap", "Sel adalah unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas. Sel merupakan unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas. Sel merupakan unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas. Sel merupakan unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas."))
        items.add(ArtikelItem(R.drawable.ic_photo, "Sel Bodoh mantak jiwa","Sel adalah unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas. Sel merupakan unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas. Sel merupakan unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas. Sel merupakan unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas."))
        items.add(ArtikelItem(R.drawable.ic_photo, "Sel mantap","Sel adalah unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas. Sel merupakan unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas. Sel merupakan unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas. Sel merupakan unit terkecil dari makhluk hidup yang dapat melakukan semua fungsi kehidupan, seperti metabolisme, pertumbuhan, reproduksi, dan iritabilitas."))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ArtikelAdapter(applicationContext, items)





        binding.btnBeranda.setOnClickListener {
            startActivity(Intent(this, BerandaScreen::class.java))
        }
        binding.btnPrediksi.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, PrediksiFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


        binding.btnRiwayat.setOnClickListener {
            startActivity(Intent(this, RiwayatScreen::class.java))
        }
        binding.btnProfil.setOnClickListener {
            startActivity(Intent(this, ProfilScreen::class.java))
        }
    }



}