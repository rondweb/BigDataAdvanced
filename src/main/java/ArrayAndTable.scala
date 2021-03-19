object ArrayAndTable extends App{
  //Tab Mutable de type Array[Int]
  val array1 = Array(1, 2, 3, 4) //>array1 = [I@6ae01647
  println(array1)

  // Tab Mutable de type Array[Any]
  val array2 = Array("a", 2, true)
  println(array2)

  // Tab Mutable de type Array[String]
  val array3 = Array("a", "b", "c")

  println(array3) //>Array(a, b, c)

  //Acces items par (index) et [index] en partant de 0
  val itemAtIndex0 = array3(0) //>

  //Modification des items
  array3(0) = "d"
  println(array3)

  //Concatenation avec ++ operator,
  val concatenated = "prepend" +: (array1 ++ array2) :+ "append"
  println(concatenated)

  //Trouver l'index d'un item
  array3.indexOf("b")

  //list
  val liste = List("a", "b","c")
  println(liste(0))

  //slicing a list
  val liste2 = List("a", "b","c","f")
  println(liste2.slice(1,3))

  //iterating a list
  //#Parcours de list avec for
  var liste3 = List("a", "b")
  for (valeur <- liste3)
    println(valeur)

  //integrating with java
  var liste4 = new java.util.ArrayList[String]
  //ajout element
  liste4.add("Bienvenue")
  liste4.add("Scala")
  liste4 add "Monde" //notation infix

}
