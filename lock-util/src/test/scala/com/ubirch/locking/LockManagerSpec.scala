package com.ubirch.locking

import com.typesafe.scalalogging.slf4j.StrictLogging
import com.ubirch.locking.config.LockingConfig
import com.ubirch.util.uuid.UUIDUtil
import org.scalatest.{FeatureSpec, Matchers}

class LockManagerSpec extends FeatureSpec
  with LockManager
  with StrictLogging
  with Matchers {

  feature("basic test") {

    scenario("create a lock") {
      val lockName = s"myLock-${UUIDUtil.uuidStr}"
      lock(lockName) shouldBe true
      unlock(lockName) shouldBe true
    }

    scenario("no lock") {
      val lockName = s"myLock-${UUIDUtil.uuidStr}"
      unlock(lockName) shouldBe false
    }
  }
}
