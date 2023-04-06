package example

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object WikiMethods {

  val mainEnWiki: ChainBuilder = exec(http("mainEnWiki")
    .get("https://en.wikipedia.org/wiki/Main_Page")
    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
  )

  val mainRuWiki: ChainBuilder = exec(http("mainRuWiki")
    .get("ru.wikipedia.org")
    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
  )



}
