package example

import serial._

object Hello extends Greeting with App {
  println(greeting)
  val tree = new BinarySearchTree[Int]()
  println(tree insert 4 insert 3 insert 5)

}

trait Greeting {
  lazy val greeting: String = "hello"
}
