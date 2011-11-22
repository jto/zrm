package ds



object Main {

  trait Foldable[F[_]]{
    def foldLeft[A, B](xs: F[A], s: B,f: ((B, A) => B)): B
  }

  implicit object ListFoldable extends Foldable[List]{
    def foldLeft[A,B](xs: List[A], s:B ,f: ((B, A) => B)) = xs.foldLeft(s)(f)
  }

  trait Monoid[A]{
    def mappend(a:A, b:A):A
    def mzero: A
  }
  implicit object IntMonoid extends Monoid[Int]{
    def mappend(a:Int, b:Int) = a + b
    def mzero = 0
  }
  implicit object StringMonoid extends Monoid[String]{
    def mappend(a:String, b:String) = a + b
    def mzero = ""
  }

  def sum[F[_], A](xs: F[A])(implicit m: Monoid[A], f: Foldable[F]): A =
    f.foldLeft(xs, m.mzero, (a:A, b:A) => m.mappend(a,b))

  def p(a: Any) { println("###> " + a) }
  def main(args: Array[String]) {
    println
    p(sum(List(1,2,3)))
    p(sum(List("1","2","3")))
    println
  }
}