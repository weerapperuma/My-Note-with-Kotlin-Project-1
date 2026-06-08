package lk.zeylanix.mynote.presentation.notelist

import lk.zeylanix.mynote.domain.model.Note

data class NoteListUiState (
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)