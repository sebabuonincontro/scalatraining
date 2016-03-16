trait Point{
  def height: Int
  def width: Int
}


trait Planar extends Point{
  def surface = height * width
}

class Square(val height:Int,val width:Int) extends Planar{
  require(height>0, "height be non negative")
}

val a = new Square(1,2) surface

val b = new Square(0,2) surface

