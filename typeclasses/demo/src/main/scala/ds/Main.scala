package ds

object Main {

  def sum(xs: List[Int]): Int = xs.foldLeft(0){_ + _}

  def p(a: Any) { println("###> " + a) }
  def main(args: Array[String]) {
    println
    p(sum(List(1,2,3)))
    println
  }
}