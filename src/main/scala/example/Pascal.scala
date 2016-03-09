package example

/**
  * Created by bsbuon on 18/02/2016.
  */
object Pascal {

  def getValueFor(col: Int, row: => Int) : Int = {

    def spot(col:Int, row: Int): Int = {
      getValueFor(col -1, row -1) + getValueFor(col, row -1)
    }

    def isOutside: Boolean = {
      col < 0 || col >= row + 1 || row < 0
    }

    def isEdge: Boolean = {
      row == 0 || col == 0 || col == row
    }

    if(isEdge) 1 else
    if(isOutside) 0 else
      spot(col, row)
  }

}
