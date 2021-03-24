package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class QueueTest extends AnyFlatSpec {

//TestCases on enqueue
  "Queue" should "return enqueued list" in {
    val queue = new Queue[String](List())
    val result = queue.enqueue("aravind").toString
    assert(result == "List(aravind)")
  }

  it should "return enqueued list of integers" in {
    val queue = new Queue[Int](List(1))
    val result = queue.enqueue(2).toString
    assert(result == "List(1, 2)")
  }

  it should "return enqueued list of string" in {
    val queue = new Queue[String](List("aravind", "kumar"))
    val result = queue.enqueue("kaspe").toString
    assert(result == "List(aravind, kumar, kaspe)")
  }

  //Negative TestCase
  it should "fail as assertion is wrong for enqueue" in {
    val queue = new Queue[Int](List(9, 10))
    val result = queue.enqueue(11).toString
    assert(!(result == "List(11, 9, 10)"))
  }

  //TestCases on dequeue
  it should "return dequeued list of integers" in {
    val queue = new Queue[Int](List(1,2,3))
    val enqueued = queue.enqueue(4)
    val result = enqueued.dequeue.toString
    assert(result == "List(2, 3, 4)")
  }

  it should "return dequeued list of string" in {
    val queue = new Queue[String](List("aravind", "kaspe"))
    val enqueued = queue.enqueue("kumar")
    val result = enqueued.dequeue.toString
    assert(result == "List(kaspe, kumar)")
  }

  it should "return nothing" in {
    val queue = new Queue[String](List())
    assertThrows[NoSuchElementException] {
      queue.dequeue
    }
  }

  //Negtive TestCase
  it should "fail as assertion is false for dequeue" in {
    val queue = new Queue[Int](List(5, 6, 7, 8))
    val enqueued = queue.enqueue(9)
    val result = enqueued.dequeue.toString
    assert(!(result == "List(5, 6, 7, 8)"))
  }

  //TestCases on front
  it should "return front value of list of integers" in {
    val queue = new Queue[Int](List(1, 2, 3, 4))
    val result = queue.front
    assert(result == 1)
  }

  it should "return front value of list of string" in {
    val queue = new Queue[String](List("aravind", "kumar", "kaspe"))
    val result = queue.front
    assert(result == "aravind")
  }

  it should "return nothing as list is empty" in {
    val queue = new Queue[String](List())
    assertThrows[NoSuchElementException] {
      queue.front
    }
  }

  //Negative TestCase
  it should "fail as assertion is wrong" in {
    val queue = new Queue[String](List("aravind", "kumar", "kaspe"))
    val result = queue.front
    assert(!(result == "kaspe"))
  }

  //TestCases on IsEmpty
  it should "return the list is not empty" in {
    val queue = new Queue[String](List("aravind", "kumar", "kaspe"))
    val result = queue.isEmpty
    assert(result == false)
  }

  it should "return the list is empty" in {
    val queue = new Queue[String](List())
    val result = queue.isEmpty
    assert(result == true)
  }

}
