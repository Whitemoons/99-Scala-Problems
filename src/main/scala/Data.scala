package pp202402.practice

// Binary Search Tree
enum BST[+K, +V]:
  case Leaf
  case Node(key: K, value: V, left: BST[K, V], right: BST[K, V])

enum IOption[+A]:
  case ISome(a: A)
  case INone

  def isSome: Boolean = this match
    case ISome(_) => true
    case _        => false

  def isNone: Boolean = !isSome

enum IList[+A]:
  case IElement(a: A, next: IList[A])
  case INil