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
