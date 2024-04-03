package com.apptive.compose_ui_study.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apptive.compose_ui_study.R
import com.apptive.compose_ui_study.enum.FormType

@Composable
fun LoginScreen(
	viewModel: LoginViewModel
) {
	ImageWithBackground(
		painter = painterResource(id = R.drawable.login_background)
	) {
		LazyColumn(
			modifier = Modifier
				.fillMaxSize()
				.padding(top = 200.dp)
				.background(
					brush = Brush.verticalGradient(
						colors = listOf(Color.Transparent, Color(0xFFF56D6D)),
						startY = 400f
					)
				)
			,
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.spacedBy(20.dp)
		) {
			item {
				PlainText("Welcome Back!", 20.sp)
				Spacer(Modifier.size(10.dp))
				PlainText("Please Login to your account.")
			}

			item {
				LoginTextField(
					value = viewModel.email,
					onValueChange = { viewModel.email = it },
					placeholder = FormType.EMAIL.text,
					keyboardType = FormType.EMAIL.keyboardType,
					visualTransformation = FormType.EMAIL.visualTransformation
				)
				LoginTextField(
					value = viewModel.password,
					onValueChange = { viewModel.password = it },
					placeholder = FormType.PASSWORD.text,
					keyboardType = FormType.PASSWORD.keyboardType,
					visualTransformation = FormType.PASSWORD.visualTransformation
				)
			}

			item { LoginButton("Login", {}) }

			item {
				Row(
					Modifier.fillMaxWidth(),
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.Center
				) {
					Divider(width = 130.dp)
					PlainText(text = "OR")
					Divider(width = 130.dp)
				}
			}

			item {
				SocialLoginButton("Sign in with Facebook", {}, painterResource(id = R.drawable.facebook_logo))
				SocialLoginButton("Sign in with Google", {}, painterResource(id = R.drawable.google_logo))
			}

		}
	}
}

@Composable
fun Divider(
	width: Dp,
	thickness: Dp = 1.dp,
	color: Color = Color.White
) {
	Box(Modifier.padding(horizontal = 10.dp).width(width).height(thickness).background(color = color))
}

@Composable
fun SocialLoginButton(
	text: String,
	onClick: () -> Unit,
	painter: Painter,
) {
	Button(
		onClick = onClick,
		colors = ButtonDefaults.buttonColors(
			backgroundColor = Color(0xFF111631)
		),
		shape = RoundedCornerShape(25.dp),
		modifier = Modifier.fillMaxWidth(0.7f)
	) {
		Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
			Icon(
				painter = painter,
				contentDescription = null,
				modifier = Modifier
					.size(17.dp)
					.align(Alignment.BottomStart),
				tint = Color.White,
			)
			PlainText(text = text)
		}
	}
}

@Composable
fun LoginButton(
	text: String,
	onClick: () -> Unit,
) {
	Button(
		onClick = onClick,
		colors = ButtonDefaults.buttonColors(
			backgroundColor = Color(0xFF1334E7)
		),
		shape = RoundedCornerShape(25.dp),
		modifier = Modifier.width(80.dp)
	) {
		PlainText(text = text)
	}
}

@Composable
fun PlainText(
	text: String,
	fontSize: TextUnit = 14.sp,
	modifier: Modifier = Modifier
) {
	Text(
		text = text,
		fontSize = fontSize,
		color = Color.White,
		fontWeight = FontWeight.Normal
	)
}

@Composable
fun LoginTextField(
	value: String,
	onValueChange: (String) -> Unit,
	placeholder: String,
	keyboardType: KeyboardType,
	visualTransformation: VisualTransformation
) {
	TextField(
		value = value,
		onValueChange = onValueChange,
		placeholder = {
			Row(
				Modifier.fillMaxSize(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center
			) { PlainText(text = placeholder) }
	    },
		keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
		colors = TextFieldDefaults.textFieldColors(
			textColor = Color.White,
			backgroundColor = Color.Transparent,
			unfocusedIndicatorColor = Color.White,
			focusedIndicatorColor = Color.White
		),
		visualTransformation = visualTransformation,
		textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
		modifier = Modifier
			.fillMaxWidth(0.7f)
			.wrapContentHeight()
	)
}

@Composable
fun ImageWithBackground(
	modifier: Modifier = Modifier,
	painter: Painter,
	contentDescription: String? = null,
	alignment: Alignment = Alignment.Center,
	contentScale: ContentScale = ContentScale.Crop,
	content: @Composable () -> Unit = {}
) {
	Box {
		Image(
			painter = painter,
			contentDescription = contentDescription,
			alignment = alignment,
			contentScale = contentScale,
			modifier = Modifier.matchParentSize()
		)
		content()
	}
}

@Preview(widthDp = 360, heightDp = 720)
@Composable
fun PreviewLoginScreen() {
	LoginScreen(LoginViewModel())
}

