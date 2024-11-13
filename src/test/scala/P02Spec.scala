import pp202402.practice.P02.{last}
import pp202402.practice.{IList}

class P02Spec extends munit.FunSuite {

  import IList.*

  test("last of an empty list should return 0") {
    assert(last(INil) == 0)
  }

  test("last of a single-element list should return 0") {
    assert(last(IElement(5, INil)) == 0)
  }

  test("last of a two-element list should return the first element") {
    assert(last(IElement(1, IElement(8, INil))) == 1)
  }

  test("last of a three-element list should return the second element") {
    val lst = IElement(1, IElement(2, IElement(3, INil)))
    assert(last(lst) == 2)
  }

  test("last of a multi-element list should return the second last element") {
    val lst = IElement(10, IElement(20, IElement(30, IElement(40, INil))))
    assert(last(lst) == 30)
  }

  test("last of a list with negative numbers") {
    val lst = IElement(-10, IElement(-20, INil))
    assert(last(lst) == -10)
  }

  test("last of a list with repeated elements") {
    val lst = IElement(5, IElement(5, IElement(5, INil)))
    assert(last(lst) == 5)
  }

  test("last of a longer list") {
    val lst = IElement(3, IElement(1, IElement(4, IElement(1, IElement(5, IElement(9, INil))))))
    assert(last(lst) == 5)
  }

  test("last of a list with zeros") {
    val lst = IElement(0, IElement(0, IElement(0, INil)))
    assert(last(lst) == 0)
  }

  test("last of a list with maximum Int values") {
    val lst = IElement(Int.MaxValue, IElement(Int.MaxValue, INil))
    assert(last(lst) == Int.MaxValue)
  }
  
}

