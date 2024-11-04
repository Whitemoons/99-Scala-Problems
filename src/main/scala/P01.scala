package pp202402.practice

/*
P01 (easy)

Find the last element of a list.
If list is empty, return 0.

Example:

    scala> last(IList(1, IList(8, INil)))
    res0: Int = 8

    scala> last(INil)
    res1: Int = 0

*/

import scala.annotation.tailrec
import scala.util.control.TailCalls._

object P01 {
  import IList.*

  def last(head: IList[Int]): Int = {
    @tailrec
    def lastRec(listRec: IList[Int], res: Int): Int = listRec match {
      case IElement(a, tail) => lastRec(tail, a)
      case INil => res
    }

    lastRec(head, 0)
  }
}
