package com.github.tanacasino.hello

import com.twitter.finagle.http.{ Request, Response }
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{ CommonFilters, LoggingMDCFilter, TraceIdMDCFilter }
import com.twitter.finatra.http.routing.HttpRouter

object HelloServerMain extends HelloServer

class HelloServer extends HttpServer {

  override def configureHttp(router: HttpRouter) {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[HelloController]
  }

}

