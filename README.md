# Navigation
 두 화면을 연결하고 이동하는 내비게이션과 코드를 병렬적으로 실행하는 Side Effect 대해 알아봅시다.

## 📐 진행방식
- 현재 브랜치에서 `<자신의 기수>` 안드로이드 프로젝트 폴더를 엽니다.
  - 만약 `<자신의 기수>` 폴더가 없다면 안드로이드 스튜디오로 새로 만듭니다.
  - 새로 만드는 프로젝트의 패키지명은 `com.apptive.navigation`로 합니다.
- `com.apptive.navigation.<자신의 이름>`으로 패키지를 생성합니다.
- 자신의 패키지에서 과제를 구현한 후 commit, push합니다.

## 📑 문제
![Launched Effect](./images/launched-effect-navigation.gif)  
위처럼 Splash 화면에서 로고가 서서히 드러나게 한 후, 로그인 화면으로 이동하는 기능을 구현해주세요.

## 🌀 환경 요구사항
- Jetpack Compose(activityCompose)는 1.9.0v 이상을 이용합니다.
- Kotlin은 1.9.0v 이상을 이용합니다.
- Android Studio Iguana 이상의 환경에서 코드를 작성합니다.
- 공동 작업을 위해 `20th` 폴더를 Android Studio로 열어 과제를 진행합니다.
  - 각자의 패키지를 정의하여 그곳에서 별도로 진행합니다. 
  - 과제 진행을 위한 초기 코드는 `com.apptive.layout.template` 패키지에 있습니다. 이곳의 파일을 자신의 패키지에 복사한 후 과제를 진행합니다.
  - ex) `com.apptive.layout.junyoung.presentation`, `com.apptive.layout.jinseo.presentation`
- `androidx.navigation:navigation-compose`를 종속성에 새로 추가합니다. (버전은 2.7.7 이상)
- `presentation.navigation` 패키지를 만들어 내비게이션 관련 코드를 이곳에 작성합니다.
  - `Screen` 파일을 만들고, `sealed class Screen`을 작성합니다.
  - `NavGraph` 파일을 만들고, `SetupNavGraph(...)` 함수를 작성합니다.

## 🧸 기능 요구사항
- `sealed class Screen`은 route라는 `String` 멤버를 갖도록 구현합니다.
  - `Splash`, `Login`, `Home`을 자식으로 갖도록 정의합니다.
- `SetupNavGraph(...)`는 다음 두 가지 매개변수를 갖습니다.
  - `navController: NavHostController`
  - `startScreen: Screen`: 앱 실행 시 처음 실행할 화면
- 앱을 처음 실행하면 Splash 화면이 뜹니다.
  - 실행하자마자 중앙의 Home 로고를 5초간 서서히 드러나게 합니다. (`LaunchedEffect`)
  - Home 로고가 사라지면 Login 화면으로 자동으로 이동합니다. (`delay`, `navController`)
- Login 화면에서 SIGN IN 버튼을 누르면 Home 화면으로 이동합니다.

## 🔥 더 해보기
- Login 화면에서 아이디와 비밀번호를 체크하는 로직을 짜보세요.
  - 아이디와 비밀번호가 일치하면 Home 화면으로 이동합니다.
  - 아이디와 비밀번호가 일치하지 않으면 경고창을 띄웁니다.
- `androidx.navigation:navigation-compose` 종속성을 `Gradle Version Catalog` 형식으로 추가해보세요.
- `navHostController`를 `lateinit`으로 Activity의 멤버로 정의해보세요. 전역변수처럼 활용할 수 있습니다.
- Preview의 Interactive Mode에서도 내비게이션이 제대로 동작하도록 개선해보세요.

## 궁금점과 질문
(코드를 작성하면서 자유롭게 적어주세요)
