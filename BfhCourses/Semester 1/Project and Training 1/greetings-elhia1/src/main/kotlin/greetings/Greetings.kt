@file:JvmName("Greetings")

package greetings

fun getGreeting(city: String): String {
    // TODO: Your code goes here
   return ""
}

fun main() {
    println("Enter a city: ")
    val city : String = readLine()!!
    println(getGreeting(city))
}
