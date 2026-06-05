package lk.zeylanix.mynote.domain.usecase

import lk.zeylanix.mynote.domain.model.Note
import lk.zeylanix.mynote.domain.repository.NoteRepository

class DeleteNoteUseCase (
    private val repository: NoteRepository
){
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}