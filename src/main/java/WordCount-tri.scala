import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

/** Compter le nombre d'occurence de chaque mot dans un livre, en utilisant des expressions régulières et en triant les résultats finaux. */
object WordCountBetterSorted {
 
  /** Méthode principale */
  def main(args: Array[String]) {
   
    // Définir le niveau de journalisation pour n'imprimer que les erreurs
    Logger.getLogger("org").setLevel(Level.ERROR)
    
     // Créez un SparkContext en utilisant chaque cœur de la machine locale
    val sc = new SparkContext("local", "WordCountBetterSorted")   
    
    // Charge chaque ligne de livre dans un RDD
    val input = sc.textFile("book.txt")
    
    // Split using a regular expression that extracts words
    val words = input.flatMap(x => x.split("\\W+"))
    
    // Normalize everything to lowercase
    val lowercaseWords = words.map(x => x.toLowerCase())
    
    // Count of the occurrences of each word
    val wordCounts = lowercaseWords.map(x => (x, 1)).reduceByKey( (x,y) => x + y )
    
    // Flip (word, count) tuples to (count, word) and then sort by key (the counts)
    val wordCountsSorted = wordCounts.map( x => (x._2, x._1) ).sortByKey()
    
    // Print the results, flipping the (count, word) results to word: count as we go.
    for (result <- wordCountsSorted) {
      val count = result._1
      val word = result._2
      println(s"$word: $count")
    }
    
  }
  
}

