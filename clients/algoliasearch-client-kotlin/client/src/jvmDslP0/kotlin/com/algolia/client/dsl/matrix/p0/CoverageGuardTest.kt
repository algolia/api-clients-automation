package com.algolia.client.dsl.matrix.p0

import com.algolia.client.dsl.testkit.ServerContract
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

/**
 * Coverage guard for the Kotlin DSL capability matrix.
 *
 * Holds the manifest of every row id (C01–C34, X01–X19, L01–L53, D1, D2) with its owning phase and
 * the halves it must be tested in (offline under `matrix/`, live under `live/`), and checks the
 * **source text** under `src/jvmDslP*` against it. Reading sources instead of the classpath lets
 * the guard cover phases whose compilation does not succeed yet.
 *
 * Owners mirror the ID/Owner columns of the plan's capability matrix and encoder-engine tables. The
 * guard is red until every phase has its test functions and green from the top of the stack.
 */
internal class CoverageGuardTest {

  private val sourceRoot: File by lazy {
    val path =
      System.getProperty(SOURCE_ROOT_PROPERTY)
        ?: fail(
          "System property $SOURCE_ROOT_PROPERTY is not set: run the jvmDslP0Test Gradle task"
        )
    File(path).also { root ->
      assertTrue(root.isDirectory, "$SOURCE_ROOT_PROPERTY is not a directory: $root")
    }
  }

  /** 1. Every manifest id has its functions in the owner's directory, and nowhere else. */
  @Test
  fun everyManifestIdIsTestedInItsOwnersDirectoryOnly() {
    val hits = scanTestFunctions()
    val problems = MANIFEST.mapNotNull { entry ->
      val expected = entry.halves.map { Location(entry.owner, it.dir) }.toSet()
      val found = hits.filter { it.id == entry.id }
      val actual = found.map { it.location }.toSet()
      if (actual == expected) {
        null
      } else {
        val missing = expected - actual
        val misplaced = found.filter { it.location !in expected }.map { it.path }
        "${entry.id}: missing=$missing misplaced=$misplaced"
      }
    }
    assertTrue(
      problems.isEmpty(),
      "manifest ids whose test functions are missing or outside the owner's directory:\n" +
        problems.joinToString("\n"),
    )
  }

  /** 2. No id-shaped test function exists outside the manifest (typos, orphans). */
  @Test
  fun noIdShapedTestFunctionOutsideTheManifest() {
    val orphans = scanTestFunctions().filter { it.id !in MANIFEST_IDS }
    assertTrue(
      orphans.isEmpty(),
      "id-shaped test functions that are not in the manifest:\n" +
        orphans.joinToString("\n") { "${it.id} in ${it.path}" },
    )
  }

  /** 3. The server contract carries exactly the manifest's L groups and D rows, ids unique. */
  @Test
  fun serverContractRowsMatchTheManifest() {
    val rowIds = ServerContract.all.map { it.id }
    val deleteIds = ServerContract.deletes.map { it.id }
    val duplicates = (rowIds + deleteIds).groupingBy { it }.eachCount().filterValues { it > 1 }.keys
    assertTrue(duplicates.isEmpty(), "ServerContract ids are not unique: $duplicates")

    val malformed = rowIds.filterNot { CONTRACT_ROW_ID.matches(it) }
    assertTrue(malformed.isEmpty(), "ServerContract.all ids must look like L12 or L12a: $malformed")

    val groups = rowIds.map { it.take(3) }.toSet()
    val expectedGroups = L_GROUPS.toSet()
    assertEquals(
      expectedGroups,
      groups,
      "ServerContract.all L groups differ from the manifest: missing=${expectedGroups - groups} " +
        "unexpected=${groups - expectedGroups}",
    )
    assertEquals(D_ROWS, deleteIds, "ServerContract.deletes ids differ from the manifest")
  }

  /** 4. No test under `jvmDslP*` is skipped through a JUnit ignore annotation or assumption. */
  @Test
  fun noTestIsSkippedByAnnotationOrAssumption() {
    val offenders =
      phaseDirectories().flatMap { (_, dir) ->
        dir
          .walkTopDown()
          .filter { it.isFile }
          .flatMap { file ->
            val text = file.readText()
            FORBIDDEN_TOKENS.filter { it in text }.map { "${relativePath(file)}: $it" }
          }
          .toList()
      }
    assertTrue(
      offenders.isEmpty(),
      "files under jvmDslP* that skip tests:\n" + offenders.joinToString("\n"),
    )
  }

  /** 5. Temporary stub directories (P0-T12) were removed. */
  @Test
  fun noStubDirectoryUnderPhaseDirectories() {
    val stubs =
      phaseDirectories().flatMap { (_, dir) ->
        dir
          .walkTopDown()
          .filter { it.isDirectory && it.name == "stub" }
          .map { relativePath(it) }
          .toList()
      }
    assertTrue(stubs.isEmpty(), "stub directories must not be committed: $stubs")
  }

  /** 6. The build runs every phase. */
  @Test
  fun buildRunsEveryPhase() {
    assertEquals(
      "0,1,2,3",
      System.getProperty(PHASES_PROPERTY),
      "$PHASES_PROPERTY must list every phase",
    )
  }

