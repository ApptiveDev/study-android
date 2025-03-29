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
**앱에서 하나의 화면을 나타내는 컴포넌트**   
- UI 표시 (XML 레이아웃 연결)  
- 사용자 입력 처리  
- 다른 Activity 이동  
- 생명주기 관리 (onCreate, onPause...)  

#### Content Provider
**앱 간 데이터를 공유할 수 있게 해주는 컴포넌트**  
- 앱 간 데이터 공유  
- 쿼리 인터페이스 제공 (query(), delete()...)  
- URI 기반 식별 (URI 형태로 데이터 접근)  

### Intent
**안드로이드 시스템에 요청하는 메시지**   
1. 명시적 인텐트 : 어느 컴포넌트로 갈지 명확히 지정   
2. 암시적 인텐트 : 어떤 동작인지만 표현   

### Android Lifecycle
#### Activity
**Activity의 생명주기란?**   
onCreate() -> (onRestart()) -> onStart() -> onResume() -> onPause() -> onStop() -> onDestroy()     
- 데이터 유실 방지   
- 배터리, 성능 최적화   
- onRestart()는 onStop() 이후 다시 화면에 나타날 때 호출된다.   

#### Composable
**상태(State)에 따라 재구성되는 UI구조** 
최초 호출 (Composition) -> 상태 변경 감지 시 재호출 (Recomposition) -> 조건 빠지면 제거 (Decomposition)   
- 함수이기 때문에 재호출 가능    
- '어떤 상태에서 재구성되느냐' 가 중요    

#### Activity (언제 호출되냐) vs Composable (어떤 상태에 재구성되는가)

### Project Structure
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
- manifests/AndroidManifest.xml : UI인 xml 파일 
- kotlin+java/package(com.apptive.app...) : 전반적인 앱의 동작을 담당하는 파일
- res/drawable : 아이콘이나 글꼴 등 사용자 정의 파일들 모음
- res/values/colors.xml : 앱에 사용되는 글꼴이나 블럭의 색상 코드를 색상 이름 ID와 매칭해둔 파일
- res/values/strings.xml : 앱에서 자주 사용되는 문자열을 특정 ID로 등록해둔 파일
- Gradle Scripts/build.gradle(Module) : 프로젝트에 사용되는 모듈에 대한 gradle 설정 
- Gradle Scripts/settings.gradle : gradle 기본 설정 파일 

### Jetpack Compose
#### Layout
**Jetpack Compose에서 UI를 어떻게 배치하느냐**
1. Box : 겹치게 배치    ㄴ align()으로 위치 지정
2. Column : 세로 방향 정렬    ㄴ verticalArrangment(간격)/horizontalAlignment(수평정렬)
3. Row : 가로 방향 정렬   ㄴ horizontalArrangement(좌우 정렬)/verticalAlignment(상하정렬)
4. Spacer : 공간 만들 때   ㄴ height,width로 원하는 공간 삽입 

#### Entry Point
(아래는 Jetpack Compose 프로젝트르 생성했을 때 기본적으로 생성되는 코드입니다. 앱에서 가장 처음 실행되는 코드이기도 합니다. 각 문장이 무엇을 의미하는지 주석을 달아주세요.)

```kotlin
class MainActivity : ComponentActivity() {    // compose 기반 UI 사용 
    override fun onCreate(savedInstanceState: Bundle?) {   // 생명주기 함수 onCreate 
        super.onCreate(savedInstanceState)
        setContent {  // compose로 UI 구성하는 엔트리 부분 
            LayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),   // 화면 전체 채우는 사이즈 
                    color = MaterialTheme.colorScheme.background
                ) {    
                    Greeting("Android")  // Greeting composable 함수 호출 
                }
            }
        }
    }
}

@Composable   // composable 함수 정의 
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
25.03.24 KimGiyun 수정.
