// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

// http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.knoldus

class Queue[+A](list:List[A]) {
  override def toString: String = list.toString

  //function to add element into the Queue
  def enqueue[B >: A](element:B): Queue[B] = new Queue[B](list :+ element)

  //function to remove front element from the queue
  def dequeue[B >: A]: Queue[B] = {
    if(list.nonEmpty) {
       new Queue[B](list.tail)
    } else {
      throw new NoSuchElementException
    }
  }

  //function to find front element in the queue
  def front: A =
    if (list.isEmpty) {
      throw new NoSuchElementException
    }
    else {
      list.head
    }

  //function to check queue is empty or not
  def isEmpty: Boolean = list.isEmpty

}
