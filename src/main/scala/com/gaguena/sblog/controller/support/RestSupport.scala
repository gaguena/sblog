package com.gaguena.sblog.controller.support

import scala.concurrent.ExecutionContext

import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.{ BadRequest, FutureSupport, NotFound, ScalatraBase, ScalatraServlet, UrlGeneratorSupport }
import org.scalatra.json.JacksonJsonSupport
import org.slf4j.LoggerFactory

import akka.actor.ActorSystem

trait RestSupport extends ScalatraServlet
  with FutureSupport
  with UrlGeneratorSupport {

  protected implicit def executor: ExecutionContext = ActorSystem().dispatcher
  
  private[this] val logger = LoggerFactory.getLogger(getClass)

  def badRequest(message: String) = {
    logger.info(s"BadRequest: $message")
    BadRequest(resultMessage(message))
  }

  def notFound(message: String) = {
    logger.info(s"NotFound: $message")
    NotFound(resultMessage(message))
  }

  private def resultMessage(message: String) = ResponseMessage(message)
}

