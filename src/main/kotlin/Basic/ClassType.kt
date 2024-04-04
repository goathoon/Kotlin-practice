package Basic

// **기본 생성자**
// 클래스 별로 1개만 가질 수 있음
// 클래스 헤더의 일부
class Person constructor(firstName: String) {}

// 아래와 같이 어노테이션이나 접근 지정자가 없을 때에는 constructor 키워드 생략 가능
class Person2(firstName:String){}


// 기본생성자는 코드를 가질 수 없다. 다만, 초기화는 초기화 블록 안에서 작성해야 한다.
class Customer(name:String){
    init{
        println("Customer initialized with value ${name}")
    }
}
class Customer2 constructor(){}

class PersonWithFunction(name: String) {
    // println("이름 : ${name}")
    // 클래스의 body에 함수를 사용할 수 없다.
    init {
        println("이름 : $name")
        // 프로퍼티 = name
    }

}

class CustomerWithProperty(){
    var fullname: String = ""
}
//아래처럼 파라미터가 아니라, 프로퍼티를 넣어 기본생성자에서 간결한 구문으로 사용이 가능하다.
class CustomerWithSimpleProperty(var fullname: String){

}

// Dependency Injection 및, public과 같은 접근지정자가 있는 경우 constructor를 반드시 표시해야함.
//class CustomerWithAccessModifier public @Inject constructor(name:String){
//
//}

// 보조 생성자
// 클래스 별로 여러개를 가질 수 있다.
// 이 때, 보조생성자는 반드시 기본성생자를 사용해야함.
class PersonWithSecondaryConstructor(val name: String){
    constructor(name:String, parent:Person) : this(name){

    }
    // 보조생성자를 다시 부름. 불린 보조생성자는 다시 기본생성자를 부르므로 문제 없음.
    constructor(): this("홍길동",Person("Goat")){}
}

// 생성된 기본 생성자
// 클래스에 기본 생성자 or 보조 생성자를 선언하지 않으면 생성된 기본 생성자가 만들어진다.
// 만약에 생성된 기본 생성자의 Access Modifier가 public이 아니어야 한다면 다음처럼 빈 기본 생성자를 선언해야 한다.
class DontCreateMe private constructor(){}


fun main() {
    //빈 생성자
    val obj = Customer2()
    println(obj)

    val obj2 = Person("GOAT")
    println(obj2)

    val obj3 = PersonWithFunction("GOAT") // 이름 : GOAT 출력됨

    val obj4 = CustomerWithProperty()
    obj4.fullname = "Goat Hoon"
    println(obj4.fullname)

    val obj5 = CustomerWithSimpleProperty("Goat Hoon")
    println(obj5.fullname)

}
