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