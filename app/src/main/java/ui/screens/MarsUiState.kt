package com.example.android_internet.ui.screens

import com.example.android_internet.data.MarsPhoto

sealed interface MarsUiState {

    data class Success(
        val photos: List<MarsPhoto>
    ) : MarsUiState

    object Error : MarsUiState

    object Loading : MarsUiState
}

