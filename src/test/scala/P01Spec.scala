import pp202402.practice.P01.{last}
import pp202402.practice.{IList}

class P01Spec extends munit.FunSuite {

  import IList.*

  test("last of a non-empty list with multiple elements") {
    val list = IElement(1, IElement(8, INil))
    assertEquals(last(list), 8)
  }

  test("last of a single-element list") {
    val list = IElement(42, INil)
    assertEquals(last(list), 42)
  }

  test("last of an empty list") {
    val list: IList[Int] = INil
    assertEquals(last(list), 0)
  }

  test("last of a longer list") {
    val list = IElement(5, IElement(10, IElement(15, IElement(20, INil))))
    assertEquals(last(list), 20)
  }

  test("last of a list with negative numbers") {
    val list = IElement(-3, IElement(0, IElement(7, INil)))
    assertEquals(last(list), 7)
  }

  test("last of a list with duplicate elements") {
    val list = IElement(2, IElement(2, IElement(2, INil)))
    assertEquals(last(list), 2)
  }

  test("last of a list with different data types") {
    // Since P01.last is defined for IList[Int], we need to ensure type consistency.
    // This test is to confirm behavior, but in practice, Scala's type system will prevent misuse.
    val list = IElement(100, IElement(200, IElement(300, INil)))
    assertEquals(last(list), 300)
  }
}

