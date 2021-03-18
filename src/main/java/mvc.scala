//Application de base en Scala
/* Detail sur plusieurs lignes
 * 
 */

import java.util.Scanner

object mvc extends App {
  var classification = Array("Poids insuffisant",
    "Poids normal",
    "Excès de poids",
    "Obésité, classe I",
    "Obésité, classe II",
    "Obésité, classe III")

  var risque = Array("Accru",
    "Moindre",
    "Accru",
    "Élevé",
    "Très élevé",
    "Extrêmement élevé")

  val lecteur: Scanner = new Scanner(System.in)
  //saisie poids
  var msg = "S.V.P, saisir votre poids:"
  println(msg)
  val poids = lecteur.nextDouble()
  //saisie taille
  msg = "S.V.P, saisir votre taille:"
  println(msg)
  val taille = lecteur.nextDouble()
  //calcum IMC-BMI
  val imc = (poids) / (taille * taille)
  //affichage du BMI
  msg = "Votre IMC-BMI est:"
  println(msg + imc)
  //donner conseil
  var i = 0
  if (imc < 18.5) i = 0
  else if (imc < 25) i = 1
  else if (imc < 30) i = 2
  else if (imc < 35) i = 3
  else if (imc < 40) i = 4
  else i = 5
  println("Classification: " + classification(i) + "\nRisque: " + risque(i))
}