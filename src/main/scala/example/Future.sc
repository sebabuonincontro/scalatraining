import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration.Duration

val foa: Future[Option[Int]] = Future{Some(1)}
val fob: Future[Option[Int]] = Future{Some(2)}

val foc: Future[Option[Int]] = Future{Some(3)}
val fod: Future[Option[Int]] = Future{Some(4)}

val otherFuture = foc.flatMap{
  case None => Future{None}
  case Some(value) => {
    fod.flatMap{
      case Some(value2) => Future{value + value2}
      case None => Future{None}
    }
  }

Await.result(otherFuture, Duration.Inf)

val futureSeba =(for {
  f1 <- foa if f1.isDefined
  f2 <- fob if f2.isDefined
} yield {
  f1.get + f2.get
}).recover{
  case _ => None
}

Await.result(futureSeba, Duration.Inf)

//---------------------------------------------------
//Future 2

def decompose[T](fo1:Future[Option[T]],fo2:Future[Option[T]])(f:(T,T)=> T) = {
  fo1.flatMap{
    case None => Future{None}
    case Some(value) => {
      fo2.flatMap{
        case Some(value2) => Future{f(value, value2)}
        case None => Future{None}
      }
    }
  }
}

val fo1 = Future{Option{"a"}}
val fo2 = Future{Option{"b"}}
Await.result(decompose(fo1, fo2)((x1:String,x2:String) => x1 + "->" + x2), Duration.Inf)




