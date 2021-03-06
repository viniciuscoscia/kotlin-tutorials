package com.kotlinexercises

import java.nio.file.Paths

fun main(args: Array<String>) {

}

fun functionWithLambdaAsParameter(x: String, fn: (String) -> String): Unit{
    val applied = fn(x)
    println(applied)
}

fun AnonymousFunction() {
    fun(x:Int, y: Int): Int = x + y
}

fun lambdaExpressionExemplos() {
    val sayHello = { user: String ->
        println("Hello, $user!")
    }
    sayHello("johnny")

    val somar = {x: Int, y: Int -> x + y}

    val conciseLambda: (Int, Int) -> Int = {x, y -> x + y}

    val teste = {println("42")}

    teste.invoke()
}

fun comparacao() {
    var point1 = Point(x = 1, y = 2)
    var point2 = Point(x = 1, y = 2)

    println(point1 == point2) //true, pois compara valores
    println(point1 === point2) //false, pois compara referência de objtos
}

/**
 * Operator Overload
 * -- e ++ Não funcionam nessa porra
 */
data class Point(val x: Int, val y: Int){
    operator fun Point.unaryMinus() = Point(-x, -2*y)
    operator fun Point.inc() = Point(x+2, y+3)

    fun printExampleOperatorOverload() {
        println("UnaryMinus(): ${-this}\n")
        println("Inc(): ${this.inc()}")
    }
}

/**
 * Operator Overload 2
 */
class MyClass(val a: Int, val b: Int, val c: Int, val d: Int ){
    operator fun plus(myClass: MyClass): MyClass {
        return MyClass(a + myClass.a, b + myClass.b, c + myClass.c, d + myClass.d)
    }
}

fun repeatSample() {
    repeat(5) {println("Quero minha casa")}
}

/**
 * //TODO entender melhor
 */
fun runSample() {
    val outputPath = Paths.get("/user/home").run {
        val path = resolve("output")
        path.toFile().createNewFile()
        path
    }
}

/**
 * WITH: É um método que você trabalha dentro de um objeto, note que abaixo foi usado o método append() sem
 * precisar chamar por StringBuilder, também não foi necessário dar return
 */
fun alphabetWithSample() = with(StringBuilder()){
    for(letter in 'A'..'Z'){
        append(letter)
    }

    append("\nNow i know all the alphabet")
    toString()
}

/**
 * LET: Dá um "calote" no Null Safety, verificando antes a nulidade e podendo passar um objeto nullable
 * em um método que não aceita esse tipo
 */
fun letSample() {
    fun sendMailTo(email: String){println("Enviando e-mail para $email")}

    var email: String? = null

    email?.let { email -> sendMailTo(email) }
}

/**
 * APPLY: Permite chamar métodos de um objeto de maneira mais curta
 */
fun applySample(){

    //Without Apply
    val task = Runnable { println("Running") }
    val thread = Thread(task)

    thread.isDaemon = true
    thread.start()

    //With Apply
    val task2 = Runnable { println("Running") }
    Thread(task2).apply { isDaemon = true }.start()
}

fun extensionFunctionSample() {
    fun String.lastChar() = this.get(this.length - 1)

    val exemplo = "Exemplo"
    println(exemplo.lastChar())
}

/**
 * Varargs é pra mandar uma quantidade variável de parâmetros
 */
fun varArgsSample(vararg strings: String){
    strings.forEach { println(it) }

    var lista = arrayOf("A", "B", "C")

    varArgsSample(*lista) //É POSSÍVEL PASSAR UMA ARRAY USANDO UM ASTERISCO
}

class Account {
    var balance = 0.0

    infix fun add(amount: Double){
        this.balance = amount + amount
    }

    fun testeAdd() {
        var conta = Account()

        conta add 100.00

        println(conta.balance)
    }
}

fun namedArgumentsSample() {
    fun printInformacoesPessoa(name: String, age: Int, isMale: Boolean) = println("Nome: $name, idade: $age, Sexo masculino: $isMale")

    printInformacoesPessoa(name = "João", age = 24, isMale = true)
}

fun localFunctionCalculateArea(width:Int, height: Int) {
    fun calculateArea(width:Int, height: Int) = width * height

    val area = calculateArea(width, height)

    println(area)
}

