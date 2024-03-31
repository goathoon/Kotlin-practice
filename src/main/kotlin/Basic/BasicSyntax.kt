fun printKotlin():Unit{
    println("here")
}
fun printKotlin(s:String){
    println(s + " here")
}

fun parseInt(str:String): Int?{
    if(str == "3"){
        return 3;
    }
    return null;
}

fun autoCastingFun(obj:Any): Int?{
    if(obj is String){
        return obj.length;
    }
    return null;
}
fun main() {
    printKotlin();
    printKotlin("parameter")

    // final == val
    val finalVal: Int = 1;
    // Infer 가능
    val nonInferredFinalVal = 1;
    val c:Int
    c = 3;
//    c = 4; -> Val Cannot Be ReAssigned
    println(c);

    // var == mutable 변수
    var x:Int = 3
    x = 4;
    println(4);

    parseInt("null")

    // null 표
    val nullableX: Int? = parseInt("3")
    val nullableY: Int? = parseInt("4")

    if(nullableY == null && nullableX == null){
        println("both are null")
    }else{
        println("$nullableX is not null")
    }


    // instanceof 메서드 처럼 작용하는 'is'
    println(autoCastingFun("four"))
    println(autoCastingFun(4))


    val items = setOf("apple");
    for(i in items){
        println(i)
    }

}