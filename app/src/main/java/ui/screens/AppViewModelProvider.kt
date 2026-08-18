package com.example.android_internet.ui.screens

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.android_internet.MarsApplication

object AppViewModelProvider {

    val Factory = viewModelFactory {

        initializer {

            HomeViewModel(
                (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MarsApplication)
                    .container
                    .marsRepository
            )

        }

    }

}

