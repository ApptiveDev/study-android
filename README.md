# Android UI

## 목표
Android UI 프레임워크인 Jetpack Compose에 대한 기본 다루기

## 문제
![login](https://i.imgur.com/2kGMASJ.png)
Jetpack Compose를 통해 위 UI를 구현해주세요.  
텍스트 박스 동작, 버튼 동작 등 기능은 구현하지 않아도 됩니다.

## 구현 화면
![login_impl](https://i.ibb.co/rsWvxJQ/image.png)

## 요구사항
- Jetpack Compose v1.2.1 사용 ➡️ 만족
- 아래와 같은 패키지로 작성함
```plain
|- (패키지)
    |- _enum
        - FormType
    |- view
        - LoginScreen.kt
        - LoginViewModel.kt
    - MainActivity.kt
```

## 소스
- https://github.com/Apptive2022-1/apptive-android-study/tree/android-ui/uzun/composeuistudy/app/src/main/java/com/apptive/compose_ui_study/

## 추가한 기능
- 배경
	- Box 를 이용한 이미지 배경
	- Modifier.backgroud의 brush 를 이용한 그라디언트
- input 필드
	- 간단한 커스텀
	- placeholder
	- 상태를 ViewModel로 간단하게 뺌
- Button
	- 로그인 버튼
	- 아이콘이 들어간 버튼


<<<<<<< HEAD
=======
## 궁금한 점

## 참고자료
![image](https://user-images.githubusercontent.com/84652886/199020258-05aa7d6c-6542-49f6-8d5f-a3c47335c746.png)

## 비고
>>>>>>> f3da19f (Update README.md)

