package book.entries

import java.util.Date

import book.Localization

trait BookEntry {
  def name: String
  def surname: String
  def dateOfBirth: Date
  def fullName = s"$name $surname"
}

object BookEntry {
  def apply(name: String, surname: String, sex: String, dateOfBirth: Date): BookEntry = {
    sex match {
      case Localization.maleString => Male(name, surname, dateOfBirth)
      case Localization.femaleString => Female(name, surname, dateOfBirth)
      case _ => throw new RuntimeException(s"Unknown 'sex' identifier encountered: $sex")
    }
  }

  def unapply(b: BookEntry): Option[(String, String, Date)] = Some((b.name, b.surname, b.dateOfBirth))
}

case class Male(name: String, surname: String, dateOfBirth: Date) extends BookEntry
case class Female(name: String, surname: String, dateOfBirth: Date) extends BookEntry
