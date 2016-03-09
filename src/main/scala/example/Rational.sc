
class Rational(x:Int,y:Int){
  def numerador = x
  def denom = y

  def  neg = new Rational(-numerador, denom)

  override def toString() = numerador + "/" + denom
}


val x = new Rational(1,2)
x.denom
x.neg