package com.apptive.compose_ui_study.enum

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

enum class FormType(val text: String, val keyboardType: KeyboardType, val visualTransformation: VisualTransformation) {
	EMAIL("Email Address", KeyboardType.Email, VisualTransformation.None),
	PASSWORD("Password", KeyboardType.Password, PasswordVisualTransformation())
}