abstract class IntSet{
  def contains(x: Int) : Boolean
  def incl(x: Int) : IntSet
  def union(x:IntSet) : IntSet
  def delete(x: Int) : IntSet
}

object Empty extends IntSet {
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString() = "."
  def union(x: IntSet) : IntSet = x
  def delete(x:Int) : IntSet = this
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  override def contains(x: Int): Boolean = {
    if(x < elem) left contains x
    else if(x > elem) right contains x
    else true
  }

  override def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }

  override def toString() = "{" + left + elem + right + "}"

  override def union(x: IntSet): IntSet = {
    ((left union right) union x) incl elem
  }

  override def delete(x:Int): IntSet = {
    if(left contains(x)) new NonEmpty( elem, Empty, right)
    else if (right contains x ) new NonEmpty (elem, left, Empty)
    else this
  }
}

val t1 = new NonEmpty(10,Empty,Empty)
t1 incl 9
t1 incl 11 incl 8
val t2 = new NonEmpty(50, Empty, Empty)
t1 union t2
val t3 = new NonEmpty(5, Empty, Empty)
t3 union t1
t1 incl 11 incl 8 delete 11