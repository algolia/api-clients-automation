package com.algolia.client.dsl

/**
 * One additive composer field: blocks recorded by [add], replayed in call order on one [R] through
 * [write] on [B]. Nothing runs at [add] time.
 */
internal class Additive<B, R>(private val write: B.(R.() -> Unit) -> Unit) {
  private val blocks: MutableList<R.() -> Unit> = mutableListOf()

  fun add(block: R.() -> Unit) {
    blocks += block
  }

  /** Writes the field once when at least one block was recorded; otherwise leaves it untouched. */
  fun applyTo(builder: B) {
    if (blocks.isEmpty()) return
    // Bound to a local: inside the DSL-marked receiver lambda this instance must not be reached
    // implicitly.
    val recorded = blocks
    builder.write { for (block in recorded) block() }
  }
}

/**
 * add/override/build shell shared by the composers. Every [build] creates a fresh [A], runs every
 * stored [add] block on it, applies the collected additions to a fresh [B], then runs every stored
 * [override] block on that [B] in call order. Not thread-safe; every build replays every block.
 */
internal class ComposerCore<A, B>(
  private val newAdditions: () -> A,
  private val newBuilder: () -> B,
  private val applyAdditions: A.(B) -> Unit,
) {
  private val additions: MutableList<A.() -> Unit> = mutableListOf()
  private val overrides: MutableList<B.() -> Unit> = mutableListOf()

  fun add(block: A.() -> Unit) {
    additions += block
  }

  fun override(block: B.() -> Unit) {
    overrides += block
  }

  fun build(): B {
    val collected = newAdditions()
    for (block in additions) collected.block()
    val builder = newBuilder()
    collected.applyAdditions(builder)
    for (block in overrides) builder.block()
    return builder
  }
}
