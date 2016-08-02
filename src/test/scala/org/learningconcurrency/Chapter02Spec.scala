package org.learningconcurrency

import org.learningconcurrency.Chapter02._
import org.scalatest.{FlatSpec, Matchers}

class Chapter02Spec extends FlatSpec with Matchers {

  "parallel" should "concurrently computes two blocks and return results in a tuple" in {
    //given
    def blockA = 2 * 2
    def blockB = "2" * 2

    //when
    val result: (Int, String) = parallel(blockA, blockB)

    //then
    result._1 shouldBe 4
    result._2 shouldBe "22"
  }
}
