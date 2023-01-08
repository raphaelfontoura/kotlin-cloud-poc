package circuitbreaker

fun main() {
    val ds = CircuitBreakerConfiguration.getCircuitBreaker().decorateSupplier { listTest() }

    for (i in 1..20) {
        try {
            println(ds.get())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun listTest(): String {
    try {
        Thread.sleep(5000)
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }
    return "Olá mundo!"
}
