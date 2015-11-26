package book.questions

import book.entries.BookEntry

class Question2 extends Question {
  var oldest: Option[BookEntry] = None

  override def input(entry: BookEntry): Unit = {
    oldest match {
      case None => oldest = Some(entry)
      case Some(o) => if (o.dateOfBirth.after(entry.dateOfBirth)) oldest = Some(entry)
    }
  }

  override def answer: String = {
    oldest match {
      case None => "Q2: Nobody is the oldest"
      case Some(o) => s"Q2: The oldest person is ${o.fullName}"
    }
  }
}
