package lk.zeylanix.mynote.domain.repository

import kotlinx.coroutines.flow.Flow
import lk.zeylanix.mynote.domain.model.Note

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun saveNote(note: Note)
    suspend fun deleteNote(note: Note)
}