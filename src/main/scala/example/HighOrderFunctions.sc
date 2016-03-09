def sum (a: Int , b: Int) : Int = {
  def loop (a: Int, acc: Int) :Int = {
    if(a > b) acc
    else loop(a + 1, a + acc )
  }

  loop(a, 0)
}

sum(1, 10)

def factorial (x: Int) : Int = {
  def fact(x: Int, acc: Int) : Int = {
    if(x == 0) acc
    else fact(x-1, acc + x)
  }
  fact(x, 0)
}

factorial(10)


def sumar(f: Int => Int)(fn:Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, f(a) + acc)
  }
  loop(a, 0)
}

sumar(factorial)(factorial)( 1, 10)