fun singleExpressionFunction(k:Int) = k*k

fun breakingTheLoop() {
    var i = 0
    var j = 0

    loopTeste@ for(i in 1..10){
        for(j in 1..10){
            if(j==5) break@loopTeste
        }
    }
}

fun forEach(){
    var list = listOf<Int>(1, 2, 3, 4)

    for(num in list){
        println(num)
    }

    list.forEach { println(it) }
}

fun ranges() {
    var x = 1

    println(x in 1..10)

    for(i in 1 until 5)
        println("Until $i")

    for(i in 1..5)
        println("$i..5")

    for(i in 5 downTo 1)
        println("$i of 5 down to 1")

    for(i in 1..10 step 2)
        println("$i 1..10 step 2")
}

fun whenStatementWithoutArgs() {
    println(when {
        0 < 1 -> "Teste 1"
        0 == 0 -> "teste 2"
        else -> "Fodasse"
    })
}

fun whenStatementWithSmartCasting(x: Any): Boolean {
    return when(x){
        is String -> x.startsWith("foo")
        is Int -> x > 0
        else -> false
    }
}

fun whenStatementWithInOperator(x: Int) {
    val validNumbers = -30..0
    println(when (x) {
        in 1..10 -> "x is in the range"
        in validNumbers -> "x is valid"
        else -> "Batata"
    })
}

fun whenStatementInVariableReturn(x: Int): Boolean {
    return when(x){
        1 -> true
        2 -> false
        else -> false
    }
}

fun whenStatementInVariable() {
    val idioma = "Portuguese"
    val saudacao = when(idioma){
        "Portuguese" -> "Olá, tudo bem?"
        "English" -> "Hello, how are you?"
        "Favelado" -> "E aí mano bráu!!!!!!!!!1111"
        else -> null
    }

    println(saudacao)
}

fun notNumAssentionExclamacaoDupla() {
    val nullableName: String? = "George"
    val name:String = nullableName!!
    println(name)
}

fun safeCallSample(){
    val ceo = Employee("Chefe do Vinicius Coscia")
    val developer = Employee("Vinicius Coscia", ceo)

    println(managerName(ceo))
    println(managerName(developer))
}

fun managerName(employee: Employee): String? = employee.manager?.name

/**
 * Exemplo Elvis Operator
 */
fun elvisOperator() {
    var str1 = "batata"
    var str2: String? = null
    var str1_2: String = str2 ?: "Agora vai!"

    println(str1)
    println(str2)
    println(str1_2)
}

/**
 * Exemplo null safety
 */
fun strLenSafe(s: String?) {
    println(s?.length)
}

/**
 * Exemplo de intervalos (ranges)
 */
fun loopFor1(args: Array<String>){
    for(arg in args){
        println(args)
    }
}

/**
 * Exemplo de intervalos (ranges)
 */
fun loopFor2(args: Array<String>){
    for(i in args.indices){
        println(args[i])
    }
}

/**
 * Exemplo de intervalos (ranges)
 */
fun criarIntervalos(){
    println("Closed Range ..")
    var numbers = 1..10
    for (number in numbers) {
        println(number)   //Imprime de 1 a 10
    }

    println("Half Closed Range (until)")
    var newNumbers = (1 until 10)
    for (number in newNumbers) {
        println(number)   //Imprime de 1 a 9
    }
}

/**
 * Função com Lambda
 */
fun arrayListWithLambda(): IntArray {
    val arr = IntArray(10) { i -> i * 2 }
    return arr
}

/**
 * Tipo Unit +- igual void em java - Significa apenas uma instância (Singleton)
 */
fun testeUnit(): Unit {
    println(1)
}

/**
 * Exemplo de Smart Casting
 */
fun smartCastExample(var1: Any){
    when (var1) {
        is String -> println("A variável é String e seu valor é ''$var1''")
        is Int -> println("A variável é Int e seu valor é $var1")
    }
}

/**
 * Exemplo de Explicit Casting
 */
fun explictCastSample(var1: Any) {
    var var2: String? = var1 as? String

    when(var2){
        null -> var2 = "Variável estava nula por erro no cast"
    }

    println(var2)
}

class Employee(val name: String, val manager: Employee? = null)