package example

/**
  * Created by bsbuon on 19/02/2016.
  */
object Parentheses {


  def balance(chars: List[Char]): Boolean = {

    def getResponse(none: Int): Boolean = {
      if (none == 0) true else false
    }

    def contains(chars: List[Char], none: Int): Boolean = {
      if(chars.isEmpty) getResponse(none) else
      if(chars.head.equals('(')) contains(chars.tail, none - 1) else
      if(chars.head.equals(')')) contains(chars.tail, none + 1) else
      contains(chars.tail, none)
    }

    contains(chars, 0)
  }
}
