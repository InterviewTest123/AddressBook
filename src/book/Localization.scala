package book

import java.text.{ DateFormat, SimpleDateFormat }


object Localization {
  val separator = ", "
  val maleString = "Male"
  val femaleString = "Female"
  val dateFormat: DateFormat = new SimpleDateFormat("dd/MM/yy")
}
