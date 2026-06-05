package lk.zeylanix.mynote.domain.model

data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
    val createdAt: Long = System.currentTimeMillis(),
    val isPinned: Boolean = false
)
