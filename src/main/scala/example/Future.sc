import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.util.Success

val foa: Future[Option[Int]] = Future{Some(1)}
val fob: Future[Option[Int]] = Future{Some(2)}

def sumFuture(x: Future[Option[Int]], y: Future[Option[Int]]) : Int  = {
  def decompose(from: Future[Option[Int]]) : Int = {
    def a = from.onComplete{
      case Success(value) => Some(value)
    }
    a
  }

  decompose(x) + decompose(y)
}





