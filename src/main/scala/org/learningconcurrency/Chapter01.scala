package org.learningconcurrency

object Chapter01 {

  /**
   * Task 1
   *
   * Implement a `compose` method with the following signature:
   * {{{
   * def compose[A, B, C](g: B => C, f: A => B): A => C = ???
   * }}}
   * This method must return a function `h`, which is the composition of the functions `f` and `g`.
   */
  def compose[A, B, C](g: B => C, f: A => B): A => C = a => g(f(a))
}
