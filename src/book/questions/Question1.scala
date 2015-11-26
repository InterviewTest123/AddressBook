package book.questions

import book.entries.{Male, BookEntry}

/**
  * How many males are in the address book?
  */
class Question1 extends Question {
  var numberOfMales = 0

  def input(entry: BookEntry): Unit = {
    entry match {
      case m: Male => numberOfMales += 1
      case _ =>
    }
  }

  def answer = s"Q1: Number of males equal to $numberOfMales"
}
