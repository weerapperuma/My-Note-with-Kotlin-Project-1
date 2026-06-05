package lk.zeylanix.mynote.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import lk.zeylanix.mynote.domain.model.Note
import lk.zeylanix.mynote.domain.repository.NoteRepository

class GetAllNotesUseCase (
    private val repository: NoteRepository
){
    operator fun invoke(): Flow<List<Note>>{
        return repository.getAllNotes()
            .map { notes -> notes.sortedByDescending { it.isPinned } }
    }
}