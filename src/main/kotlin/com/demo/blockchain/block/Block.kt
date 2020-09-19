package com.demo.blockchain.block

import com.demo.blockchain.utils.StringUtil
import lombok.Data
import java.util.*

@Data
class Block(previousHash: String, data: String) {
    val previousHash: String = previousHash
    val data: String = data
    var hash: String = calculateHash()
    val timeStamp = Date().time
    var nonce: Int = 0

    override fun toString(): String = "$hash $data $timeStamp \n";

    fun calculateHash(): String {
        return StringUtil.applySHA(data + previousHash + Long.to(timeStamp))
    }

    fun mineBlock(difficulty: Int) {
        println("Start mining......")
        val target = String(CharArray(difficulty)).replace('\u0000', '0')
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++
            hash = calculateHash();
        }
        println("Block mined !!! $hash")
    }
}