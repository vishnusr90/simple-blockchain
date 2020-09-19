package com.demo.blockchain

import com.demo.blockchain.block.Block
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SimpleBlockchainApplication

val blockChain = mutableListOf<Block>()
const val difficulty = 0;

fun main(args: Array<String>) {
    //  runApplication<SimpleBlockchainApplication>(*args)
    val genesisBlock = Block("0", "Hi i am first block");
    println(genesisBlock.toString())

    val secondBlock = Block(genesisBlock.hash, "I am second block")
    println(secondBlock.toString())

    val thirdBlock = Block(secondBlock.hash, "Third Block")
    println(thirdBlock.toString())

    blockChain.add(genesisBlock)
    blockChain[0].mineBlock(difficulty)

    blockChain.add(secondBlock)
    blockChain[1].mineBlock(difficulty)

    blockChain.add(thirdBlock)
    blockChain[2].mineBlock(difficulty)

    println(blockChain)
}

fun isChainValid(): Boolean {
    var currentBlock: Block
    var previousBlock: Block
    val hashTarget = String(CharArray(difficulty)).replace('\u0000', '0')

    println("hash target $hashTarget")
    for(i in 1 until blockChain.size) {
        currentBlock = blockChain[i]
        previousBlock = blockChain[i-1]

        if(!currentBlock.hash.equals(currentBlock.calculateHash())) {
            println("Current hashes are not equal")
            return false
        } else if (!previousBlock.hash.equals(previousBlock.calculateHash())) {
            println("Previous hashes are not equal")
            return false
        } else if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
            println("This block hasn't been mined")
            return false
        }
    }
    return true
}
