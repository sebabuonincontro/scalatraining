val f = new Function[Int, Int] {
  override def apply(v1: Int): Int = v1 * v1
}

f.apply(4)


//---------------------------------------------------
def assertAllPos[S <: Int](r:S) : S = {

}
