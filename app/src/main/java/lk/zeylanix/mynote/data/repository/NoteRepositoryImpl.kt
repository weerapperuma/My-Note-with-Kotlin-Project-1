package lk.zeylanix.mynote.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import lk.zeylanix.mynote.data.local.NoteDao
import lk.zeylanix.mynote.data.mapper.toDomain
import lk.zeylanix.mynote.data.mapper.toEntity
import lk.zeylanix.mynote.domain.model.Note
import lk.zeylanix.mynote.domain.repository.NoteRepository

class NoteRepositoryImpl (
    private val dao: NoteDao
) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes().map { entities -> entities.map { it.toDomain() } }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)?.toDomain()
    }

    override suspend fun saveNote(note: Note) {
        return dao.upsertNote(note.toEntity())
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note.toEntity())
    }
}