package com.kotlinexercises

fun main(args: Array<String>) {
    safeCallSample()
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
    var var2: String = var1 as String
}

class Employee(val name: String, val manager: Employee? = null)