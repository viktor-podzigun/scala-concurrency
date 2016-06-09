package org.learningconcurrency

object Chapter01 {

  /**
   * Task 1:
   *
   * Implement a `compose` method with the following signature:
   * {{{
   * def compose[A, B, C](g: B => C, f: A => B): A => C = ???
   * }}}
   * This method must return a function `h`, which is the composition of the functions `f` and `g`.
   */
  def compose[A, B, C](g: B => C, f: A => B): A => C = a => g(f(a))

  /**
   * Task 2:
   *
   * Implement a `fuse` method with the following signature:
   * {{{
   * def fuse[A, B](a: Option[A], b: Option[B]): Option[(A, B)] = ???
   * }}}
   * The resulting `Option` object should contain a tuple of values from the `Option` objects
   * `a` and `b`, given that both `a` and `b` are non-empty. Use for-comprehensions.
   */
  def fuse[A, B](a: Option[A], b: Option[B]): Option[(A, B)] = {
    for (a <- a; b <- b) {
      return Some((a, b))
    }

    None
  }

  /**
   * Task 3:
   *
   * Implement a `check` method, which takes a set of values of the type `T` and a function
   * of the type `T => Boolean`:
   * {{{
   * def check[T](xs: Seq[T])(pred: T => Boolean): Boolean = ???
   * }}}
   * The method must `return true` if and only if the `pred` function returns `true` for all
   * the values in `xs` without throwing an exception. Use the check method as follows:
   * {{{
   * check(0 until 10)(40 / _ > 0)
   * }}}
   */
  def check[T](xs: Seq[T])(pred: T => Boolean): Boolean = {
    for (x <- xs) {
      try {
        if (!pred(x)) {
          return false
        }
      }
      catch {
        case _: Exception => return false
      }
    }

    true
  }
}
