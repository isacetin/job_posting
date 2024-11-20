package com.isacetin.jopposting.models

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    abstract fun resetState()
}
