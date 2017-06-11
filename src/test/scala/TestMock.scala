/**
  * Created by hasnaoui on 10/06/2017.
  */
import java.util.Date

import org.mockito.stubbing.Answer
import org.scalatest.mock._
import org.mockito.Mockito._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.mockito.Matchers._

trait DumbFormatter {

  def formatWithDataTimePrefix(inputString : String, date : Date) : String = {
    s"date : $date : $inputString"
  }

  def getDate() : String = {
    new Date().toString
  }
}

@RunWith(classOf[JUnitRunner])
class TestMock extends FunSuite with MockitoSugar{

  test("first test and what else") {
    //mock creation
    val mockedList = mock[java.util.ArrayList[String]]

    //using mock object
    mockedList.add("one");
    mockedList.clear

    //verification
    verify(mockedList).add("one")
    verify(mockedList).clear
  }

  test("Date should be formatted correctly") {
    val mockDumbFormatter = mock[DumbFormatter]
    when(mockDumbFormatter.getDate()).thenReturn("01/01/2015")
    assert("01/01/2015" === mockDumbFormatter.getDate())

  }

  test("argument passing") {
    val mockDumbFormatter = mock[DumbFormatter]
    when(mockDumbFormatter.formatWithDataTimePrefix(anyString(), any[Date]())).thenReturn("01/01/2015 somthing")
    assert("01/01/2015 somthing" == mockDumbFormatter.formatWithDataTimePrefix("kjqdskdj", new Date()))
  }

  test("intercept Exception") {
    val mockDumbFormatter = mock[DumbFormatter]
    when(mockDumbFormatter.formatWithDataTimePrefix(anyString(), any[Date]())).thenThrow(new RuntimeException())
    intercept[RuntimeException] {
      mockDumbFormatter.formatWithDataTimePrefix("kjqdskdj", new Date())
    }
  }
  test ("stubbing") {
    var mockDumbFormatter = mock[DumbFormatter]
    when(mockDumbFormatter.formatWithDataTimePrefix(anyString(),any[Date]()))
      .thenReturn("someString")

    val theDate = new Date()
    val theResult = mockDumbFormatter.formatWithDataTimePrefix("blah blah blah", theDate)
    val theResult2 = mockDumbFormatter.formatWithDataTimePrefix("no no no", theDate)

    verify(mockDumbFormatter, atLeastOnce()).formatWithDataTimePrefix("blah blah blah", theDate)
    verify(mockDumbFormatter, times(1)).formatWithDataTimePrefix("no no no", theDate)
  }
}
