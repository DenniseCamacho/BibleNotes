package com.example.dcam_votd.database

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dcam_votd.R
import com.example.dcam_votd.WriteActivity

class NotesAdapter(
    private val context: Context,
    private var notes: MutableList<Note>,
    private val noteViewModel: NoteViewModel
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.findViewById(R.id.noteTitleTextView) // ✅ Changed from noteTextView
        val editButton: ImageButton = itemView.findViewById(R.id.editNoteButton)
        val deleteButton: ImageButton = itemView.findViewById(R.id.deleteNoteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.noteTitle.text = note.title // ✅ Now displays the title

        holder.editButton.setOnClickListener {
            val intent = Intent(context, WriteActivity::class.java).apply {
                putExtra("NOTE_ID", note.id)
                putExtra("NOTE_TITLE", note.title)
                putExtra("NOTE_TEXT", note.noteText)
            }
            context.startActivity(intent)
        }

        holder.deleteButton.setOnClickListener {
            noteViewModel.delete(note)
        }
    }

    fun updateNotes(newNotes: List<Note>) {
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }
}
