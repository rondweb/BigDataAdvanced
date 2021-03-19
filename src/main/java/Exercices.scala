object Exercices extends App {
  /*Exercice 1
  ==========
  Soit la liste suivante*/
  val listing = List(15, 39, 22, 98, 37, 19, 5)


  // Développer le code qui effectue la somme des éléments de la collection et le refaire en fonctionnel

  //solution classique:
  val listing2 = List(15, 39, 22, 98, 37, 19, 5)
  var sum = 0

  for (t <- listing2)
    sum += t
  println(sum)

  //Solution fonctionnelle 1:
  val listing3 = List(15, 39, 22, 98, 37, 19, 5)
  var sum2 = 0

  listing3.foreach(x=> sum2 += x)
  println(sum2)

  //solution fonctionnelle 2:
  val listing4 = List(15, 39, 22, 98, 37, 19, 5)
  var sum3 = 0

  listing4.foreach(sum3 += _)
  println(sum3)

  /* Exercice 2
  =========
  count, Exists, forall

  ON veut parcourir une collection afin de  determiner quelques propriétés telles que:

    Est ce que la collection contient un un element avec une certaine propriété?
      Est ce que tous les elements ont cette propriété?
      Combien d'elements ont cette propriété?
  Sol: Higher-order methodes exists, forall, et count.
  CEs méthodes demande des fonction object qui maps les elements vers Boolean.

  Sol:*/
  val coll = List("Introduction à la Programmation",
    "Pratique de la Programmation",
    "Structure de données",
    "Principe de la Programmation",
    "Algorithmie",
    "Langages de Programmation")

  //1. Combien d'éléments contiennent le mot "Programmation"
  print(coll.count(x => x contains "Programmation"))
  print(coll.count(_ contains "Programmation"))

  //2. Combien d'éléments ne contiennent pas le mot "Programmation"
  print(coll.count(x => !(x contains "Programmation")))

  //4. forall says: return true if for every x in the collection, p(x) is true.
  print(coll.forall(  (_ contains "Programmation")))
  //Boolean = false  parceque Algorithmie et structure ne contiennent pas -Programmation-

  print(coll.forall(  (x => x.toUpperCase contains "O")))
  print(coll.forall(  (_.toUpperCase contains "O")))
  //Boolean = true

  //3. exists exists says that returns true if there is at least one element x in the collection such that p(x) is true
  print(coll.exists(  (x => !(x contains "Programmation"))))
  //Boolean = true

  //5.
  print(coll.exists(  (_ contains "Programmation")))
  //Boolean = true
}
