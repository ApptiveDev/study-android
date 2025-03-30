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
<!-- (안드로이드 앱은 **4개의 컴포넌트로 구성**됩니다. 개발자는 컴포넌트 구조를 따르며 코드를 작성해야 하는데, 그중 다음 2개의 컴포넌트는 각각 어떤 역할을 하는지 적어주세요.)   -->

#### Activity
- Activity는 안드로이드 앱에서 사용자와 상호작용하는 화면을 담당하는 컴포넌트입니다. 하나의 Activity는 하나의 화면을 나타내며, 사용자 인터페이스(UI)를 구성하고 사용자 입력(터치, 버튼 클릭 등)을 처리한다.

#### Content Provider
- Content Provider는 앱 간 데이터를 공유하거나 관리하기 위한 컴포넌트이다다. 앱 내부 데이터를 외부(다른 앱)와 안전하게 공유할 수 있도록 표준화된 인터페이스를 제공한다. 예를 들어, 연락처 앱의 데이터를 다른 앱에서 읽거나 수정할 때 Content Provider를 사용한다. 데이터는 주로 SQLite 데이터베이스, 파일, 또는 네트워크에 저장되며, Content Provider는 이를 캡슐화해서 접근 권한을 관리한다다.

### Intent
- Intent는 안드로이드 컴포넌트(Activity, Service, Broadcast Receiver 등) 간에 메시지를 전달하는 객체입니다. Intent를 사용하면 한 컴포넌트에서 다른 컴포넌트를 호출하거나 데이터를 전달할 수 있습니다. 
> 명시적 Intent
    - 호출할 대상(특정 Activity나 Service)을 정확히 지정.- ex:특정 화면으로 이동.
> 암시적 Intent
    - 시스템이 적절한 컴포넌트를 찾아 실행. 예: 전화 걸기, URL 열기. Intent는 데이터를 전달하거나 앱 외부 작업
    - ex : 전화 걸기, 이메일 보내기를 요청할 때도 사용됩니다.

### Android Lifecycle

#### Activity
- `onCreate()`: Activity가 처음 생성될 때 호출. UI 초기화, 변수 설정 등 초기 작업 수행.
- `onStart()`: Activity가 사용자에게 보이기 시작할 때 호출.
- `onResume()`: Activity가 포그라운드에 나타나 사용자와 상호작용 가능할 때 호출.
- `onPause()`: Activity가 부분적으로 가려지거나 포커스를 잃을 때 호출(예: 다른 화면으로 이동).
- `onStop()`: Activity가 더 이상 사용자에게 보이지 않을 때 호출.
- `onDestroy()`: Activity가 완전히 종료될 때 호출. 리소스 해제 작업 수행.

#### Composable
<!-- (UI는 Composable 단위로 구성됩니다. Composable의 라이프사이클은 어떻게 될까요?) -->
Jetpack Compose에서 Composable은 UI를 구성하는 함수 단위이다. Composable은 전통적인 View와 달리 상태 기반으로 동작하며, 라이프사이클은 재구성(Recomposition) 중심으로 이해할 수 있다:
- **Initial Composition (최초 구성)**: Composable이 처음 화면에 그려질 때 호출. UI 트리가 생성됨.
- **Recomposition (재구성)**: 상태(State)가 변경될 때마다 Composable이 다시 호출되어 UI를 갱신. 예: 버튼 클릭으로 텍스트가 바뀌면 해당 Composable만 재구성.
- **Disposal (소멸)**: Composable이 더 이상 필요 없으면(화면에서 제거되거나 부모 Composable이 제거될 때) UI 트리에서 제거됨.
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
- `app`: 앱 모듈의 루트 폴더.
    - manifests
        - AndroidManifest.xml: 앱의 설정 파일. 앱의 컴포넌트(Activity, Service 등), 권한, 메타데이터 등을 정의. 예: 앱의 진입점 Activity 지정.
- `kotlin+java`: 소스 코드가 들어가는 폴더.
    - `package(com.apptive.app...)`: 앱의 주요 소스 코드(코틀린/자바 파일)가 위치. Activity, Composable 등이 여기 포함.
    - `package(androidTest)`: UI 테스트(Instrumentation Test) 코드가 위치. 에뮬레이터나 실제 기기에서 실행.
    - `package(test)`: 단위 테스트 코드가 위치. 로컬 JVM에서 실행.
- `res`: 리소스 파일(이미지, 문자열, 색상 등)이 들어가는 폴더.
    `drawable`: 이미지 파일(PNG, JPG)이나 XML로 정의된 벡터 그래픽 저장.
    `mipmap`: 앱 아이콘 이미지 저장 (생략).
    values
        - `colors.xml`: 앱에서 사용할 색상 정의. 
        - `strings.xml`: 자주쓰는 문자열 리소스 정의. 다국어 지원 가능.
        - `theme`: 테마 정의 (생략).
- `Gradle Scripts`: Gradle 빌드 시스템 관련 파일.
    - `build.gradle (Project)`: 프로젝트 전체 설정. 모든 모듈에 공통으로 적용되는 의존성, Gradle 플러그인 버전 정의.
    - `build.gradle (Module)`: 앱 모듈별 설정. 앱의 의존성(라이브러리), SDK 버전, 빌드 옵션 정의.
    - `settings.gradle`: 프로젝트 구조 정의. 포함된 모듈 목록과 설정 포함.
### Jetpack Compose
#### Layout
<!-- (Box, Column, Row, Spacer 등 **Jetpack Compose의 기본적인 레이아웃의 종류**에 대해 조사해주세요.) -->
- Box: 자식 요소를 겹쳐서 배치. 스택처럼 쌓는 레이아웃.
    - ex: 버튼 위에 텍스트를 겹치게 배치.
- Column: 자식 요소를 세로로 배치.
    - ex: 리스트처럼 세로로 나열. 
- Row: 자식 요소를 가로로 배치.
    - ex: 버튼을 가로로 나열.
- Spacer: 빈 공간을 추가. 요소 간 간격 조정.
    - ex: Spacer(modifier = Modifier.height(16.dp))로 16dp 높이의 간격 추가.

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
- 

## 참고자료
- 출처는 중요합니다. 되도록 작성해주세요.
- [!Android Developers 공식 문서](https://developer.android.com/guide/components/fundamentals)

## 비고
25.03.30 yeochaeeon 수정.

<!-- 커밋 테스트를 위한 수정 -->