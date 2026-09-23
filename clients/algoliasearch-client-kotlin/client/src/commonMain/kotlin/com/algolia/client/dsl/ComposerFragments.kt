package com.algolia.client.dsl

/**
 * Stored blocks for one composer field. Nothing runs at [add] time; [replay] runs every block, in
 * call order, on one receiver when the field is written.
 */
internal class Blocks<R> {
  private val blocks: MutableList<R.() -> Unit> = mutableListOf()

  fun add(block: R.() -> Unit) {
    blocks += block
  }

  fun isEmpty(): Boolean = blocks.isEmpty()

  fun replay(receiver: R) {
    for (block in blocks) receiver.block()
  }
}
