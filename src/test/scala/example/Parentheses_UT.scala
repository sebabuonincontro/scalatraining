package example

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Created by bsbuon on 19/02/2016.
  */
@RunWith(classOf[JUnitRunner])
class Parentheses_UT extends FunSuite{

  test("is Balance"){
    assert(Parentheses.balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("is Balance 2"){
    assert(Parentheses.balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
  }

  test("is not balance"){
    assert(!Parentheses.balance(":-)".toList))
  }

  test("is not balance 2"){

  }

}
