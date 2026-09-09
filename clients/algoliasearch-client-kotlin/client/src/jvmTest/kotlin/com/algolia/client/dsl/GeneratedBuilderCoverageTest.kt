@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.generated.BrowseParamsObjectBuilder
import com.algolia.client.dsl.generated.ConsequenceParamsBuilder
import com.algolia.client.dsl.generated.DeleteByParamsBuilder
import com.algolia.client.dsl.generated.IndexSettingsBuilder
import com.algolia.client.dsl.generated.SearchParamsObjectBuilder
import com.algolia.client.model.search.BrowseParamsObject
import com.algolia.client.model.search.ConsequenceParams
import com.algolia.client.model.search.DeleteByParams
import com.algolia.client.model.search.IndexSettings
import com.algolia.client.model.search.SearchParamsObject
import java.lang.reflect.Modifier
import kotlin.reflect.KClass
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Drift guard between generated DSL builders and their allow-listed model constructors.
 *
 * Do not assert that an empty builder serializes to `{}`. Client Json omits default nulls
 * (`encodeDefaults` is off), so a builder that forgot a new spec field also serializes to `{}`.
 *
 * This test compares generated builder `var` names to model constructor parameter names via
 * [KClass] plus JVM reflection. A new spec field that the template missed fails here. A removed
 * field fails compilation because `build()` still passes every builder `var` into the model
 * constructor.
 *
 * Regenerating `SearchDsl.kt` updates the builder; this test needs no edit.
 *
 * Placed under `jvmTest` because constructor and `var` lookup needs JVM [Class] reflection.
 * `kotlin.reflect.full` (`memberProperties` / `primaryConstructor`) is not on the test classpath.
 */
internal class GeneratedBuilderCoverageTest {

  @Test
  fun searchParamsObjectBuilderMatchesConstructor() {
    assertBuilderVarsMatchConstructor(SearchParamsObjectBuilder::class, SearchParamsObject::class)
  }

  @Test
  fun indexSettingsBuilderMatchesConstructor() {
    assertBuilderVarsMatchConstructor(IndexSettingsBuilder::class, IndexSettings::class)
  }

  @Test
  fun browseParamsObjectBuilderMatchesConstructor() {
    assertBuilderVarsMatchConstructor(BrowseParamsObjectBuilder::class, BrowseParamsObject::class)
  }

  @Test
  fun deleteByParamsBuilderMatchesConstructor() {
    assertBuilderVarsMatchConstructor(DeleteByParamsBuilder::class, DeleteByParams::class)
  }

  @Test
  fun consequenceParamsBuilderMatchesConstructor() {
    assertBuilderVarsMatchConstructor(ConsequenceParamsBuilder::class, ConsequenceParams::class)
  }

  private fun assertBuilderVarsMatchConstructor(builder: KClass<*>, model: KClass<*>) {
    val builderVars = builderVarNames(builder)
    val constructorParams = constructorParameterNames(model)

    assertTrue(
      constructorParams.isNotEmpty(),
      "${model.simpleName} constructor parameters must not be empty",
    )
    assertEquals(
      constructorParams,
      builderVars,
      buildString {
        append("${builder.simpleName} vars must match ${model.simpleName} constructor parameters.")
        val missingOnBuilder = constructorParams - builderVars
        val extraOnBuilder = builderVars - constructorParams
        if (missingOnBuilder.isNotEmpty()) {
          append(" missingOnBuilder=$missingOnBuilder.")
        }
        if (extraOnBuilder.isNotEmpty()) {
          append(" extraOnBuilder=$extraOnBuilder.")
        }
      },
    )
  }

  /**
   * Kotlin `var` properties compile to a field plus a one-argument setter. Static and synthetic
   * fields are ignored.
   */
  private fun builderVarNames(builder: KClass<*>): Set<String> {
    val javaClass = builder.java
    return javaClass.declaredFields
      .filter { field ->
        !field.isSynthetic &&
          !Modifier.isStatic(field.modifiers) &&
          javaClass.methods.any { method ->
            method.parameterCount == 1 && method.name == setterName(field.name)
          }
      }
      .map { it.name }
      .toSet()
  }

  /**
   * Primary constructor parameter names. [java.lang.reflect.Parameter.getName] is `argN` unless
   * MethodParameters is present, so this falls back to the data-class instance fields, which match
   * the primary constructor.
   */
  private fun constructorParameterNames(model: KClass<*>): Set<String> {
    val javaClass = model.java
    val primary =
      javaClass.declaredConstructors
        .filter { constructor ->
          constructor.parameterTypes.none { type ->
            type.name.endsWith("DefaultConstructorMarker") ||
              type.name.endsWith("SerializationConstructorMarker")
          }
        }
        .filter { it.parameterCount > 0 }
        .maxByOrNull { it.parameterCount }
        ?: error("${model.simpleName} has no primary constructor")

    val reflectedNames = primary.parameters.map { it.name }
    if (
      reflectedNames.size == primary.parameterCount && reflectedNames.none { it.startsWith("arg") }
    ) {
      return reflectedNames.toSet()
    }

    return javaClass.declaredFields
      .filter { !it.isSynthetic && !Modifier.isStatic(it.modifiers) }
      .map { it.name }
      .toSet()
  }

  private fun setterName(propertyName: String): String =
    "set" + propertyName.replaceFirstChar { it.uppercaseChar() }
}
