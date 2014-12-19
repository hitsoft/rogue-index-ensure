package com.hitsoft.rogue.index

import com.foursquare.index.{IndexedRecord, MongoIndex}
import net.liftweb.mongodb.BsonDSL._
import net.liftweb.mongodb.MongoMeta

trait AutoMongoIndexes[M] extends MongoMeta[M] with IndexedRecord[M] {

  val mongoIndexUniqueList: List[MongoIndex[M]]

  def ensureIndexes(): Unit = {
    for (idx <- mongoIndexList) {
      val keys = idx.asListMap.map { case (k, v) => (k, v.asInstanceOf[Int]) }
      ensureIndex(keys, unique = mongoIndexUniqueList.contains(idx))
    }
  }
}
