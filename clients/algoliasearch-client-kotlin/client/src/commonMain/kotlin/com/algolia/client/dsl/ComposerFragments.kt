package com.algolia.client.dsl

import kotlin.reflect.KMutableProperty1

/**
 * One additive composer field: blocks recorded by [add], replayed in call order on one [R] through
 * [write] on [B]. Nothing runs at [add] time. [seed] reads what the base left on [B] and returns a
 * block that runs first on [R], or `null` when there is nothing to merge.
 */
internal class Additive<B, R>(
  private val seed: (B) -> (R.() -> Unit)? = { null },
  private val write: B.(R.() -> Unit) -> Unit,
) {
  private val blocks: MutableList<R.() -> Unit> = mutableListOf()

  fun add(block: R.() -> Unit) {
    blocks += block
  }

  /** Writes the field once when at least one block was recorded; otherwise leaves it untouched. */
  fun applyTo(builder: B) {
    if (blocks.isEmpty()) return
    // Bound to locals: inside the DSL-marked receiver lambda this instance must not be reached
    // implicitly, and the base must be read before the write replaces it.
    val seeded = seed(builder)
    val recorded = blocks
    builder.write {
      seeded?.invoke(this)
      for (block in recorded) block()
    }
  }
}

/**
 * A list field whose fragments append to the base value of [property]. When the merged list is
 * empty, the base value is kept, so a base `emptyList()` still sends `[]`.
 */
internal fun <B, R, T> listAdditive(
  property: KMutableProperty1<B, List<T>?>,
  append: R.(List<T>) -> Unit,
  writeList: B.(R.() -> Unit) -> Unit,
): Additive<B, R> =
  Additive(
    seed = { builder -> property.get(builder)?.let { base -> { append(base) } } },
    write = { block ->
      val base = property.get(this)
      writeList(block)
      if (property.get(this) == null) property.set(this, base)
    },
  )

/**
 * A filter field whose fragments add rows after the base rows [baseRows] reads from the builder.
 * Throws [IllegalStateException] when the base assigned [field] directly: an encoded value cannot
 * be merged safely.
 */
internal fun <B, R, L> filterAdditive(
  field: String,
  baseRows: (B) -> List<List<L>>?,
  addRows: R.(List<List<L>>) -> Unit,
  write: B.(R.() -> Unit) -> Unit,
): Additive<B, R> =
  Additive(
    seed = { builder ->
      val rows =
        checkNotNull(baseRows(builder)) {
          "The composer base assigns $field directly, so add { $field { } } fragments cannot " +
            "merge into it. Set it with $field { } in the base, or move it to add { }."
        }
      val seed: R.() -> Unit = { addRows(rows) }
      seed
    },
    write = write,
  )

/**
 * add/override/build shell shared by the composers. Every [build] creates a fresh [A], runs every
 * stored [add] block on it, creates a fresh [B] and runs [base] on it, merges the collected
 * additions into that [B], then runs every stored [override] block on it in call order. Not
 * thread-safe; every build replays every block.
 */
internal class ComposerCore<A, B>(
  private val newAdditions: () -> A,
  private val newBuilder: () -> B,
  private val base: B.() -> Unit,
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
    builder.base()
    collected.applyAdditions(builder)
    for (block in overrides) builder.block()
    return builder
  }
}
