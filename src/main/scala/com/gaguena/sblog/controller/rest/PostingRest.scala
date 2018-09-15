package com.gaguena.sblog.controller.rest

import java.time.LocalDateTime

import scala.concurrent.Future

import org.scalatra.AsyncResult
import com.gaguena.sblog.controller.support.RestSupport
import com.gaguena.sblog.controller.support.JsonSupport

object PostingRest {
  val PostingRestType = "application/vnd.gaguena.autor.v1+json"
}

class PostingRest extends RestSupport with JsonSupport {

  override val acceptmediaTypes = List(PostingRest.PostingRestType)

  get("/") {
    new AsyncResult {
      val is = Future.successful(Pessoa(35, "Aguena"))
    }
  }
}

case class Pessoa(idade: Int, nome: String)