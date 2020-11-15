package diwo

object Combinatorics {

  /**
   * Combinatorics and math stuff:
   * {{{
   *               n!
   * C(n, k) = -----------
   *           k! * (n-k)!
   *
   * C(10,5) = 252
   * C(5,2) = 10
   * }}}
   * total up to 252 * 10 = 2520
   */

  def fact(n: Int) = (1 to n).product

  def nUntilK(n: Int, k: Int) = ((k + 1) to n).product

  def binomialC(n: Int, k: Int): Int = {
    assert(!(n < 0 || k < 0 || n < k), "Wrong input")
    nUntilK(n, k) / fact(n - k)
  }

  private def tails[A](la: Seq[A])(f: Seq[A] => Seq[Seq[A]]): Seq[Seq[A]] = la match {
    case Nil => Seq.empty
    case _ :: t => f(la) ++ tails(t)(f)
  }

  /** generic combinations */
  def allCombN[A](n: Int, as: Seq[A]): Seq[Seq[A]] = n match {
    case 0 => Seq(Seq.empty)
    case _ => tails(as) { case h :: t => allCombN(n - 1, t).map(h +: _) }
  }

}
