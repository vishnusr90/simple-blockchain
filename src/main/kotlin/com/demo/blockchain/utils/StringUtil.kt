package com.demo.blockchain.utils

import java.security.MessageDigest


class StringUtil {
    companion object {
        fun applySHA(input: String): String {
            return try {
                val digest = MessageDigest.getInstance("SHA-256")
                //Applies sha256 to our input,
                val hash = digest.digest(input.toByteArray(Charsets.UTF_8))
                val hexString = StringBuffer() // This will contain hash as hexidecimal
                for (i in hash.indices) {
                    val hex = Integer.toHexString(0xff and hash[i].toInt())
                    if (hex.length == 1) hexString.append('0')
                    hexString.append(hex)
                }
                hexString.toString()
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }
    }
}