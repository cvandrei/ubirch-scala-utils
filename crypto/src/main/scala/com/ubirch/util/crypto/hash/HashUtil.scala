package com.ubirch.util.crypto.hash

import com.roundeights.hasher.Implicits._
import com.roundeights.hasher.{Digest, Hash}

import scala.util.Random

/**
  * author: cvandrei
  * since: 2016-07-28
  */
object HashUtil {

  /**
    * Gives us the Digest of a hash based on which call all sorts of methods (including conversion to hexString or
    * byteArray).
    *
    * @param data data to hash
    * @return digest with hash of input data
    */
  def sha256Digest(data: String): Digest = data.sha256

  /**
    * Convenience method that gives us the hash of the input as hexString.
    *
    * @param data data to hash
    * @return hex string representation: SHA-256 hash of input data
    */
  def sha256HexString(data: String): String = sha256Digest(data).hex

  /**
    * Convenience method that gives us the hash of the input as byte array.
    *
    * @param data data to hash
    * @return byte array representation: SHA-256 hash of input data
    */
  def sha256ByteArray(data: String): Array[Byte] = sha256Digest(data).bytes

  /**
    * Convenience method correctly converting a hash from hex string to byte array.
    *
    * @param hexString hash represented as hex string
    * @return input converted to byte array
    */
  def hashToBytes(hexString: String): Array[Byte] = Hash(hexString).bytes

  /**
    * Convenience method correctly converting a hash from byte array to hex string.
    *
    * @param byteArray hash represented as byte array
    * @return input converted to hex string
    */
  def hashToHex(byteArray: Array[Byte]): String = Hash(byteArray).hex

  /**
    * Convenience method generating n many random hashes (useful for tests).
    *
    * @param maxElementCount maximum number of randomly generated hashes
    * @return sequence of random hashes
    */
  def randomSha256Hashes(maxElementCount: Int = Random.nextInt(30000)): Seq[String] = {

    val randomSeq: Seq[String] = for (i <- 1 to maxElementCount) yield Random.nextLong.toString

    randomSeq.map(HashUtil.sha256HexString)

  }

}
