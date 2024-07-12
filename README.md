# Jetpack Compose Basic Layouts
Jetpack Compose의 기본 레이아웃인 `Box, Row, Column`를 활용하여 화면을 구성하고, `Modifier`로 다양한 속성을 조정해봅시다.

## 📐 진행방식
- 현재 브랜치에서 `<자신의 기수>` 안드로이드 프로젝트 폴더를 엽니다.
  - 만약 `<자신의 기수>` 폴더가 없다면 안드로이드 스튜디오로 새로 만듭니다.
  - 새로 만드는 프로젝트의 패키지명은 `com.apptive.compose`로 합니다.
- `com.apptive.compose.<자신의 이름>`으로 패키지를 생성합니다.
- `com.apptive.compose.template` 패키지의 파일을 자신의 패키지로 복사합니다.
- 자신의 패키지에서 과제를 구현한 후 commit, push합니다.

## 📑 문제
![problem-screen](./resource/result.png)  

Jetpack Compose를 활용하여 위 화면을 구현해주세요. 버튼 클릭 시 동작 등은 고려하지 않아도 됩니다.

## 🌀 환경 요구사항
- Jetpack Compose(`activityCompose`)는 1.9.0v 이상을 이용합니다.
- Kotlin은 1.9.0v 이상을 이용합니다.
- Android Studio **Iguana** 이상의 환경에서 코드를 작성합니다.
- `presentation/Login.kt`에 @Preview 함수를 정의하여 화면 미리보기를 보면서 코드를 작성합니다.
- Android Studio(+Terminal)를 통해 Git을 이용해보세요! Git Bash나 GUI가 필요없습니다. 

## 🧸 기능 요구사항
- 화면 요소의 수평방향은 중앙정렬을 기본으로 합니다. 화면 비율이나 크기가 달라져도 화면 요소의 수평은 중앙에 위치해야 합니다.
- 'SIGN IN' 버튼 하단에 반투명한 흰색 수평선이 위치합니다.
- 화면 최하단에 'Don't have an account? SIGN UP' 문구가 위치합니다. 이때, SIGN UP은 클릭(터치)가 가능해야 합니다.
- Login 화면에 대한 진입점 함수는 `LoginScreen()`입니다. 
- 배경그림은 `res/drawable`에서 불러오도록 합니다.
- 화면의 각 요소는 @Composable 함수로 분리, 구분되어 있어야 합니다.
- 이름, 비밀번호 입력창은 동일한 @Composable 함수를 사용합니다.
- 아이콘은 [Material Icons](https://fonts.google.com/icons)를 사용합니다. 코드에서 `Icons.Default.Person`과 같은 방식으로 불러올 수 있습니다. 

## 🔥 더 해보기
다음 중 하나 이상을 골라 도전해보세요!

- 배경화면을 이미지가 아닌, 영상으로 변경하기
- 배경화면의 이미지를 온라인으로부터 불러오기
- `LoginScreen()` 함수에 Box, Column, Row 등을 직접 쓰지 않고, 아래처럼 `LoginBackground(...)` 함수를 정의해서 받도록 리팩토링하기
```kotlin
@Composable
fun LoginScreen() {
  LoginBackground {
    ...
  }
}

@Composable
private fun LoginBackground(
  content: @Composable ...
) {
  ...
}
```
- 텍스트 입력창에 키보드 입력값이 그대로 표시되도록 수정하기 (remember, state)

## 궁금점과 질문
(코드를 작성하면서 자유롭게 적어주세요)

## 메모

