package org.learningconcurrency

object Chapter02 {

  /**
   * Task 1:
   *
   * Implement a `parallel` method, which takes two computation blocks `a` and `b`,
   * and starts each of them in a new thread. The method must return a tuple with
   * the result values of both the computations. It should have the following signature:
   * {{{
   * def parallel[A, B](a: =>A, b: =>B): (A, B)
   * }}}
   */
  def parallel[A, B](a: => A, b: => B): (A, B) = {
    @volatile var resultA: Option[A] = None
    @volatile var resultB: Option[B] = None

    val threadA = thread {
      resultA = Some(a)
    }
    val threadB = thread {
      resultB = Some(b)
    }

    threadA.join()
    threadB.join()

    (resultA.get, resultB.get)
  }
}
