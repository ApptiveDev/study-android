package com.apptive.compose_ui_study.view

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel


class LoginViewModel(): ViewModel() {

	var email by mutableStateOf("")
	var password by mutableStateOf("")
}
