# 안드로이드 기본 구조
## 목표
안드로이드 개발에 필수적인 기본 컴포넌트와 개발 패키지 구조, UI 요소 이해하기

## 키워드
- [Android Components](#android-components)
    - [Activity](#activity)
    - [Content Provider](#content-provider)
    - [Service (Optional)](#service-optional)
    - [Broadcast Receiver (Optional)](#broadcast-receiver-optional)
- [Android Lifecycle](#android-lifecycle)
    - [Activity](#activity-1)
    - [Composable](#composable)
- [Project Structure](#project-structure)
- [Jetpack Compose](#jetpack-compose)


### Android Components
(안드로이드 앱은 **4개의 컴포넌트로 구성**됩니다. 개발자는 컴포넌트 구조를 따르며 코드를 작성해야 하는데, 그중 다음 2개의 컴포넌트는 각각 어떤 역할을 하는지 적어주세요.)  

#### Activity
(이해한 것을 적어주세요)

#### Content Provider
(이해한 것을 적어주세요)

### Intent
(Intent는 상기한 컴포넌트 사이에 메시지를 전달하는 객체입니다.  
Intent에 대해 이해한 바를 적어주세요.)  

### Android Lifecycle
#### Activity
(Activity의 라이프사이클은 어떻게 될까요?)

#### Composable
(UI는 Composable 단위로 구성됩니다. Composable의 라이프사이클은 어떻게 될까요?)

### Project Structure
(Android Studio에서 프로젝트를 새로 시작하면 기본적인 폴더 구조가 설정됩니다.  
아래를 참고하여 각 폴더와 파일의 역할에 대해 이해하는 바를 적어주세요.)
```plain
|- app
    |- manifests
        - AndroidManifest.xml
    |- kotlin+java
        |- package(com.apptive.app...)
        |- package(androidTest)
        |- package(test)
    |- res
        |- drawable
        |- mipmap (생략해도 됨)
        |- values
            - colors.xml
            - strings.xml
            |- theme (생략해도 됨)
|- Gradle Scripts
    - build.gradle(Project)
    - build.gradle(Module)
    - settings.gradle
```

### Jetpack Compose
#### Layout
(Box, Column, Row, Spacer 등 **Jetpack Compose의 기본적인 레이아웃의 종류**에 대해 조사해주세요.)

#### Entry Point
(아래는 Jetpack Compose 프로젝트르 생성했을 때 기본적으로 생성되는 코드입니다. 앱에서 가장 처음 실행되는 코드이기도 합니다. 각 문장이 무엇을 의미하는지 주석을 달아주세요.)

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutTheme {
        Greeting("Android")
    }
}
```

## 할일
- 안드로이드 스튜디오 에뮬레이터 설정
- 안드로이드 스튜디오 SDK 설치 (28~)
- 안드로이드 스튜디오 USB/Wifi 디버깅 (IOS 모바일 디바이스 제외.)

## 의논해볼 것
- [ ] 화면을 회전시키면 Activity의 Lifecycle은 어떻게 변할까요?
- [ ] Jetpack Compose 이전에는 Composable 대신 View 객체로 UI를 사용했습니다. 어떤 점이 다를까요? (Lifecycle 등)
- [ ] build.gradle은 module 레벨, project 레벨로 나뉘어집니다. 둘은 어떤 차이일까요?  
---

## 궁금한 점
- 반드시 1개 이상 작성합니다.

## 참고자료
- 출처는 중요합니다. 되도록 작성해주세요.

## 비고
25.03.04 KimGiyun 수정.
