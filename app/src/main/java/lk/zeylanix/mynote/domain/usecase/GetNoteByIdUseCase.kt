package lk.zeylanix.mynote.domain.usecase

import lk.zeylanix.mynote.domain.model.Note
import lk.zeylanix.mynote.domain.repository.NoteRepository

class GetNoteByIdUseCase (
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note?{
        return repository.getNoteById(id)
    }
}