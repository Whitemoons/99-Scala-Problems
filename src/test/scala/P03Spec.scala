import pp202402.practice.P03.{nth}
import pp202402.practice.{IList}

class P03Spec extends munit.FunSuite {

  import IList.*

  // 헬퍼 함수: Scala의 List를 사용자 정의 IList로 변환
  def toIList(lst: List[Int]): IList[Int] = {
    lst.foldRight(INil: IList[Int])((a, acc) => IList.IElement(a, acc))
  }

  test("nth of an empty list should return 0") {
    val lst = INil
    assert(nth(0, lst) == 0)
    assert(nth(1, lst) == 0)
  }

  test("nth with negative index should return 0") {
    val lst = toIList(List(1, 2, 3))
    assert(nth(-1, lst) == 0)
    assert(nth(-5, lst) == 0)
  }

  test("nth of a single-element list") {
    val lst = IList.IElement(42, INil)
    assert(nth(0, lst) == 42)
    assert(nth(1, lst) == 0)
  }

  test("nth of a multi-element list") {
    val lst = toIList(List(10, 20, 30, 40, 50))
    assert(nth(0, lst) == 10)
    assert(nth(1, lst) == 20)
    assert(nth(2, lst) == 30)
    assert(nth(3, lst) == 40)
    assert(nth(4, lst) == 50)
    assert(nth(5, lst) == 0)
  }

  test("nth of a list with one element returns correct value and 0 for out of bounds") {
    val lst = IList.IElement(100, INil)
    assert(nth(0, lst) == 100)
    assert(nth(1, lst) == 0)
  }

  test("nth of a list with multiple elements and check specific indices") {
    val lst = toIList(List(5, 15, 25, 35, 45, 55))
    assert(nth(0, lst) == 5)
    assert(nth(2, lst) == 25)
    assert(nth(4, lst) == 45)
    assert(nth(5, lst) == 55)
    assert(nth(6, lst) == 0)
  }

  test("nth of a list with duplicate elements") {
    val lst = toIList(List(7, 7, 7, 7))
    assert(nth(0, lst) == 7)
    assert(nth(1, lst) == 7)
    assert(nth(2, lst) == 7)
    assert(nth(3, lst) == 7)
    assert(nth(4, lst) == 0)
  }

  test("nth of a longer list should return the correct element") {
    val lst = toIList((1 to 100).toList)
    assert(nth(0, lst) == 1)
    assert(nth(50, lst) == 51)
    assert(nth(99, lst) == 100)
    assert(nth(100, lst) == 0)
  }

  test("nth of a list with negative and positive numbers") {
    val lst = toIList(List(-10, -20, 0, 20, 10))
    assert(nth(0, lst) == -10)
    assert(nth(1, lst) == -20)
    assert(nth(2, lst) == 0)
    assert(nth(3, lst) == 20)
    assert(nth(4, lst) == 10)
    assert(nth(5, lst) == 0)
  }

  test("nth of a list with maximum Int values") {
    val lst = toIList(List(Int.MaxValue, Int.MinValue, 0))
    assert(nth(0, lst) == Int.MaxValue)
    assert(nth(1, lst) == Int.MinValue)
    assert(nth(2, lst) == 0)
  }
  
}

