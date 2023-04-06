package example

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

class WikiLoad extends Simulation with WikiLoadTyper {
  def scnWiki: ScenarioBuilder = scenario("WIKI LOAD").exec(WikiMethods.mainEnWiki)

  loader(scnWiki,"UP")

}
