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
사용자와 상호작용을 담당하는 인터페이스(UI).
앱을 실행할 때에는 앱을 전체적으로 호출하지 않고 액티비티를 호출한다.

다음은 Activity의 특징이다:
- 액티비티는 Intent를 통해 다른 어플리케이션의 액티비티를 호출할 수 있다.
- 2개 이상의 액티비티를 동시에 display 할 수 없다.
- 1개 이상의 View(텍스트, 버튼, 이미지) 또는 ViewGroup(레이아웃)을 포함한다.
- 반드시 어플리케이션에는 하나 이상의 액티비티가 있어야 한다.
- 액티티 내에 fragment를 추가하여 화면을 분할할 수 있다.

#### Content Provider
데이터를 관리하고 다른 어플리케이션의 데이터를 제공하는 데 사용되는 컴포넌트.
특정한 어플리케이션이 사용하고 있는 데이터베이스를 공유하기 위해 사용되며, 어플리케이션 간의 데이터 공유를 위해 표준화 된 인터페이스를 제공한다.

다음은 Content Provider의 특징이다:
- SQLit DB/ Web/ 파일 입출력 등을 통해 데이터를 관리한다.
- 외부 어플리케이션이 현재 실행중인 어플리케이션 내에 있는 데이터베이스에 함부로 접근하지 못하게 하는 동시에 자신이 공개/공유하고 싶은 데이터만 공유할 수 있도록 한다.
- 음악/사진 파일 등과 같이 용량이 큰 데이터들을 공유하는 데에 적합하다. (작은 데이터들은 intent로 어플리케이션 간의 상호 공유가 가능하다.)
- 데이터의 read, write에 대한 permission이 있어야 어플리케이션에 접근 가능하다.
- 데이터베이스에서 흔히 사용되는 CRUD 원칙을 준수한다.

### Intent
안드로이드 시스템에서 컴포넌트 간의 통신을 위해서 사용되는 메세징 객체.
인텐트를 사용하면 Activity, Service, Broadcast Reciever와 같은 컴포넌트를 시작하거나, 데이터를 전달하고 결과를 수신할 수 있다.

인텐트는 크게 두 가지의 경우로 구분된다:
- Explicit Intent: 대상 컴포넌트의 정확한 클래스 이름을 지정하여 사용된다. 이를 통해 개발자는 특정 컴포넌트를 시작하거나 통신할 수 있다.
- Implicit Intent: 특정 작업을 수행하는 컴포넌트를 시스템에 요청한다. 대상 컴포넌트 클래스의 이름을 지정하는 대신에 수행할 action과 data를 지정하고, 시스템은 이 정보를 바탕으로 적절한 컴포넌트를 찾아서 실행한다. (ex: 웹 브라우저를 사용하여 URL을 여는 경우)

인텐트를 통해 데이터를 전달하기도도 하며, 앱 컴포넌트 간의 통신 및 상호작용을 가능하게 한다.

### Android Lifecycle
#### Activity
![Activity Lifecycle](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcaWteT%2FbtrVEpLpzc9%2FOwBMDEr753cfvDxuom02y1%2Fimg.jpg)
1. onCreate()
    - 액티비티가 생성되면 가장 먼저 호출된다.
    - 화면 layout 정의, view 생성, databinding 등을 이곳에 구현한다.
    - lifecycle 전체에서 단 1번만 수행된다. 따라서 액티비티 최초 실행에 해야 하는 작업을 수행하기에 적합하다.

2. onStart()
    - 액티비티가 화면에 표시되기 직전에 호출된다.
    - 화면에 진입할 때마다 실행되어야 하는 작업을 이곳에 구현한다.

3. onResume()
    - 액티비티가 화면에 보여지는 직후에 호출된다.
    - 현재 액티비티가 사용자에게 포커스인 되어있는 상태이다.

4. onPause()
    - 액티비티가 화면에 보여지지 않는 직후에 호출된다.
    - 현재 액티비티가 사용자에게 포커스아웃 되어있는 상태이다.
    - 다른 액티비티가 호출되기 전에 실행되기 때문에 무거운 작업을 수행하지 않도록 주의해야 한다.
    - 영구적인 데이터는 이곳에 저장한다.

5. onStop()
    - 액티비티가 다른 액티비티에 의해 완전히 가려질 때 호출되는 메소드이다.
    - 홈 키를 누르는 경우에, 다른 액티비티로의 이동이 있는 경우가 있다.
    - 이 상태에서 액티비티가 호출될 때, onRestart() 메소드가 호출된다.

6. onDestroy()
    - 액티비티가 완전히 종료되었을 때 호출되는 메소드이다.
    - 사용자: finish(), onBackPressed() (기존 액티비티의 onResume()까지 호출된 후 onDestroy() 호출)
    - 시스템: 메모리 부족 (프로세스 종료)
    - onStop(), onDestroy() 메소드는 메모리 부족이 발생하면 생략될 수 있다.

