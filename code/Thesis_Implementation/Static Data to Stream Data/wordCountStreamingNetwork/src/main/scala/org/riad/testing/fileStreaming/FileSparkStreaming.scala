package org.riad.testing.fileStreaming

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.storage.StorageLevel

object FileSparkStreaming {
  
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[2]").setAppName("FileStreamingApp")
    val ssc = new StreamingContext(conf, Seconds(5))
    val lines = ssc.textFileStream("/Users/khanhafizurrahman/Desktop/Thesis/code/Thesis_Implementation/UploadFiles")
    lines.flatMap(x => x.split(" ") ).map (x => (x,1)).reduceByKey(_+_).print()
    ssc.start()
    ssc.awaitTermination()
  }
}