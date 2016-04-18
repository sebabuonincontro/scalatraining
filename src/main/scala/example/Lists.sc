
def sum(xs: List[Int]): Int = {
  if(xs.isEmpty) 0 else xs.head + sum(xs.tail)
}

def max(xs: List[Int]): Int = {
  def greater (x: Int, y: => Int): Int = {
    if(x > y) x else y
  }

  if(xs.isEmpty) 0 else greater(xs.head, max(xs.tail))
}

sum(List(1,2,3))

max(List(5,9,4,7))



