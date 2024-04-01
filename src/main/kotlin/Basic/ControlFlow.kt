package Basic

class ExIterator{
    val ex:Array<String> = Array(5,{i->i.toString()})
    var idx = 0
    operator fun hasNext(): Boolean{
        return ex.size > idx
    }
    operator fun next():String{
        return ex[idx++]
    }
}

class ExData{
    operator fun iterator():ExIterator{
        return ExIterator()
    }
}
fun main(){
    // iterator()메서드와 특징을 가진 함수를 가진 객체는 아래와 같은 for문 작성 가능
    val exData = ExData()
    for(s in exData){
        print(s)
    }
}