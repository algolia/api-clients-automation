@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.generated.SearchParamsObjectBuilder
import java.io.File
import java.lang.reflect.Modifier
import kotlin.reflect.KClass
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Drift guard between generated DSL builders and their model constructors.
 *
 * Do not assert that an empty builder serializes to `{}`. Client Json omits default nulls
 * (`encodeDefaults` is off), so a builder that forgot a new spec field also serializes to `{}`.
 *
 * This test compares generated builder `var` names to model constructor parameter names via
 * [KClass] plus JVM reflection. A new spec field that the template missed fails here. A removed
 * field fails compilation because `build()` still passes every builder `var` into the model
 * constructor.
 *
 * Regenerating the per-model builder files updates the builder set; this test discovers every class
 * named `SomethingBuilder` in `com.algolia.client.dsl.generated`.
 *
 * Placed under `jvmTest` because constructor and `var` lookup needs JVM [Class] reflection.
 * `kotlin.reflect.full` (`memberProperties` / `primaryConstructor`) is not on the test classpath.
 */
internal class GeneratedBuilderCoverageTest {

  @Test
  fun allGeneratedBuildersMatchConstructors() {
    val builders = generatedBuilderClasses()
    assertTrue(builders.isNotEmpty(), "expected generated builders on the classpath")
    for (builder in builders) {
      val modelName = builder.simpleName.removeSuffix("Builder")
      val model = Class.forName("com.algolia.client.model.search.$modelName").kotlin
      assertBuilderVarsMatchConstructor(builder.kotlin, model)
    }
  }

  /**
   * Drift guard for generated filter helpers.
   *
   * The generator must emit exactly twenty public `Function1` members (`filters`, `facetFilters`,
   * `optionalFilters`, `numericFilters`, `tagFilters`) on the five allowlisted builders. A leak
   * onto SearchForHitsBuilder, SearchForFacetsBuilder, SecuredApiKeyRestrictionsBuilder,
   * RankingInfoBuilder, or AutoFilteringResultBuilder fails here. A helper the generator silently
   * stops emitting also fails here.
   */
  @Test
  fun filterHelpersOnlyOnAllowlistedBuilders() {
    val actual =
      generatedBuilderClasses()
        .flatMap { builder ->
          filterHelperMethodNames(builder).map { name -> builder.simpleName to name }
        }
        .toSet()
    val expected =
      setOf(
        "SearchParamsObjectBuilder" to "filters",
        "SearchParamsObjectBuilder" to "facetFilters",
        "SearchParamsObjectBuilder" to "optionalFilters",
        "SearchParamsObjectBuilder" to "numericFilters",
        "SearchParamsObjectBuilder" to "tagFilters",
        "BrowseParamsObjectBuilder" to "filters",
        "BrowseParamsObjectBuilder" to "facetFilters",
        "BrowseParamsObjectBuilder" to "optionalFilters",
        "BrowseParamsObjectBuilder" to "numericFilters",
        "BrowseParamsObjectBuilder" to "tagFilters",
        "ConsequenceParamsBuilder" to "filters",
        "ConsequenceParamsBuilder" to "facetFilters",
        "ConsequenceParamsBuilder" to "optionalFilters",
        "ConsequenceParamsBuilder" to "numericFilters",
        "ConsequenceParamsBuilder" to "tagFilters",
        "DeleteByParamsBuilder" to "filters",
        "DeleteByParamsBuilder" to "facetFilters",
        "DeleteByParamsBuilder" to "numericFilters",
        "DeleteByParamsBuilder" to "tagFilters",
        "ConditionBuilder" to "filters",
      )
    assertEquals(
      expected,
      actual,
      buildString {
        append("generated filter helpers must match the allowlisted builder surface.")
        val missing = expected - actual
        val unexpected = actual - expected
        if (missing.isNotEmpty()) {
          append(" missing=$missing.")
        }
        if (unexpected.isNotEmpty()) {
          append(" unexpected=$unexpected.")
        }
      },
    )
  }

  private fun generatedBuilderClasses(): List<Class<*>> {
    val root =
      File(SearchParamsObjectBuilder::class.java.protectionDomain.codeSource.location.toURI())
    val prefix = "com/algolia/client/dsl/generated/"
    return root
      .walkTopDown()
      .filter { file ->
        file.isFile && file.name.endsWith("Builder.class") && file.path.contains(prefix)
      }
      .map { file ->
        val qualified =
          file.relativeTo(root).path.removeSuffix(".class").replace(File.separatorChar, '.')
        Class.forName(qualified)
      }
      .sortedBy { it.simpleName }
      .toList()
  }

  /**
   * Public one-argument `Function1` members named after a filter field. Synthetic/bridge methods
   * and property accessors (`getFilters` / `setFilters`) are excluded by name and parameter shape.
   */
  private fun filterHelperMethodNames(builder: Class<*>): Set<String> {
    val helperNames =
      setOf("filters", "facetFilters", "optionalFilters", "numericFilters", "tagFilters")
    return builder.declaredMethods
      .filter { method ->
        !method.isSynthetic &&
          Modifier.isPublic(method.modifiers) &&
          method.name in helperNames &&
          method.parameterCount == 1 &&
          method.parameterTypes[0].name == "kotlin.jvm.functions.Function1"
      }
      .map { it.name }
      .toSet()
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
