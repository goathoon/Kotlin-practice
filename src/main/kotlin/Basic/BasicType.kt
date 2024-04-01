package Basic

// Kotlin의 Type은 항상 class이다.
// Kotlin의 숫자는 Java Platform에서 구동될 경우 JVM primitive type으로 저장된다.
// 하지만, Nullable 이나 제네릭의 경우, 박싱된다.
// 박싱된 경우에는, identity를 유지하지 않는다.


class TestClass(val value: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TestClass) return false
        return value == other.value
    }
}

fun test() {
    var a: TestClass = TestClass(10000)
    var b: TestClass? = TestClass(10000)
    println("a === b: ${a === b}")
    println("a == b: ${a == b}")

    val x: Int = 1
//    val y:Long = x
    // Explicit Type들은 AutoCasting이 되지 않으므로, 변환함수 사용
    val y:Long = x.toLong()

    var array: Array<String> = arrayOf("안녕", "하세요")
    println(array.get(0))

    val array_ex = Array(4,{i -> i.toString()})
    for(e in array_ex){
        println(e);
    }
}

fun main() {
    test()
}
