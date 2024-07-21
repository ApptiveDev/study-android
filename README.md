# Navigation
 안드로이드 개발의 가장 중요한 뼈대가 되는 코틀린의 병렬 처리 기법 Coroutine에 대해 알아봅시다. 

## 📐 진행방식
- 현재 브랜치에서 `<자신의 기수>` 안드로이드 프로젝트 폴더를 엽니다.
  - 만약 `<자신의 기수>` 폴더가 없다면 안드로이드 스튜디오로 새로 만듭니다.
  - 새로 만드는 프로젝트의 패키지명은 `com.apptive.coroutine`로 합니다.
- 각자의 패키지를 정의하여 그곳에서 별도로 진행합니다. 
  - 과제 진행을 위한 초기 코드는 `com.apptive.coroutine.template` 패키지에 있습니다. 
  - 이곳의 파일을 자신의 패키지에 복사한 후 과제를 진행합니다.
  ```plain
  |- (패키지)
    |- (자신의 이름)
      - (template)의 파일 복사
    |- template    # 수정 금지
      - 초기 코드
      - ...
  ```
  - ex) `com.apptive.coroutine.junyoung.presentation`, `com.apptive.coroutine.jinseo.presentation`
- 자신의 패키지에서 과제를 구현하면서 수시로 commit, push합니다.

## 📑 문제
![timer start](./images/01-timer-start.gif)  
(타이머 시작 기능)  

![timer stop](./images/02-timer-stop.gif)  
(타이머 정지 기능)  

![timer reset](./images/03-timer-reset.gif)  
(타이머 리셋 기능)  


## 🌀 환경 요구사항
- Jetpack Compose(activityCompose)는 1.9.0v 이상을 이용합니다.
- Kotlin은 1.9.0v 이상을 이용합니다.
- Android Studio Iguana 이상의 환경에서 코드를 작성합니다.
- `org.jetbrains.kotlinx:kotlinx-coroutines-android` 종속성을 추가합니다.
  - 버전은 1.3.9v 이상을 이용합니다.
  - TOML 방식으로 추가합니다.
  
## 🧸 기능 요구사항
- 화면 중앙에 분, 초를 나타내는 타이머를 표시합니다.
  - 글자 크기는 60 sp, 폰트 굵기를 `Bold`로 설정합니다.
  - 항상 두 자리로 표시되어야 합니다. 일의 자리 수일 때에는 앞에 0을 붙입니다.
- 화면 하단에 `START`, `STOP`, `RESET` 버튼이 위치합니다.
  - `START` 버튼을 누르면 타이머가 동작합니다. (1초 씩 카운트)
    - 타이머가 동작하면 `STOP` 버튼으로 바뀝니다.
  - `STOP` 버튼을 누르면 타이머가 일시정지합니다.
    - 타이머가 정지하면 `START` 버튼으로 바뀝니다.
  - `RESET` 버튼을 누르면 타이머가 00분 00초로 초기화됩니다.
    - 타이머가 동작하는 도중에도 초기화 가능합니다.
- 타이머를 동작시킬 때에는 Coroutine을 사용합니다.
- 타이머를 정지시킬 때에는 Job을 이용합니다.

## 🔥 더 해보기
- 타이머 화면의 non-UI 로직을 ViewModel로 분리해보세요.
- 타이머를 밀리초 단위까지 확장해보세요.

## 궁금점과 질문
(코드를 작성하면서 자유롭게 적어주세요)
