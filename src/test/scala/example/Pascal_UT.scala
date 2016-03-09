package example

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
  * Created by bsbuon on 18/02/2016.
  */
@RunWith(classOf[JUnitRunner])
class Pascal_UT extends FunSuite{
  /*
      1
     1 1
    1 2 1
   1 3 3 1
  1 4 6 4 1

  The numbers at the edge of the triangle are all 1,
  and each number inside the triangle is the sum of the two numbers above it.
  Write a function that computes the elements of Pascal’s triangle by means of a recursive process.

  Do this exercise by implementing the pascal function in Main.scala,
  which takes a column c and a row r, counting from 0 and returns the number at that spot in the triangle.
  For example, pascal(0,2)=1, pascal(1,2)=2 and pascal(1,3)=3.
   */

  test("pascal head"){
    assert(Pascal.getValueFor(0,0) == 1)
  }

  test("arista izquierda"){
    assert(Pascal.getValueFor(0,10) == 1)
  }

  test("arista derecha"){
    assert(Pascal.getValueFor(2,2) == 1)
  }

  test("triangle inside"){
    assert(Pascal.getValueFor(1,2) == 2)
    assert(Pascal.getValueFor(1,3) == 3)
  }
  test("outside of triangle"){
    assert(Pascal.getValueFor(10,8) == 0)
    assert(Pascal.getValueFor(-4,10) == 0)
  }
}
