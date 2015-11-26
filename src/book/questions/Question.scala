package book.questions

import book.entries.BookEntry

trait Question {
  def input(entry: BookEntry): Unit
  def answer: String
}



