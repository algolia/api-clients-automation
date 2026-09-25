@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.DSLFilters
import com.algolia.client.dsl.generated.DSLSearchParamsObjectAdditions
import com.algolia.client.model.search.SearchParamsObject
import kotlin.jvm.JvmOverloads

/**
 * Collects query fragments from several modules and builds one [SearchParamsObject].
 *
 * [add] and [override] only store their blocks; nothing runs until [build]. Each [build] runs every
 * stored [add] block, runs [base] on a fresh [DSLQuery], then merges each additive field into it
 * once: all `filters { }` fragments run inside one [DSLFilters] after the base rows (so they are
 * AND-ed with the base), all `ruleContexts { }` fragments inside one [DSLStrings] after the base
 * list (so they concatenate in call order), and so on. Then every [override] block runs on the same
 * [DSLQuery], in call order: last write wins, so an override that sets `filters` or a list field
 * replaces the merged value. A list field whose fragments add nothing is sent as `[]`; empty
 * `filters { }` / `optionalFilters { }` fragments leave the field as the base set it, or omitted.
 *
 * Put the starting query in [base], not in an [override]: an override replaces the fragments. A
 * base that assigns `filters` or `optionalFilters` directly (`filters = "a OR b"`) cannot be merged
 * with fragments for that field, so [build] throws [IllegalStateException]. Use the `filters { }`
 * block in the base instead.
 *
 * To start from an existing [SearchParamsObject], pass it as `from`: each [build] copies its values
 * into a fresh [DSLQuery] (the object itself is never modified), then every field that has `add {
 * }` fragments is replaced by those fragments, and every [override] runs last. Fields without
 * fragments keep the object's value. This is the version 2 `QueryWrapper(query).build()` behaviour,
 * without mutating the query.
 *
 * Every [build] re-evaluates every stored block, so values captured by reference (a `var`, a
 * mutable list) are read at build time and side effects in a block repeat on each build. [build]
 * can be called repeatedly. Not thread-safe.
 *
 * ```
 * val composer = DSLQueryComposer(base = { hitsPerPage = 10; filters { facet("base", "x") } })
 * composer.add { filters { facet("module", "y") } }
 * val params = composer.build() // filters = "base:x AND module:y"
 *
 * val seeded = DSLQueryComposer(from = existing) // existing.filters = "old:1", hitsPerPage = 5
 * seeded.add { filters { facet("module", "y") } }
 * seeded.build() // filters = "module:y", hitsPerPage = 5
 * ```
 */
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLQueryComposer
private constructor(private val core: ComposerCore<DSLSearchParamsObjectAdditions, DSLQuery>) {

  /** Starts every [build] from [base] run on an empty [DSLQuery]; fragments merge into it. */
  @JvmOverloads
  public constructor(
    base: DSLQuery.() -> Unit = {}
  ) : this(
    ComposerCore(
      ::DSLSearchParamsObjectAdditions,
      { DSLQuery() },
      base,
      merge = true,
      DSLSearchParamsObjectAdditions::applyTo,
    )
  )

  /**
   * Starts every [build] from a copy of [from]; a field with `add { }` fragments is replaced by
   * them.
   */
  public constructor(
    from: SearchParamsObject
  ) : this(
    ComposerCore(
      ::DSLSearchParamsObjectAdditions,
      { DSLQuery(from) },
      {},
      merge = false,
      DSLSearchParamsObjectAdditions::applyTo,
    )
  )

  /**
   * Stores [block]. It runs on every [build], before the overrides; captured values are read then.
   */
  public fun add(block: DSLQueryAdditions.() -> Unit): Unit = core.add(block)

  /** Stores [block]. It runs on every [build], after the additive fields. Last write wins. */
  public fun override(block: DSLQuery.() -> Unit): Unit = core.override(block)

  public fun build(): SearchParamsObject = core.build().build()
}

/** `DSLQueryComposer(base).apply(block).build()`. */
@AlgoliaExperimentalDsl
public fun composeQuery(
  base: DSLQuery.() -> Unit = {},
  block: DSLQueryComposer.() -> Unit,
): SearchParamsObject {
  return DSLQueryComposer(base).apply(block).build()
}

/** `DSLQueryComposer(from).apply(block).build()`. */
@AlgoliaExperimentalDsl
public fun composeQuery(
  from: SearchParamsObject,
  block: DSLQueryComposer.() -> Unit,
): SearchParamsObject {
  return DSLQueryComposer(from).apply(block).build()
}
