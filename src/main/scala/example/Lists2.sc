def init[T](xs:List[T]):List[T] = xs match {
  case List() => throw new Exception("Empty List")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}

val a = List(1,2,3,4,5,6,7,8,9)

init(a)

def removeAt[T](n:Int,l:List[T]):List[T] =
  l.take(n) ::: (l drop n + 1)

removeAt(2,a)