package com.shiftkey.codingchallenge.di

import com.shiftkey.codingchallenge.data.api.API
import com.shiftkey.codingchallenge.data.mapper.ShiftResponseToShiftsMapper
import com.shiftkey.codingchallenge.data.repository.ShiftsRepositoryImpl
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository
import com.shiftkey.codingchallenge.domain.usecase.GetShiftsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideShiftsMapper() = ShiftResponseToShiftsMapper()

    @Provides
    fun provideRepository(api: API, mapper: ShiftResponseToShiftsMapper): ShiftsRepository = ShiftsRepositoryImpl(api, mapper)

    @Provides
    fun provideShiftUseCase(repository: ShiftsRepository) = GetShiftsUseCase(repository)
}