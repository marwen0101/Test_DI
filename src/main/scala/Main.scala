/**
  * Created by hasnaoui on 10/06/2017.
  */

trait OnOffDevice {
  def on: Unit
  def off: Unit
}

trait SensorDevice {
  def isCoffeePresent: Boolean
}

class Heater extends OnOffDevice {
  override def on: Unit = println("heater.on")

  override def off: Unit = println("heater.off")
}

class PotSensor extends SensorDevice {
  override def isCoffeePresent: Boolean = true
}

class Warmer (env: {
  val potSensor: SensorDevice
  val heater: OnOffDevice
}) {

  def trigger = {
    if (env.potSensor.isCoffeePresent) env.heater.on
    else env.heater.off
  }
}

class Client(env: {val warmer: Warmer}){
  env.warmer.trigger
}

object Config {
  lazy val potSensor = new PotSensor
  lazy val heater = new Heater
  lazy val warmer = new Warmer(this) // this is where injection happens
}

object Main {

  def main(args: Array[String]): Unit = {
    println("ok")
    val client = new Client(Config)
  }
}
