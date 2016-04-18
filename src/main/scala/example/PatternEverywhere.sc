def foo():(String,String) ={
  ("Hola", "Chau")
}

val (first, second) = foo()
println(first + " " + second)

//-------------------------------------------

def gameResults(): Seq[(String, Int)] =
  ("Daniel", 3500) :: ("Melissa", 13000) :: ("John", 7000) :: ("Otro", 1 ) :: Nil

def hallOfFame = for {
  (name, score) <- gameResults() if (score > 5000)
} yield name

println(hallOfFame)


//--------------------------------------------
val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: Nil

val length = for {
  newlist <- lists flatMap (x => x)
} yield newlist

println(length)