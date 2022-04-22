package sample

import org.apache.spark.sql.SparkSession

object DataframeHeaderFIle {
  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder().master("yarn").appName("SampleApp").getOrCreate()
    val schema= "id INT,name STRING,age INT,friends INT "
    import sparkSession.implicits._
    val people =sparkSession.read.option("header",false).schema(schema).csv("data/fakefriends-noheader.csv").toDF()
    people.printSchema()

  }
}
