package com.gaguena.sblog.controller.support

import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.ScalatraBase
import org.scalatra.json.JacksonJsonSupport

trait JsonSupport extends RestSupport with JacksonJsonSupport {
  self: ScalatraBase =>

  protected implicit lazy val jsonFormats: Formats = DefaultFormats.withBigDecimal

  val acceptmediaTypes: List[String]

  before() {
    /* if (acceptmediaTypes.find(request.getHeader("Accept").contains(_)).isEmpty) {
      halt(406, s"Content Accept error, versions: ${acceptmediaTypes}")
    }*/
    contentType = formats("json")
  }
}