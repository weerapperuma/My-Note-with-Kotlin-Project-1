package lk.zeylanix.mynote.presentation.noteeditor

data class NoteEditorUiState(
    val noteId: Int? = null,
    val title: String = "",
    val content: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
