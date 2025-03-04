package com.example.dcam_votd

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun setupButtons() {
        val newNoteButton = findViewById<ImageButton>(R.id.newNoteButton)
        val viewNotesButton = findViewById<ImageButton>(R.id.viewNotesButton)
        val viewChapterButton = findViewById<ImageButton>(R.id.viewChapterButton)
        val viewVerseButton = findViewById<ImageButton>(R.id.viewVerseButton)
        val goToHomeButton = findViewById<ImageButton>(R.id.goToHomeButton)

        newNoteButton?.setOnClickListener {
            startActivity(Intent(this, WriteActivity::class.java))
        }
        viewNotesButton?.setOnClickListener {
            startActivity(Intent(this, SavedNotesActivity::class.java))
        }
        viewChapterButton?.setOnClickListener {
            startActivity(Intent(this, ChapterActivity::class.java))
        }
        viewVerseButton?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        goToHomeButton?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}
