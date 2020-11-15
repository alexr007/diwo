package diwo

import org.scalatest.{BeforeAndAfterAll, GivenWhenThen}
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

abstract class ASpec extends AnyFunSpec with Matchers with BeforeAndAfterAll with GivenWhenThen {

}
