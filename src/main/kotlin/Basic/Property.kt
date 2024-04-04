package Basic

// Kotlin의 Property != Java의 Field
// 기본적으로 Property는 다음과 같이 선언된다.
class Student{
    var name: String = "Goat"
    val school: String = "SKKU"
}
//얼핏 보면, 자바의 Field와 같다고 느껴진다.

//하지만, Kotlin의 Property는 getter, setter가 숨겨져있다.
// 즉, Property는 Java의 Field처럼 사용할 수 있지만, 내부적으로는 함수를 호출한다.

// 하지만 Property의 getter setter도 다음과 같이 재정의할 수도 있다
class Example{
    var name: String = "Kotlin"
        get() {return field + "!!!!"}
        set(value) {field = value}
    // 이 때, field는 property를 위한 고유 예약어임
}

fun main() {
    var obj = Example()
    println(obj.name) // Kotlin!!!! 출력
    obj.name = "Change"
    println(obj.name) // Change!!!! 출력

    //위 과정을 byte code로 바꾸고 java로 decompile 하면 아래처럼 동작한다.
    //    Example obj = new Example();
    //    String var1 = obj.getName();
    //    System.out.println(var1);
    //    obj.setName("Change");
    //    var1 = obj.getName();
    //    System.out.println(var1);
}