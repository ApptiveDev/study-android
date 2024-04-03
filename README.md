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
    - [Views](#views)
    - [Jetpack Compose](#jetpack-compose)
- [Project Structure](#project-structure)
- [Jetpack Compose](#jetpack-compose-1)


### Android Components
(이해한 것을 적어주세요)

#### Activity
(이해한 것을 적어주세요)

#### Content Provider
(이해한 것을 적어주세요)

#### Service (Optional)
(이해한 것을 적어주세요)

#### Broadcast Receiver (Optional)
(이해한 것을 적어주세요)

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
    |- java
        |- package
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
(Box, Column, Row 등 Jetpack Compose의 기본적인 레이아웃의 종류에 대해 조사해주세요.)

## 할일
- 안드로이드 스튜디오 에뮬레이터 설정
- 안드로이드 스튜디오 SDK 설치 (28~)
- 안드로이드 스튜디오 USB/Wifi 디버깅

## 의논해볼 것
- [ ] 화면을 회전시키면 Activity의 Lifecycle은 어떻게 변할까요?
- [ ] Jetpack Compose 이전에는 Composable 대신 View 객체로 UI를 사용했습니다. 어떤 점이 다를까요? (Lifecycle 등)  
---

## 궁금한 점

## 참고자료

## 비고
