package com.gaguena.sblog.database

import com.mchange.v2.c3p0.ComboPooledDataSource
import org.slf4j.LoggerFactory
import org.scalatra._
import javax.servlet.ServletContext

import slick.jdbc.H2Profile.api._

trait DataBaseSupport {

  val logger = LoggerFactory.getLogger(getClass)

  val cpds = new ComboPooledDataSource

  def closeDbConnection() {
    logger.info("Closing c3po connection pool")
    cpds.close
  }
}

trait Repository extends DataBaseSupport {
  val db = Database.forDataSource(cpds, None)
}