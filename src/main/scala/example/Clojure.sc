//Closure
val x = 1
def sumOne ( y : Int) = {
  val x = 2
  x + y
}
sumOne(2) + 1
var j = 2

def multi(x : Int , y : Int) = {
  def single (j : Int) = {
    j + j
  }
  single(x) + single(y)
}
multi(2,3)