package com.isacetin.jopposting

import androidx.lifecycle.ViewModel
import com.isacetin.local_preference.UserPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userPreference: UserPreference) : ViewModel()
