package example

import io.gatling.core.Predef.{heavisideUsers, incrementConcurrentUsers, _}
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef.http

import scala.concurrent.duration._
import scala.language.postfixOps


trait WikiLoadTyper extends Simulation {

  def loader(scenario: ScenarioBuilder, stringChooser: String) = {

    val httpProtocol = http.baseUrl("en.wikipedia.org")


    if (stringChooser == "UP") {
      setUp(
        scenario.inject(heavisideUsers(10) during (5 seconds))
      ).maxDuration(60 seconds).protocols(httpProtocol)
    }

    /**
     * Количество пользователей поднимается от 1 с шагом 10.
     * Длительность шага 60 секунд.
     */


    if (stringChooser == "GROW") {
      setUp(
        scenario.inject(incrementConcurrentUsers(10)
          .times(5)
          .eachLevelLasting(60 seconds)
          .startingFrom(1))
      ).maxDuration(120).protocols(httpProtocol)
    }



  }

}
