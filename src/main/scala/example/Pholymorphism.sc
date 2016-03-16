
def nth[T](i:Int, list:List[T]):T = {
  def loop(i:Int, list:List[T], acum:Int):T = {
    if(i-1 == acum) list.head
    else loop(i,list.tail,acum +1)
  }
  if(i>list.length) throw new IndexOutOfBoundsException()
  else loop(i,list,0)
}


var list = List(1,2,3,4)

nth(5,List("hola","como","estas"))