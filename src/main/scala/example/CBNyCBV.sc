val bla = 2.+(2)

val q = 1
val b = 2

val c = 1.+(b)

//Call by Name vs Call by Value

def something() ={
  println("Ejecutó ")
  1
}

def callByValue(x : Int) ={
  println("x1=" + x)
  println("x2=" + x)
}

def callByName(x : => Int) = {
  println("x1=" + x)
  println("x2=" + x)
}

callByValue(something())
callByName(something())




