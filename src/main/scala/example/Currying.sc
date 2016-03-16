def generalize(f:Int => Int , op:(Int, Int) => Int, zero: Int)(a: Int, b:Int) : Int = {

  def applyOp(a: Int, acc:Int): Int = {
    if(a > b) zero
    else op(f(a), applyOp(a + 1, acc))
  }

  applyOp(a, 0)
}

generalize(x => x ,(a,b) => a * b, 1)(1, 4)


def factorial(a: Int)(f:Int => Int): Int = {
    if(a == 0) 0
    else f(a) + factorial(a-1)(f)
}

factorial(3)

factorial(3)(x => x * x)


//-----------------------------------------
def add(x:Int)(y:Int) = x + y

add(1)(2)
add(2)(2)
add(1)(4)
add(1)(3)

def addOne(x:Int) = add(1)(x)

addOne(4)
