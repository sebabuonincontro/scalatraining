/**
  * Created by bsbuon on 24/02/2016.
  */
trait User {
  def name : String
}
class FreeUser(val name: String) extends User;
class PremiumUser(val name: String) extends User;
