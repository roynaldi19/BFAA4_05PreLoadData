package com.roynaldi19.bfaa4_05preloaddata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.roynaldi19.bfaa4_05preloaddata.database.MahasiswaHelper
import kotlinx.android.synthetic.main.activity_mahasiswa.*

class MahasiswaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa)

        recyclerview.layoutManager = LinearLayoutManager(this)
        val mahasiswaAdapter = MahasiswaAdapter()
        recyclerview.adapter = mahasiswaAdapter

        val mahasiswaHelper = MahasiswaHelper(this)
        mahasiswaHelper.open()
        // Ambil semua data mahasiswa di database
        val mahasiswaModels = mahasiswaHelper.getAllData()
        mahasiswaHelper.close()

        mahasiswaAdapter.setData(mahasiswaModels)
    }
}