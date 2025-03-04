package com.example.dcam_votd
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//Dennise Camacho
//2025, February 23
class ItemNote : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_note)

        setupButtons()

    }
}