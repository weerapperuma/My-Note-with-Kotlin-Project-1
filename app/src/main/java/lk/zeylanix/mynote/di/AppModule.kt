package lk.zeylanix.mynote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lk.zeylanix.mynote.data.local.NoteDao
import lk.zeylanix.mynote.data.repository.NoteRepositoryImpl
import lk.zeylanix.mynote.domain.repository.NoteRepository
import lk.zeylanix.mynote.domain.usecase.DeleteNoteUseCase
import lk.zeylanix.mynote.domain.usecase.GetAllNotesUseCase
import lk.zeylanix.mynote.domain.usecase.GetNoteByIdUseCase
import lk.zeylanix.mynote.domain.usecase.SaveNoteUseCase

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideNoteRepository(dao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(dao)
    }

    @Provides
    fun provideGetAllNotesUseCase(
        repository: NoteRepository
    ): GetAllNotesUseCase {
        return GetAllNotesUseCase(repository)
    }

    @Provides
    fun provideSaveNoteUseCase(
        repository: NoteRepository
    ): SaveNoteUseCase {
        return SaveNoteUseCase(repository)
    }

    @Provides
    fun provideDeleteNoteUseCase(
        repository: NoteRepository
    ): DeleteNoteUseCase {
        return DeleteNoteUseCase(repository)
    }

    @Provides
    fun provideGetNoteByIdUseCase(
        repository: NoteRepository
    ): GetNoteByIdUseCase {
        return GetNoteByIdUseCase(repository)
    }
}