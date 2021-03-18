//Application de base en Scala
/* Detail sur plusieurs lignes
 *
 */

import java.util.Scanner
import java.util.InputMismatchException

object mvc2 extends App {

  def calcImcBmi(poids: Double, taille: Double): Double = {
    val bmi = (poids) / (taille * taille)
    return bmi
  }

  def saisieVal(msg: String, lecteur: Scanner): Double = {
    //  println(msg)
    var res = 0.0
    var flag = true
    while(flag){
      try{
        println(msg)
        res = lecteur.nextDouble()
        flag = false
      }catch{
        case ex: InputMismatchException => println("Valeur non conforme !")
          lecteur.nextLine()
      }
    }
    return res
  }

  def afficheResultat(msg: String, bmi: Double): Unit = {
    println(msg + bmi)
  }

  def donnerConseil(imc: Double, risque: Array[String], classification: Array[String]): Unit = {
    // println("Classification: " + classification(0) + "\nRisque: " + risque(0))

    var i = 0
    if (imc < 18.5) i = 0
    else if (imc < 25) i = 1
    else if (imc < 30) i = 2
    else if (imc < 35) i = 3
    else if (imc < 40) i = 4
    else i = 5
    println("Classification: " + classification(i) + "\nRisque: " + risque(i))

  }

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
  val poids = saisieVal(msg, lecteur)
  //saisie taille
  msg = "S.V.P, saisir votre taille:"
  val taille = saisieVal(msg, lecteur)
  //calcum IMC-BMI
  val bmi = calcImcBmi(poids, taille)
  //affichage du BMI
  msg = "Votre IMC-BMI est:"
  afficheResultat(msg, bmi)
  //donner conseil
  donnerConseil(bmi, risque, classification)

}
