# State, Animation
 화면이 렌더링되는 기본 원리인 State를 이해하고 화면 요소에 다양한 애니메이션과 효과를 적용해봅시다.

## 📐 진행방식
- 현재 브랜치로부터 `android-state/<본인 이름>` 브랜치를 생성하고 이동합니다.
- 지난 과제(`android-compose`)에 구현했던 자신의 프로젝트를 루트폴더에 복사합니다.
  - 지난 과제 브랜치로 이동하여 본인 프로젝트 폴더를 어딘가에 복사합니다.
  - `android-state/<본인 이름>` 브랜치로 이동하고 복사해둔 폴더를 루트폴더에 붙여넣습니다.
- Android Studio로 복사해온 프로젝트 폴더를 열어 과제를 진행합니다.
- 과제를 구현한 후 `android-state/main` 브랜치로 Pull Request를 올립니다.

## 📑 문제
![Home Clicked](/images/01-home-clicked.gif)  
(홈 버튼 클릭 기능)  


![Left Right Button](/images/02-left-right-button.gif)  
(왼쪽이동, 오른쪽이동 버튼)  


![Appear Disappear Button](/images/03-appear-disappear-button.gif)  
(나타나기, 사라지기 버튼)  


위와 같이 5가지 애니메이션을 구현해주세요

## 🌀 환경 요구사항
- Jetpack Compose(activityCompose)는 1.9.0v 이상을 이용합니다.
- Kotlin은 1.9.0v 이상을 이용합니다.
- Android Studio Iguana 이상의 환경에서 코드를 작성합니다.
- `presentation/Splash.kt`에 `SplashScreen()` 컴포저블을 정의하고 이곳에 구현합니다.
- `presentation/Splash.kt`에 @Preview 함수를 정의하여 화면 미리보기를 보면서 코드를 작성합니다.
- 아이콘은 Material Icons를 사용합니다. 코드에서 `Icons.Default.Person`과 같은 방식으로 불러올 수 있습니다.

## 🧸 기능 요구사항
- 화면의 정중앙에 Home 아이콘이 위치합니다.
- Home 아이콘을 터치하면 왼편에 또다른 아이콘이 나타나거나 숨겨집니다. (`AnimatedVisivility`)
  - 이때, 또다른 아이콘이 나타나면 Home 아이콘은 밀려나야 합니다.
- 화면 하단에 4가지 버튼이 위치합니다.
  - **좌측이동**: Home 아이콘이 왼쪽으로 100.dp를 1.5초간 서서히 움직입니다. (`animateDpAsState`)
    - 재차 클릭하면 제자리로 돌아갑니다.
  - **우측이동**: Home 아이콘이 오른쪽으로 100.dp를 1.5초간 서서히 움직입니다. (`animateDpAsState`)
    - 재차 클릭하면 제자리로 돌아갑니다.
  - **사라지기**: Home 아이콘이 1.5초간 점점 투명해지다가 사라집니다. (`animateFloatAsState`)
  - **나타나기**: Home 아이콘이 1.5초간 서서히 드러납니다. (`animateFloatAsState`)
- Home 아이콘의 위치를 `LEFT, CENTER, RIGHT`으로 나타내는 `POSITION` enum 클래스를 정의합니다.

## 🔥 더 해보기
- 버튼을 누르지 않더라도, 앱을 실행하는 동시에 애니메이션이 실행되도록 개선 (`LaunchedEffect`)
- 다양한 `animationSpec`을 적용하고 그 차이를 확인해보세요.
- 아래와 같이 영역을 분리하도록 리팩토링을 해보세요.
```kotlin
@Composable
fun SplashScreen() {
    SplashBackground {
        IconsArea(...)
        ButtonsArea(...)
    }
}

@Composable
private fun SplashBackground(
    content: @Composable BoxScope.() -> Unit
) {
    ...
}

@Composable
private fun IconArea(
    showIcon: Boolean,   // true일 때 또다른 아이콘이 나타난다.
    offsetX: Dp,         // Home 아이콘의 x 위치 오프셋
    alpha : Float,       // Home 아이콘의 투명도
    onClicked: () -> Unit,
) {
    ...
}

@Composable
private fun ButtonArea(
    modifier: Modifier,
    onLeftMove: () -> Unit = {},
    onRightMove: () -> Unit = {},
    onAppear: () -> Unit = {},
    onDisappear: () -> Unit = {},
) {
    ...
}
```

## 궁금점과 질문
(코드를 작성하면서 자유롭게 적어주세요)