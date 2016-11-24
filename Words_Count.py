# Databricks notebook source exported at Thu, 24 Nov 2016 13:21:22 UTC
from pyspark.sql.functions import regexp_replace, trim, col, lower,split, explode,desc
def wordsCount(wordsDF):
  """
    parameter:
      wordsDF : a DataFrame with a column named 'word'.
    return :
      a DataFrame with a column named 'count',which is the count of the words.
  """
  return wordsDF.groupBy('word').count().orderBy(desc('count'))
wordsCounted = wordsCount(wordsDF)

def processText(column):
  """return a column without punctuation leading and trailing spaces and change to lower case"""
  return trim(regexp_replace(lower(column),r'[^a-z0-9_ ]',''))
"""load the file"""
fileName = "/FileStore/tables/2atn14yv1479972028772/book.txt"
sentenceDF = sqlContext.read.text(fileName).select(processText(col('value')).alias('sentence'))
"""split the sentence to words and filter out empty lines or words"""
wordsDF = (sentenceDF.select(explode(split('sentence',' ')).alias('word'))).where(r"word!=''")
wordsCountDF = wordsCount(wordsDF)
wordsCountDF.show()


