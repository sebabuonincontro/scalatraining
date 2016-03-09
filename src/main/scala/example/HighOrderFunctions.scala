package example

/**
  * Created by bsbuon on 22/02/2016.
  */
object HighOrderFunctions {

  def sum (f: Int => Int, a: Int , b: Int) : Int = {
    if(a > b) 0
    else f(a) + sum(f, a, b)
  }

  def factorial (x: Int) : Int = {
    if(x == 0) 1 else factorial(x - 1)
  }
}
