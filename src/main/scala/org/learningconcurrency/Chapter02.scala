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

  /**
   * Task 2:
   *
   * Implement a `periodically` method, which takes a time interval `duration`
   * specified in milliseconds, and a computation block `b`. The method starts a thread that
   * executes the computation block `b` every `duration` milliseconds.
   * It should have the following signature:
   * {{{
   * def periodically(duration: Long)(b: =>Unit): Unit
   * }}}
   */
  def periodically(duration: Long)(b: => Unit): Unit = {
    thread {
      while (true) {
        synchronized {
          wait(duration)
        }

        b
      }
    }
  }

  /**
   * Task 3:
   *
   * Implement a `SyncVar` class with the following interface:
   * {{{
   * class SyncVar[T] {
   *   def get(): T = ???
   *   def put(x: T): Unit = ???
   * }
   * }}}
   * A `SyncVar` object is used to exchange values between two or more threads.
   * When created, the `SyncVar` object is empty:
   *   * Calling `get` throws an exception
   *   * Calling `put` adds a value to the `SyncVar` object
   * After a value is added to a `SyncVar` object, we can say that it is non-empty:
   *   * Calling `get` returns the current value, and changes the state to empty
   *   * Calling `put` throws an exception
   */
  class SyncVar[T] {

    private var data: Option[T] = None

    def get(): T = synchronized {
      if (data.isEmpty) {
        throw new IllegalStateException("SyncVar is empty")
      }

      val value = data.get
      data = None
      value
    }

    def put(x: T): Unit = synchronized {
      if (data.nonEmpty) {
        throw new IllegalStateException("SyncVar is non-empty")
      }
      
      data = Some(x)
    }
  }
}
