package com.ubirch.util.date

import org.joda.time.{DateTime, DateTimeZone}
import org.joda.time.format.ISODateTimeFormat
import org.scalatest.{FeatureSpec, Matchers}

/**
  * author: cvandrei
  * since: 2017-09-26
  */
class DateUtilSpec extends FeatureSpec
  with Matchers {

  feature("parseDateToUTC()") {

    scenario("invalid date") {
      an [IllegalArgumentException] shouldBe thrownBy(DateUtil.parseDateToUTC("2017-Sep-26"))
    }

    scenario("valid date") {
      DateUtil.parseDateToUTC("2017-09-26").toString(ISODateTimeFormat.dateTime()) should be("2017-09-26T00:00:00.000Z")
    }

  }

  feature("dateRange") {

    scenario("from = to, 5 second stepSize") {

      // prepare
      val from = DateTime.now(DateTimeZone.UTC)
      val to = from

      // test
      val result = DateUtil.dateRange(from = from, to = to, stepSize = 5000)

      // verify
      result should be(List(from))

    }

    scenario("from = to, -5 second stepSize") {

      // prepare
      val from = DateTime.now(DateTimeZone.UTC)
      val to = from

      // test && verify
      DateUtil.dateRange(from = from, to = to, stepSize = -5000) should be(Seq.empty)

    }

    scenario("from < to (=from + 2*stepSize), 5 second stepSize") {

      // prepare
      val stepSize = 5000
      val from = DateTime.now(DateTimeZone.UTC)
      val to = from.plus(2 * stepSize)

      // test
      val result = DateUtil.dateRange(from = from, to = to, stepSize = stepSize)

      // verify
      val expected = List(from, from.plus(stepSize), to)
      result should be(expected)

    }

    scenario("from < to (=from + 2*stepSize-1), 5000 millisecond stepSize") {

      // prepare
      val stepSize = 5000
      val from = DateTime.now(DateTimeZone.UTC)
      val to = from.plus(2 * stepSize - 1)

      // test
      val result = DateUtil.dateRange(from = from, to = to, stepSize = stepSize)

      // verify
      val expected = List(from, from.plus(stepSize))
      result should be(expected)

    }

    scenario("from < to (=from + 2*stepSize+1), 5000 millisecond stepSize") {

      // prepare
      val stepSize = 5000
      val from = DateTime.now(DateTimeZone.UTC)
      val to = from.plus(2 * stepSize + 1)

      // test
      val result = DateUtil.dateRange(from = from, to = to, stepSize = stepSize)

      // verify
      val expected = List(from, from.plus(stepSize), from.plus(2 * stepSize))
      result should be(expected)

    }

    scenario("from < to (=from + 2*stepSize), -5 second stepSize") {

      // prepare
      val stepSize = -5000
      val from = DateTime.now(DateTimeZone.UTC)
      val to = from.plus(2 * stepSize)

      // test && verify
      DateUtil.dateRange(from = from, to = to, stepSize = stepSize) should be(Seq.empty)

    }

    scenario("from < to (=from + 2*stepSize-1), -5000 millisecond stepSize") {

      // prepare
      val stepSize = -5000
      val from = DateTime.now(DateTimeZone.UTC)
      val to = from.plus(2 * stepSize - 1)

      // test && verify
      DateUtil.dateRange(from = from, to = to, stepSize = stepSize) should be(Seq.empty)

    }

    scenario("from < to (=from + 2*stepSize+1), -5000 millisecond stepSize") {

      // prepare
      val stepSize = -5000
      val from = DateTime.now(DateTimeZone.UTC)
      val to = from.plus(2 * stepSize + 1)

      // test && verify
      DateUtil.dateRange(from = from, to = to, stepSize = stepSize) should be(Seq.empty)

    }

    scenario("to > from (=to + 2*stepSize), 5 second stepSize") {

      // prepare
      val stepSize = 5000
      val to = DateTime.now(DateTimeZone.UTC)
      val from = to.plus(2 * stepSize)

      // test
      val result = DateUtil.dateRange(from = from, to = to, stepSize = stepSize)

      // verify
      val expected = List(from, from.minus(stepSize), to)
      result should be(expected)

    }

    scenario("to > from (=to + 2*stepSize-1), 5000 millisecond stepSize") {

      // prepare
      val stepSize = 5000
      val to = DateTime.now(DateTimeZone.UTC)
      val from = to.plus(2 * stepSize - 1)

      // test
      val result = DateUtil.dateRange(from = from, to = to, stepSize = stepSize)

      // verify
      val expected = List(from, from.minus(stepSize))
      result should be(expected)

    }

    scenario("from > to (=from + 2*stepSize+1), 5000 millisecond stepSize") {

      // prepare
      val stepSize = 5000
      val to = DateTime.now(DateTimeZone.UTC)
      val from = to.plus(2 * stepSize + 1)

      // test
      val result = DateUtil.dateRange(from = from, to = to, stepSize = stepSize)

      // verify
      val expected = List(from, from.minus(stepSize), from.minus(2 * stepSize))
      result should be(expected)

    }

    scenario("to > from (=to + 2*stepSize), -5 second stepSize") {

      // prepare
      val stepSize = -5000
      val to = DateTime.now(DateTimeZone.UTC)
      val from = to.plus(2 * stepSize)

      // test && verify
      DateUtil.dateRange(from = from, to = to, stepSize = stepSize) should be(Seq.empty)

    }

    scenario("to > from (=to + 2*stepSize-1), -5000 millisecond stepSize") {

      // prepare
      val stepSize = -5000
      val to = DateTime.now(DateTimeZone.UTC)
      val from = to.plus(2 * stepSize - 1)

      // test && verify
      DateUtil.dateRange(from = from, to = to, stepSize = stepSize) should be(Seq.empty)

    }

    scenario("from > to (=from + 2*stepSize+1), -5000 millisecond stepSize") {

      // prepare
      val stepSize = -5000
      val to = DateTime.now(DateTimeZone.UTC)
      val from = to.plus(2 * stepSize + 1)

      // test && verify
      DateUtil.dateRange(from = from, to = to, stepSize = stepSize) should be(Seq.empty)

    }

  }

}
