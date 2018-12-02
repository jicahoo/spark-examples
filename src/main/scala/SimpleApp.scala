import org.apache.spark.{SparkConf, SparkContext}

object SimpleApp {
  def main(args: Array[String]): Unit = {
    val logFIle = "/Users/zhangflash/Documents/programs/spark-2.4.0-bin-hadoop2.7/README.md"
    val conf = new SparkConf().setAppName("Sample App")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFIle, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs,numBs))
  }
}
