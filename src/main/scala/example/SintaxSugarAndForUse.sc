import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.util.{Failure, Success}

def func1(x: Int): Future[Int] = Future.successful(42)
def func2(y: Int): Future[Int] = Future.successful(42)

def func3(z: Int): Future[Int] = Future.successful(42)

val q = for {
  f1 <- func1(1)
  f2 <- func2(f1)
  f3 <- func3(f2)
} yield (f1)

//val a = q.value.get
//a match {
//  case Success(v) => println(v)
//  case Failure(ex) => println(ex)
//}
val qu = func1(1).flatMap{ x => func2(x).flatMap(z => func3(z))}
Await.result(qu, 0 nanos)