package pp202402.practice

/* 
P03 (easy)

Find the Kth element of a list. By convention, the first element in the list is
element 0.

Example:

    scala> nth(2, List(1, 1, 2, 3, 5, 8))
    res0: Int = 2

*/

import scala.annotation.tailrec
import scala.util.control.TailCalls._

object P03 {
  import IList.*

  def nth(pos:Int, li:IList[Int]):Int = {
    @tailrec
    def nthRec(posRec:Int, liRec:IList[Int]): Int = liRec match {
      case IElement(a, _) if posRec == 0 => a
      case IElement(_, next) if posRec > 0 => nthRec(posRec-1, next)
      case _ => 0
    }

    if(pos < 0) 0 else nthRec(pos, li)
  }

}
