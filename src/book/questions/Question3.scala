package book.questions

import java.util.concurrent.TimeUnit

import book.entries.BookEntry

class Question3 extends Question {
  var bill: Option[BookEntry] = None
  var paul: Option[BookEntry] = None

  override def input(entry: BookEntry): Unit = {
    entry match {
      case BookEntry("Bill", _, _) => bill = Some(entry)
      case BookEntry("Paul", _, _) => paul = Some(entry)
      case _ =>
    }
  }

  override def answer: String = {
    (bill, paul) match {
      case (Some(b), Some(p)) => if (b.dateOfBirth.before(p.dateOfBirth)) {
        val diff = TimeUnit.DAYS.convert(p.dateOfBirth.getTime - b.dateOfBirth.getTime, TimeUnit.MILLISECONDS)
        s"Q3: Bill is ${diff} days older than Paul"
      } else "Q3: Bill is not older than Paul"
      case (None, Some(p)) => "Q3: Bill not found in the address book"
      case (Some(b), None) => "Q3: Paul not found in the address book"
      case _ => "Q3: Neither Bill nor Paul found in the address book"
    }
  }
}
