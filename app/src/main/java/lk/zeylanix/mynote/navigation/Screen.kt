package lk.zeylanix.mynote.navigation

sealed class Screen(val route: String) {
    object NoteList : Screen("note_list")

    object NoteEditor : Screen("note_editor/{noteId}") {
        fun createRoute(noteId: Int?) = "note_editor/${noteId ?: -1}"
    }
}
