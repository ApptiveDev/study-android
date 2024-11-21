# Kotlin 기초
안드로이드 개발은 Kotlin으로 작성됩니다. 본격적으로 라이브러리와 프레임워크를 배우기 전에, Kotlin 언어의 문법에 익숙해지도록 합시다.

## 진행방식
1. 멘토는 <기수> 폴더를 새로 만듭니다.
  - `ex) 21st, 22nd, 23rd, 24th...`
2. 스터디원은 <기수> 폴더에 `/problem.kt` 파일을 복사, 붙여넣기 후 자신의 이름으로 변경합니다.
  - `ex) problem.kt -> wonseok.kt`
3. 아래 문제를 풀고 코드를 작성합니다.
  - 커밋 및 푸쉬 바랍니다.

## 문제
* __과제의 문제는 모던 자바 인 액션 이라는 책의 코드를 코틀린으로 변환해 만들었습니다.__
* 아래는 기본으로 주어지는 코드입니다.
``` kotlin
/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */
import java.util.Random
import java.text.DecimalFormat


class Trader{
    private var name:String
    private var city:String
    
    init{
        name = ""
        city = ""
    }
    
    constructor(n:String, c:String){
        name = n
        city = c
    }
    
    fun setName(name:String){
        this.name = name
    }

    fun getName(): String {
        return this.name
    }


    fun setCity(city:String){
        this.city = city
    }

    fun getCity(): String {
        return this.city
    }
    
    override fun toString(): String {
        return String.format("Trader:%s in %s", name, city)
    }

}

class Transaction {
    private var trader: Trader?
    private var year: Int
    private var value: Int
    init {
        trader = null
        year = 0
        value = 0
    }
    
    constructor(trader: Trader, year: Int, value: Int){
        this.trader = trader
        this.year = year
        this.value = value
    }
    
    fun setTrader(trader: Trader){
        this.trader = trader
    }
    
    fun getTrader(): Trader? {
        return if(this.trader != null)
            this.trader
        else Trader("NULL","NULL")
    }
    
   
    fun setYear(year: Int){
        this.year = year
    }

    fun getYear(): Int {
        return this.year
    }
    
    fun setValue(value: Int){
        this.value = value
    }
    
    fun getValue(): Int {
        return this.value
    }
    
    
    override fun toString(): String {
        return String.format("{%s, year: %d, value: %d}", trader, year, value)
    }

}

fun main(){
    val raoul = Trader("Raoul","Cambridge")
    val mario = Trader("Mario","Milan")
    val alan = Trader("Alan","Cambridge")
    val brian = Trader("Brian","Cambridge")
    
    val transactions = arrayListOf<Transaction>(
        Transaction(brian,2011,300),
        Transaction(raoul,2012,1000),
        Transaction(raoul,2011,400),
        Transaction(mario,2012,710),
        Transaction(mario,2012,700),
        Transaction(alan,2012,950)
    )
}
```

1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
5. 밀라노에 거래자가 있는가?
6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
7. 전체 트랙잭션 중 최댓값은 얼마인가?
8. 전체 트랜잭션 중 최솟값은 얼마인가?
 