// Databricks notebook source
// MAGIC %md
// MAGIC 
// MAGIC Hello! This is a test using the sample to read CSV files.

// COMMAND ----------

// MAGIC %python 
// MAGIC 
// MAGIC import sys
// MAGIC print(sys.version)

// COMMAND ----------

// MAGIC %python
// MAGIC 
// MAGIC import pip #needed to use the pip functions
// MAGIC for i in pip.get_installed_distributions(local_only=True):
// MAGIC     print(i)

// COMMAND ----------

// MAGIC %scala 
// MAGIC 
// MAGIC 
// MAGIC val diamonds = sqlContext.read.format("csv")
// MAGIC   .option("header", "true")
// MAGIC   .option("inferSchema", "true")
// MAGIC   .load("/databricks-datasets/Rdatasets/data-001/csv/ggplot2/diamonds.csv")
// MAGIC 
// MAGIC display(diamonds)

// COMMAND ----------

// MAGIC %scala
// MAGIC 
// MAGIC diamonds.printSchema

// COMMAND ----------

// MAGIC %r 
// MAGIC 
// MAGIC diamonds <- read.df(sqlContext, "/databricks-datasets/Rdatasets/data-001/csv/ggplot2/diamonds.csv", source = "csv", header="true", inferSchema = "true")
// MAGIC 
// MAGIC display(diamonds)

// COMMAND ----------

// MAGIC %r
// MAGIC 
// MAGIC printSchema(diamonds)

// COMMAND ----------

// MAGIC %python
// MAGIC 
// MAGIC diamonds = sqlContext.read.format('csv').options(header='true', inferSchema='true').load('/databricks-datasets/Rdatasets/data-001/csv/ggplot2/diamonds.csv')
// MAGIC 
// MAGIC display(diamonds)

// COMMAND ----------

// MAGIC %python
// MAGIC 
// MAGIC diamonds.printSchema()

// COMMAND ----------

// MAGIC %sql
// MAGIC -- mode "FAILFAST" will abort file parsing with a RuntimeException if any malformed lines are encountered
// MAGIC CREATE TEMPORARY TABLE temp_diamonds
// MAGIC   USING csv
// MAGIC   OPTIONS (path "/databricks-datasets/Rdatasets/data-001/csv/ggplot2/diamonds.csv", header "true", mode "FAILFAST")

// COMMAND ----------

// MAGIC %sql SELECT * FROM temp_diamonds