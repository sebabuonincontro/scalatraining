var lista1 = "()()"

def isBalanced (x:String):Boolean = {
  def loop(xs : List[Char], acum: Int) : Int = {
    if(xs.isEmpty || acum < 0) acum
    else {
      xs.head match {
        case '(' => loop(xs.tail, acum + 1)
        case ')' => loop(xs.tail, acum - 1)
        case _ => loop(xs.tail, acum)
      }
    }
  }

  loop(x.toList, 0) == 0
}

isBalanced(lista1)
isBalanced(")()(")
isBalanced("(()))(")