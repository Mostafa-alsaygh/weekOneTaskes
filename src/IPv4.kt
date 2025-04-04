fun main() {
    fun check(name: String, result: Boolean, correctResult: Boolean) {
        println(if (result == correctResult) "✅ $name" else "❌ $name")
    }

    println("|--- Running IPv4 Validator Tests ---|")

    check(
        name = "valid simple IPv4 address",
        result = isValidIPv4("192.168.1.1"),
        correctResult = true
    )

    check(
        name = "valid minimum value IPv4 address",
        result = isValidIPv4("0.0.0.0"),
        correctResult = true
    )

    check(
        name = "valid maximum value IPv4 address",
        result = isValidIPv4("255.255.255.255"),
        correctResult = true
    )

    check(
        name = "valid mixed value IPv4 address",
        result = isValidIPv4("10.0.200.5"),
        correctResult = true
    )

    check(
        name = "single zero should be valid",
        result = isValidIPv4("192.168.0.1"),
        correctResult = true
    )

    check(
        name = "empty string should be invalid",
        result = isValidIPv4(""),
        correctResult = false
    )

    check(
        name = "missing segments should be invalid",
        result = isValidIPv4("192.168.1"),
        correctResult = false
    )

    check(
        name = "begin with zero should be invalid",
        result = isValidIPv4("092.068.001"),
        correctResult = false
    )

    check(
        name = "extra segments should be invalid",
        result = isValidIPv4("192.168.1.1.1"),
        correctResult = false
    )

    check(
        name = "the segment value more then 255 should be invalid",
        result = isValidIPv4("256.1.1.1"),
        correctResult = false
    )

    check(
        name = "negative segment value should be invalid",
        result = isValidIPv4("192.-1.1.1"),
        correctResult = false
    )

    check(
        name = "leading zeros should be invalid",
        result = isValidIPv4("192.168.01.1"),
        correctResult = false
    )

    check(
        name = "double zeros should be invalid",
        result = isValidIPv4("192.168.00.1"),
        correctResult = false
    )

    check(
        name = "triple zeros should be invalid",
        result = isValidIPv4("192.168.000.1"),
        correctResult = false
    )

    check(
        name = "contains letters should be invalid",
        result = isValidIPv4("192.a.1.1"),
        correctResult = false
    )

    check(
        name = "contains letters and numbers should be invalid",
        result = isValidIPv4("192.1b.2.1"),
        correctResult = false
    )

    check(
        name = "contains letters and numbers should be invalid",
        result = isValidIPv4("192.1b.2@.1"),
        correctResult = false
    )

    check(
        name = "contains spaces should be invalid",
        result = isValidIPv4("192. 168.1.1"),
        correctResult = false
    )
    check(
        name = "contains spaces should be invalid",
        result = isValidIPv4("192. 168.1.1 "),
        correctResult = false
    )

    check(
        name = "contains spaces should be invalid",
        result = isValidIPv4("192 . 16 8.1.1"),
        correctResult = false
    )

    check(
        name = "missing dots should be invalid",
        result = isValidIPv4("19.216811"),
        correctResult = false
    )

    check(
        name = "missing dots should be invalid",
        result = isValidIPv4("19216811"),
        correctResult = false
    )

    check(
        name = "extra dots should be invalid",
        result = isValidIPv4("192..168.1..1"),
        correctResult = false
    )

    check(
        name = "extra dots should be invalid",
        result = isValidIPv4("192.168.1..1"),
        correctResult = false
    )

    check(
        name = "leading dot should be invalid",
        result = isValidIPv4(".192.168.1.1"),
        correctResult = false
    )

    check(
        name = "trailing dot should be invalid",
        result = isValidIPv4(".192.168.1.1."),
        correctResult = false
    )

    check(
        name = "trailing dot should be invalid",
        result = isValidIPv4("192@168#1.1."),
        correctResult = false
    )

}

fun isValidIPv4(ip: String): Boolean {

    return false
}