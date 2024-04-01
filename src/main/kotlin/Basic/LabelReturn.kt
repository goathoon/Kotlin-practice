package Basic

fun main(){
    foo()
    println()
    foo_lambda() // 0만 찍힘
    println()
    fooImplicitLabel()
}

// foo()함수는 익명함수를 활용하여, return을 하면, 익명함수의 정의까지만, return이 되어 foo의 종료에 영향을 미치지 않음
fun foo(){
    var ints = listOf(1,2,3)
    ints.forEach(fun(value:Int){
        if(value == 1) return
        print(value)
    })
    print("END")
}


// foo_lambda()함수는 람다식을 사용함. 람다식에서 return이 되면, 전체 함수의 종료를 야기
fun foo_lambda(){
    var ints = listOf(0,1,2,3)
    ints.forEach({
        if(it==1) return
        print(it)
    })
    print("END")
}


// 암시적 레이블을 사용하여 return하기 (그냥 레이블 붙이기 귀찮아서 사용하면 요긴함)
fun fooImplicitLabel(){
    var ints = listOf(0,1,2,3)
    ints.forEach{
        if(it==1) return@forEach
        print(it)
    }
    print("END")
}