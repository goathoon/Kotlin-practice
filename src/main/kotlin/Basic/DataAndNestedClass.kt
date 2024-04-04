package Basic
// Data 클래스 == 데이터는 보유하지만 아무것도 하지 않는 클래스
// 기본생성자에 property를 만들어주는 식으로 작성

// equals()
// hashCode()
// copy()
// toString()
// componentN()
// 함수를 자동으로 생성

// 대신, 기본 생성자로 표현한 Property(val, var) 에 한해서만 자동으로 저런 함수를 작성해주는 것
data class User(val name:String, val age:Int)
class NoDataUser(var name: String, var age: Int)

// 이 때, 파라미터가 없이 Data 클래스를 생성하고 싶은 경우에, Data 클래스의b 기본 생성자 파라미터들에 default값을 대입한다.
data class UserDefault(val name: String ="",val age: Int = 0)


//물론, Data Class에서도 기본 생성자가 아닌, 프로퍼티 값을 Body에서 설정할 수 있긴 함.
//하지만 내부적으로 만들어지는 함수가 만들어지진 않는다.




// ** Nested Class **

// 중첩 클래스
class Outer1 {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}
// 이런식으로 Outer클래스를 생성하지 않고, Outer클래스 이름에 '.' 찍고 nested class 생성하고 함수 호출
// Outer클래스를 생성하지 않았으므로, Outer 클래스에 bar 변수를 Nested 클래스에서 호출할 수 없음
val test1 = Outer1.Nested().foo() // 2


// 내부 클래스

// inner 키워드를 붙이면, 바깥쪽 클래스 멤버 변수에 접근할 수 있다.
class Outer2 {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar
    }
}
// inner 클래스의 객체를 만드려면 Outer 클래스를 생성하고 inner 클래스를 생성해야만 한다.
val test2 = Outer2().Inner().foo() // 1 (bar 값 알수있음)




fun main() {
    val obj = User("Goat",28)
    println(obj) // toString() 메서드 떄문에 이것이 가능해짐.
    val noData = NoDataUser("Goat", 28)
    println(noData) // 클래스@해시값 등장

    // Destructuring Declarations
    // Data 클래스들은 Destructuring Declaration을 사용해서 변수들에 값을 대입할 수 있다.
    // 이렇게 할 수 있는 이유 컴파일러가 componentN 함수를 자동으로 만들어 주기 때문이다.
    var user = User("Goat", 28)
    val (name, age) = user
    println("이름은 ${name}이고, 나이는 ${age}입니다 ")

    //만약 destructuring이 지원되지 않으면, 아래와 같은 방식으로 해야하는데 매우 귀찮지 않을까?
    val name1 = user.name
    val age1 = user.age
    println("이름은 ${name1}이고, 나이는 ${age1}입니다 ")

}