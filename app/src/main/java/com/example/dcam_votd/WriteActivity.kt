package com.example.dcam_votd
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import com.example.dcam_votd.database.Note
import com.example.dcam_votd.database.NoteViewModel
//Dennise Camacho
//2025, February 23
class WriteActivity : BaseActivity() {

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteTitleEditText: EditText
    private lateinit var noteEditText: EditText
    private var noteId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        setupButtons()

        noteViewModel = NoteViewModel(application)

        noteTitleEditText = findViewById(R.id.noteTitleEditText)
        noteEditText = findViewById(R.id.noteEditText)
        val saveNoteButton = findViewById<ImageButton>(R.id.saveNoteButton)

        // Check if editing an existing note
        noteId = intent.getIntExtra("NOTE_ID", -1).takeIf { it != -1 }
        val noteTitle = intent.getStringExtra("NOTE_TITLE")
        val noteText = intent.getStringExtra("NOTE_TEXT")

        if (noteTitle != null) {
            noteTitleEditText.setText(noteTitle)
        }

        if (noteText != null) {
            noteEditText.setText(noteText)
        }

        // Save or Update note
        saveNoteButton.setOnClickListener {
            val title = noteTitleEditText.text.toString().trim()
            val noteText = noteEditText.text.toString().trim()

            if (title.isNotEmpty() && noteText.isNotEmpty()) {
                val note = if (noteId != null) {
                    Note(id = noteId!!, title = title, noteText = noteText)
                } else {
                    Note(title = title, noteText = noteText)
                }
                noteViewModel.insert(note)
                finish()
            }
        }
    }
}
