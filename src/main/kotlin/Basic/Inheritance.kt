package Basic

//코틀린의 최상위 클래스는 Any이다.
//클래스에 상위 타입을 선언하지 않으면 Any가 상속된다.
class Example1
class Example2 : Any() //명시

//하지만 그렇다고, Any가 java.lang.Object와 같지 않다.
//Any() 에는 equals, hashCode, toString 메서드만 존재한다.


// 상속 조건
// 상속을 해줄 클래스가 반드시 'open' 키워드를 가지고 있어야 한다.
open class AA(x: Int)

//class BB : AA(1) // 이렇게하는건 당연히 흔치 않겠다.
class BB(x:Int): AA(x) // 이렇게 해야 상속을 받은 클래스의 기본 생성자로, 상위 클래스의 생성자를 호출할 수 있게 된다.

// 자식 클래스에 기본 생성자가 없는 경우
// 각각의 보조 생성자에서 상의 클래스를 super를 통해 초기화 해야한다.
// 또한, 다른 생성자에게 상위 타입을 초기화할 수 있게 위임해야한다.
open class View {
    constructor(x: Int) {}
    constructor(x: Int, y: Int){}

}
class MyView : View{
    constructor() : super(1)
    constructor(ctx: Int) : this()
    constructor(ctx: Int, attrs: Int) : super(ctx,attrs)
}

// Kotlin에서 모든 Class는 final이다.
// 따라서, 상속해줄려면 open 키워드를 사용해야함.

// 메소드 오버라이딩
// - 오버라이딩 '될' 메서드 : open 어노테이션 필요
// - 오버라이딩 '된' 메서드 : override 어노테이션 필요

open class Base(x:Int) {
    open fun test() {}
    fun nv(){}
}
class Derived(x:Int) : Base(x){
    override fun test(){
        println("hello")
    }
}


// 프로퍼티 오버라이딩
// 메서드 오버라이딩과 비슷한 방식


// [모호성] 오버라이딩 규칙
// Kotlin에서는 자바처럼, 단일 상속의 제약이있고, 여러가지 인터페이스를 구현할 순 있다.
// 이 때, 같은 멤버에 대한 중복된 구현을 상속받은 경우, 상속받은 클래스는 해당 멤버를 오버라이딩하고, 자체 구현을 제공해야 한다.

open class A {
    open fun f() { println("A") }
    fun a() {println("a")}
}
interface B{
    fun f(){println("B")}
    fun b(){println("b")}
}
class C(): A(), B{
    override fun f(){
        println(1)
        super<A>.f()
        println(2)
        super<B>.f()
        println(3)
    }
}

// 예제
fun main(){
    val obj =C()
    obj.f() // 1 \n A \n 2 \n B \n 3 출력됨
}