  /** `(phase, directory)` for every `src/jvmDslP<n>`, in phase order. */
  private fun phaseDirectories(): List<Pair<Int, File>> =
    sourceRoot
      .listFiles()
      .orEmpty()
      .filter { it.isDirectory }
      .mapNotNull { dir ->
        PHASE_DIR.matchEntire(dir.name)?.let { it.groupValues[1].toInt() to dir }
      }
      .sortedBy { it.first }

  /** Every id-shaped test function declared in a `.kt` file under a phase directory. */
  private fun scanTestFunctions(): List<Hit> =
    phaseDirectories().flatMap { (phase, dir) ->
      dir
        .walkTopDown()
        .filter { it.isFile && it.extension == "kt" }
        .flatMap { file ->
          val location = Location(phase, area(file.relativeTo(dir).invariantSeparatorsPath))
          TEST_FUNCTION.findAll(file.readText()).map { match ->
            Hit(match.groupValues[1], location, relativePath(file))
          }
        }
        .toList()
    }

  private fun relativePath(file: File): String = file.relativeTo(sourceRoot).invariantSeparatorsPath

  private companion object {
    const val SOURCE_ROOT_PROPERTY = "algolia.dsl.sourceRoot"
    const val PHASES_PROPERTY = "algolia.dsl.phases"

    /** Path of the DSL package inside a phase directory. */
    const val DSL_PACKAGE_DIR = "kotlin/com/algolia/client/dsl/"

    val PHASE_DIR = Regex("""jvmDslP(\d+)""")
    val TEST_FUNCTION = Regex("""\bfun\s+([CXLD]\d{1,2})_\w*\s*\(""")
    val CONTRACT_ROW_ID = Regex("""L\d{2}[a-z]?""")

    /** Built by concatenation so that this file does not trip its own check. */
    val FORBIDDEN_TOKENS: List<String> =
      listOf("@" + "Ignore", "Ignore" + "(", "Assume" + ".", "assume" + "True", "assume" + "False")

    /** First package segment below `dsl/` (`matrix`, `live`, `samples`, `testkit`, …). */
    fun area(relativePath: String): String {
      if (!relativePath.startsWith(DSL_PACKAGE_DIR)) {
        return "(outside ${DSL_PACKAGE_DIR.removeSuffix("/")})"
      }
      val rest = relativePath.removePrefix(DSL_PACKAGE_DIR)
      return if ('/' in rest) rest.substringBefore('/') else "(package root)"
    }
  }
}

private enum class Half(val dir: String) {
  Offline("matrix"),
  Live("live"),
}

/** One manifest row: the id, the phase whose directory owns its tests, and the halves to test. */
private data class Entry(val id: String, val owner: Int, val halves: Set<Half>)

/** Phase directory and package area where an id-shaped test function was found. */
private data class Location(val phase: Int, val area: String) {
  override fun toString(): String = "jvmDslP$phase/$area"
}

private data class Hit(val id: String, val location: Location, val path: String)

/** Capability rows: ID → Owner, per the plan's capability matrix. */
private val C_OWNERS: Map<String, Int> =
  mapOf(
    "C01" to 0,
    "C02" to 1,
    "C03" to 2,
    "C04" to 0,
    "C05" to 0,
    "C06" to 1,
    "C07" to 1,
    "C08" to 2,
    "C09" to 3,
    "C10" to 3,
    "C11" to 3,
    "C12" to 3,
    "C13" to 3,
    "C14" to 3,
    "C15" to 1,
    "C16" to 1,
    "C17" to 1,
    "C18" to 3,
    "C19" to 1,
    "C20" to 0,
    "C21" to 1,
    "C22" to 0,
    "C23" to 1,
    "C24" to 1,
    "C25" to 2,
    "C26" to 2,
    "C27" to 2,
    "C28" to 2,
    "C29" to 2,
    "C30" to 2,
    "C31" to 1,
    "C32" to 0,
    "C33" to 1,
    "C34" to 0,
  )

/** Encoder ↔ engine rows: ID → Owner, per the plan's cross-check table. */
private val X_OWNERS: Map<String, Int> =
  mapOf(
    "X01" to 1,
    "X02" to 1,
    "X03" to 0,
    "X04" to 1,
    "X05" to 1,
    "X06" to 1,
    "X07" to 0,
    "X08" to 0,
    "X09" to 1,
    "X10" to 1,
    "X11" to 1,
    "X12" to 1,
    "X13" to 1,
    "X14" to 1,
    "X15" to 1,
    "X16" to 1,
    "X17" to 0,
    "X18" to 1,
    "X19" to 1,
  )

/** Rows with no live half: C04 is inline JSON only, X19 asserts the encoder throws. */
private val OFFLINE_ONLY: Set<String> = setOf("C04", "X19")

/** Server-contract groups, live only, phase 0. */
private val L_GROUPS: List<String> = (1..53).map { "L" + it.toString().padStart(2, '0') }

private val D_ROWS: List<String> = listOf("D1", "D2")

private val MANIFEST: List<Entry> =
  (C_OWNERS + X_OWNERS).map { (id, owner) ->
    val halves = if (id in OFFLINE_ONLY) setOf(Half.Offline) else setOf(Half.Offline, Half.Live)
    Entry(id, owner, halves)
  } + (L_GROUPS + D_ROWS).map { Entry(it, 0, setOf(Half.Live)) }

private val MANIFEST_IDS: Set<String> = MANIFEST.map { it.id }.toSet()
