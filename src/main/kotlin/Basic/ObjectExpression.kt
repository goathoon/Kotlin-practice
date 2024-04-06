package Basic

// 그냥 클래스를 사용시 다음과 같은 수고스러움이 존재

//class MyRunnableThread : Runnable{
//    override fun run() {
//        println("Not yet implemented")
//    }
//
//}
//fun main() {
//    val t: Thread = Thread(MyRunnableThread())
//    t.run()
//}

//아래처럼 익명 객체처럼 사용할 수 있음.
fun main(){
    val t = Thread(object: Runnable{
        override fun run(){
            println("Not Yet implemented")
        }
    })
    t.run()

    MyClass().print()

    // object 로 static 클래스처럼 사용이 가능
    CountManager.count++;
    println(CountManager.count)
}


// 객체 표현식의 제약 조건
class MyClass {
    fun publicFun() = object{
        var x:Int = 111
    }
    private fun privateFun() = object{
        var x:Int = 222
    }

    fun print(){
//        println("public = ${publicFun().x}") // 불가
        println("private = ${privateFun().x}")
    }

}


// 객체 선언 -> SingleTon 객체 생성 가능
object CountManager {
    var count = 0
}