7. onRestart()
    - onStop()이 호출된 이후 다시 기존 액티비티로 돌아오는 경우에 호출된다.
    - 호출 이후 이어서 onStart()가 호출된다.

#### Composable
![Composable Lifecycle](https://developer.android.com/static/develop/ui/compose/images/lifecycle-composition.png?hl=ko)
1. Initial Composition: 처음 UI가 컴포지션될 때, composable 함수가 호출된다. composable 함수가 composition 트리에 추가된다.

2. Recomposition: 상태 변화 등으로 인해 UI가 갱신되어야 할 때, 해당 composable 함수가 다시 호출된다. 이때 변경된 내용이 없다면 건너뛰어 진다.

3. Disposal: UI가 더이상 필요하지 않을 때, 자원이 해제된다. composable 함수가 composition 트리에서 제거된다.

### Project Structure
(Android Studio에서 프로젝트를 새로 시작하면 기본적인 폴더 구조가 설정됩니다.  
아래를 참고하여 각 폴더와 파일의 역할에 대해 이해하는 바를 적어주세요.)
```plain
|- app
    |- manifests //아래의 하나의 파일이 담겨져 있다. 안드로이드 어플리케이션을 구동하는 데 필요한 설정값을 관리하는 곳으로, 일종의 컨트롤 타워.
        - AndroidManifest.xml
    |- kotlin+java //클래스를 관리하는 폴더
        |- package(com.apptive.app...)
        |- package(androidTest)
        |- package(test)
    |- res //resource 폴더로, UI와 관련된 파일과 디자인 리소스/문자열 리소스를 담고 있는 폴더이다.
        |- drawable //jpg, png, gif, 9.png와 같은 사진 파일과 안드로이드에서 그림을 표현할 수 있는 특수 xml 파일이 위치한다. 그림과 관련된 요소는 모두 여기에 저장한다.
        |- mipmap (생략해도 됨)
        |- values //문자열, 색, 스타일(styles.xml)과 같은 단순한 값이 들어있는 xml 파일.
            - colors.xml
            - strings.xml
            |- theme (생략해도 됨)
|- Gradle Scripts //안드로이드 스튜디오는 Gradle(그레이들) 이라고 하는 빌드 시스템을 사용한다. 그래서 프로젝트의 각 모듈에는 build.gradle 파일이 하나씩 필요하다.
    - build.gradle(Project) //프로젝트 수준의 그레이들 설정 파일.
    - build.gradle(Module)  //모듈(앱) 수준의 그레이들 설정 파일.
    - settings.gradle       //프로젝트 생성 시에 자동으로 생성되며 어떤 모듈이 프로젝트에 포함되는지 기술된다.
```

### Jetpack Compose
#### Layout
(Box, Column, Row, Spacer 등 **Jetpack Compose의 기본적인 레이아웃의 종류**에 대해 조사해주세요.)
- Box: 요소를 다른 요소 위에 놓음.
- Column: 항목을 화면에 세로로 배치함.
- Row: 항목을 화면에 가로로 배치함.
- Spacer: 요소들 사이의 간격을 조절하는 데 사용.
- LaxyColumn & LaxyRow: 많은 데이터를 효율적으로 표시하는 리스트 형태의 레이아웃.

#### Entry Point

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //composable UI의 시작점이다. 레이아웃을 정의한다.
            LayoutTheme { //안드로이드 스튜디오가 기본적으로 만들어둔 프로젝트의 테마(Theme). composable에 대한 전역 설정.
                // A surface container using the 'background' color from the theme
                Surface( //composable의 컨테이너. composable의 집합을 시각적으로 표현하기 쉽게 도와준다.
                    modifier = Modifier.fillMaxSize(), //surface에 적용될 modifier //화면 전체를 채우도록 설정정
                    color = MaterialTheme.colorScheme.background //배경색
                ) {
                    Greeting("Android") //Greeting 함수를 호출하며, "Android" 문자열을 전달한다.
                }
            }
        }
    }
}

@Composable //이 함수가 composable UI를 구성하는 함수임을 나타낸다.
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text( //텍스트 표시시
        text = "Hello $name!",
        modifier = modifier //외부에서 전달받은 modifier 적용용
    )
}

@Preview(showBackground = true) //어노테이션 //함수에 @Preview 어노테이션이 붙으면 미리보기가 가능하다. IDE에서 컴포넌트 UI를 안드로이드 에뮬레이터의 실행없이 바로 확인할 수 있다.
@Composable
fun GreetingPreview() {
    LayoutTheme { //테마 적용용
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
