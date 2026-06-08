package lk.zeylanix.mynote.data.mapper

import lk.zeylanix.mynote.data.local.NoteEntity
import lk.zeylanix.mynote.domain.model.Note

fun NoteEntity.toDomain(): Note = Note(
    id = id,
    title = title,
    content = content,
    createdAt = createdAt,
    isPinned = isPinned
)

fun Note.toEntity(): NoteEntity = NoteEntity(
    id = id,
    title = title,
    content = content,
    createdAt = createdAt,
    isPinned = isPinned
)