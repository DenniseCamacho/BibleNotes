package com.example.dcam_votd.database

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        withContext(Dispatchers.IO) {
            noteDao.insert(note)
        }
    }

    suspend fun update(note: Note) {
        withContext(Dispatchers.IO) {
            noteDao.update(note)
        }
    }

    suspend fun delete(note: Note) {
        withContext(Dispatchers.IO) {
            noteDao.delete(note)
        }
    }
}