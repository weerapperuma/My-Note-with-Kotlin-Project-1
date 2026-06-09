package lk.zeylanix.mynote.presentation.noteeditor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import lk.zeylanix.mynote.domain.model.Note
import lk.zeylanix.mynote.domain.usecase.GetNoteByIdUseCase
import lk.zeylanix.mynote.domain.usecase.SaveNoteUseCase

@HiltViewModel
class NoteEditorViewModel @Inject constructor(
    private val getNoteByIdUseCase: GetNoteByIdUseCase,
    private val saveNoteUseCase: SaveNoteUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(NoteEditorUiState())
    val uiState: StateFlow<NoteEditorUiState> = _uiState.asStateFlow()

    fun loadNote(noteId: Int?) {
        if (noteId == null || noteId == -1 || _uiState.value.noteId == noteId) return

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            val note = getNoteByIdUseCase(noteId)
            _uiState.update {
                it.copy(
                    noteId = note?.id,
                    title = note?.title.orEmpty(),
                    content = note?.content.orEmpty(),
                    isLoading = false,
                    errorMessage = if (note == null) "Note not found" else null
                )
            }
        }
    }

    fun onTitleChange(title: String) {
        _uiState.update { it.copy(title = title, errorMessage = null) }
    }

    fun onContentChange(content: String) {
        _uiState.update { it.copy(content = content, errorMessage = null) }
    }

    fun saveNote(onSaved: () -> Unit) {
        val state = _uiState.value

        viewModelScope.launch {
            try {
                saveNoteUseCase(
                    Note(
                        id = state.noteId ?: 0,
                        title = state.title.trim(),
                        content = state.content.trim()
                    )
                )
                onSaved()
            } catch (error: IllegalArgumentException) {
                _uiState.update { it.copy(errorMessage = error.message) }
            }
        }
    }
}
