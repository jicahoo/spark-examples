# spark-examples

## Steps
* Note: Tested on Linux.
* Example following guide of http://spark.apache.org/docs/1.2.2/quick-start.html
* Download: spark-2.4.0-bin-hadoop2.7.tgz
* sbt package #Then you will get jar: scalasbthello_2.11-0.1.jar
* run:
```shell
YOUR_SPARK_HOME/bin/spark-submit \
  --class "SimpleApp" \
  --master local[4] \
  <PathTo>/scalasbthello_2.11-0.1.jar
```


## Spark SQL example
* Prepare a file at `/root/test_data/man.json` with below content:
```json
   {"id" : "1201", "name" : "satish", "age" : "25"},
   {"id" : "1202", "name" : "krishna", "age" : "28"},
   {"id" : "1203", "name" : "amith", "age" : "39"},
   {"id" : "1204", "name" : "javed", "age" : "23"},
   {"id" : "1205", "name" : "prudvi", "age" : "23"}
```
* `./bin/spark-shell`
* `scala> val sqlContext = new org.apache.spark.sql.SQLContext(sc)`
* `scala> val dfs = sqlContext.read.json("/root/test_data/man.json")`
* `scala> dfs.show()`
* `scala> dfs.printSchema()`
* `scala> dfs.select("name").show()`
* `scala> dfs.filter(dfs("age") > 23 ).show()`
* `scala> dfs.groupBy("age").count().show()`
* `scala> dfs.first()`
* `scala> dfs.createOrReplaceTempView("man")`
* `scala> val sqlDF = spark.sql("SELECT * FROM man")`
* `scala> sqlDF.show()`
* `scala> val teenagersDF = spark.sql("SELECT name, age FROM man WHERE age BETWEEN 13 AND 30")`
* `scala> teenagersDF.show()`
* Reference:
    * https://spark.apache.org/docs/latest/sql-getting-started.html
    * https://www.tutorialspoint.com/spark_sql/spark_sql_quick_guide.htm