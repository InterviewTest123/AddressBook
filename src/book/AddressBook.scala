package book

import book.entries.BookEntry
import book.questions._

import scala.io.Source

object AddressBook {
  val questions = List(new Question1(), new Question2, new Question3)

  def main(args: Array[String]): Unit = {
    val inputFileUrl = AddressBook.getClass.getResource("AddressBook")
    assert(inputFileUrl != null)

    val input = Source.fromURL(inputFileUrl).getLines()
    val entries = input.map(parseInputLine)


    entries.foreach(e => questions.foreach(_.input(e)))

    questions.foreach(q=> println(q.answer))
  }

  def parseInputLine(line: String) = {
    val entries = line.split(Localization.separator)
    assert(entries.length == 3, "Invalid entry format: expected 3 entries per line.")
    val surnamePosition = entries(0).lastIndexOf(' ')
    assert(surnamePosition != -1, "Invalid entry format: expected space separated name(s) followed by a surname.")
    val (name, surname) = entries(0).splitAt(surnamePosition)
    val sex = entries(1)
    val dob = Localization.dateFormat.parse(entries(2))

    BookEntry(name, surname.trim, sex, dob)
  }
}
