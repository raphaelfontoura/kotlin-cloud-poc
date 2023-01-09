package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    test()
    println("Hello ")
}

suspend fun test() {
    delay(5000)
    print(" World")
}