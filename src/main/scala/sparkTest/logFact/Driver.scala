package sparkTest.logFact
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
object NDriver {
  
  val conf: SparkConf = new SparkConf().setAppName("LogCheck").setMaster("local[2]")
  val sc: SparkContext = new SparkContext(conf)
  
  def getOrCreatContext = {
    if (sc == null) {
      new SparkContext(conf)
    } else sc
  }
  
  def stopSparkContext {
    println("ok")
    if (!sc.isStopped) sc.stop()
  }
  
}