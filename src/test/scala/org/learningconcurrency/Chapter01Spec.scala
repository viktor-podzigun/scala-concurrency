package org.learningconcurrency

import Chapter01._
import org.scalatest.{Matchers, FlatSpec}

class Chapter01Spec extends FlatSpec with Matchers {

  "compose" should "return a function, which is the composition of functions f and g" in {
    //given
    val f: String => Int = a => a.toInt
    val g: Int => Double = b => b.toDouble

    //when
    val h: String => Double = compose(g, f)

    //then
    h("0") shouldBe 0.0
    h("1") shouldBe 1.0
    h("2") shouldBe 2.0
  }

  "fuse" should "return composed Option object from two Option objects" in {
    //when & then
    fuse(None, None) shouldBe None
    fuse(Some("a"), None) shouldBe None
    fuse(None, Some("b")) shouldBe None
    fuse(Some("a"), Some(1)) shouldBe Some(("a", 1))
  }

  "check" should "return true if predicate function returns true for all the values" in {
    //when & then
    check(0 until 10)(40 / _ > 0) shouldBe false
    check(1 until 10)(40 / _ > 0) shouldBe true
    check(1 until 10)(40 / _ > 5) shouldBe false
    // empty collection
    check(List[Int]())(40 / _ > 5) shouldBe true
  }

  "Pair" should "be used in pattern match" in {
    //given
    val pair = Pair(123, "abc")

    //when
    val result: (Int, String) = pair match {
      case Pair(first, second) => (first, second)
    }

    //then
    result shouldBe Tuple2(123, "abc")
  }

  "permutations" should "return lexicographic permutations of the given string" in {
    //given
    val s = "BAC"

    //when
    val result: Seq[String] = permutations(s)

    //then
    result shouldBe List("ABC", "ACB", "BAC", "BCA", "CAB", "CBA")
  }
}
