package com.example.android_internet.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_internet.data.MarsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
class HomeViewModel(
    private val marsRepository: MarsRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<MarsUiState>(MarsUiState.Loading)

    val uiState: StateFlow<MarsUiState> =
        _uiState.asStateFlow()

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            _uiState.value = try {
                MarsUiState.Success(
                    marsRepository.getMarsPhotos()
                )
            } catch (e: Exception) {
                MarsUiState.Error
            }
        }
    }
}

