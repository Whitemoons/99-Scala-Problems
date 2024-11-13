package pp202402.practice

/*
P02 (easy)

Find the last but one element of a list.

Example:

    scala> last(IList(1, IList(8, INil)))
    res0: Int = 1

    scala> last(INil)
    res1: Int = 0

*/

import scala.annotation.tailrec
import scala.util.control.TailCalls._

object P02 {
  import IList.*

  def last(li: IList[Int]):Int = {
    @tailrec
    def lastRec(res: Int, tmp: Int, li2: IList[Int]):Int = li2 match {
      case INil => res
      case IElement(a, next) => lastRec(tmp, a, next)
    }
    lastRec(0, 0, li)
  }

}
