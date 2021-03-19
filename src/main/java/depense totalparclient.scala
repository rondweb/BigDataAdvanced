import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

/** Calculez le montant total dépensé par client. */
object depenseTotalParClient {
  
  /** Convertir les données d'entrée en tuples(customerID, amountSpent) */
  def extractCustomerPricePairs(line: String) = {
    var fields = line.split(",")
    (fields(0).toInt, fields(2).toFloat)
  }
 
  /** Méthode principale */
  def main(args: Array[String]) {
   
    // Définir le niveau de journalisation pour n'imprimer que les erreurs
    Logger.getLogger("org").setLevel(Level.ERROR)
    
     // Créez un SparkContext en utilisant chaque cœur de la machine locale
    val sc = new SparkContext("local[*]", "depenseTotalParClient")   
    
    val input = sc.textFile("customer-orders.csv")

    val mappedInput = input.map(extractCustomerPricePairs)
    
    val totalByCustomer = mappedInput.reduceByKey( (x,y) => x + y )
    
    val flipped = totalByCustomer.map( x => (x._2, x._1) )
    
    val totalByCustomerSorted = flipped.sortByKey()
    
    val results = totalByCustomerSorted.collect()
    
    //Afficher les résultats.
    results.foreach(println)
  }
  
}

