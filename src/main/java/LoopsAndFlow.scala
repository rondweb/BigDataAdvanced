object LoopsAndFlow extends App {
  if (true)
    println("pas de {} dans une expression simple")

  val aimeOeufs = false
  val plat =
    if (aimeOeufs) "oeuf au plat"
    else "oeuf brouillé"
  println(plat)

  //switch
  val option = "Un"
  option match {
    case "Un" => println("Selection Un!")
    case "Deux" => println("Selection option Deux!")
    case _ => println("Selection inconnue: ")
  }

  var i, sum = 0
  while ( i < 10) {
    sum += i
    i+=1
  }
  println(sum)

  //Loops for avec scala
  var sum2 = 0

  for ( i <- 0 until 10) {
    sum2+= i
  }
  println(sum2)

  //loops
  println((0 until 34).sum)
}
