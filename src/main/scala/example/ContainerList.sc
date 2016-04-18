case object Empty extends Container[Nothing]
case class Cons[+A](h: A, t: Container[A]) extends Container[A]

object Container{
  def apply[A](xs: A*): Container[A] =
    if(xs.isEmpty) empty else cons(xs.head, apply(xs.tail: _*))
  def empty[A] = Empty
  def cons[A](h: A, t: Container[A]) = Cons(h,t)
}

trait Container[+A] {
  def map[B](f: A => B): Container[B] = this match {
    case Empty => Empty
    case Cons(head, tail) => Cons(f(head), tail.map(f))
  }

  def headOption: Option[A] = this match {
    case Empty => None
    case Cons(head, _) => Some(head)
  }

  def @>[A](other: Container[A]) : Container[A] = this match {
    case Empty => other
    case Cons(h: A, t: Container[A]) => Cons(h, this.tail.@>(other))
  }

  def tail: Container[A] = this match {
    case Empty => Empty
    case Cons(_, t) => t
  }

  def ++[A](xs: A*): Container[A] = this match {
    case Empty => Cons(xs.head, Container.apply(xs.tail: _*))
    case Cons(h, t) => this.@>(Container.apply(xs: _*))
  }

  def size: Long = this match {
    case Empty => 0
    case Cons(_, t: Container[A]) => 1 + t.size
  }

  def take(n: Long): Container[A] = this match {
    case Empty => Empty
    case Cons(h: A, t: Container[A]) => if (n == 0) Empty else Cons(h, t.take(n-1))
  }

  def drop(n: => Long): Container[A] = this match {
    case Empty => Empty
    case Cons(h:A, t:Container[A]) if (n < 0 ) =>  Cons(h, t.drop(n-1))
    case Cons(_, t:Container[A]) if (n >= 0 ) => t.tail
  }

  def flatMap[B](f: A => B): Container[B] = ???
}

val strPlusB = (x: String) => x + "B"
Container("1","2") map strPlusB
Container(42,42) @> Container(43)
Container().headOption
Container(42) ++ 43
Container(999)
Container().size
Container(41,42,43) take 2

Container(41,42,43,44,45,46,47) drop 2
