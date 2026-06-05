package lk.zeylanix.mynote.domain.usecase

import lk.zeylanix.mynote.domain.model.Note
import lk.zeylanix.mynote.domain.repository.NoteRepository

class SaveNoteUseCase (
    private val repository: NoteRepository
){
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank() && note.content.isBlank()){
            throw IllegalArgumentException("Note cannot be empty")
        }

        repository.saveNote(note)
    }
}