import java.util.Scanner

object VariablesAndStrings extends App {
  //declaring a variable muttable
  var langage: String = "Bienvenue à Scala"
  println(langage)

  //declaring a constant
  val langage2: String = "Bienvenue à Scala"
  println(langage2)

  //declaring multiple variables
  var x, y = 0
  var python, java = false
  println(x, y, python, java)

  //declaring a method in scala
  def min(a: Int, b: Int):Int={
    if (a<b)
      return a
    else
      return b
  }
  var resultat = min(14, 15)
  print(resultat)

  //renverser une chaine
  val chaineEnvers = "Scala bienvenue".reverse
  println(chaineEnvers)

  //mettre la premiere lettre en MAJ
  val maj = "scala bienvenue".capitalize
  println(maj)

  //repeter une chaine plusieurs fois
  val multi = "Scala!" * 6 //repeter 6 fois
  println(multi)

  //parse d'une chaine en Int
  val int = "12345".toInt //parse comme int Int
  println(int)

  //scanning the values
  val scanner = new Scanner(System.in)
  val line = scanner.nextLine()

  println(line)
}
