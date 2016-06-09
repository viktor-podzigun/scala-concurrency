package org.learningconcurrency

import Chapter01._
import org.scalatest.{Matchers, FlatSpec}

class Chapter01Spec extends FlatSpec with Matchers {

  "compose" should "return a function, which is the composition of functions f and g" in {
    //given
    val f: String => Int = (a: String) => a.toInt
    val g: Int => Double = (b: Int) => b.toDouble

    //when
    val h: String => Double = compose(g, f)

    //then
    h("0") shouldBe 0.0
    h("1") shouldBe 1.0
    h("2") shouldBe 2.0
  }
}