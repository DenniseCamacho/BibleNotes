package com.example.dcam_votd
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dcam_votd.database.NoteViewModel
import com.example.dcam_votd.database.NotesAdapter
//Dennise Camacho
//2025, February 23
class SavedNotesActivity : BaseActivity() {

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var noteAdapter: NotesAdapter
    private lateinit var emptyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_notes)

        setupButtons()

        recyclerView = findViewById(R.id.recyclerViewNotes)
        emptyTextView = findViewById(R.id.emptyNotesTextView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        noteAdapter = NotesAdapter(this, mutableListOf(), NoteViewModel(application))
        recyclerView.adapter = noteAdapter

        noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        noteViewModel.allNotes.observe(this, Observer { notes ->
            if (notes.isNullOrEmpty()) {
                recyclerView.visibility = View.GONE
                emptyTextView.visibility = View.VISIBLE
            } else {
                recyclerView.visibility = View.VISIBLE
                emptyTextView.visibility = View.GONE
                noteAdapter.updateNotes(notes)
            }
        })
    }
}
