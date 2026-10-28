# shellcheck shell=bash
# sourced by check-version-drift.sh and update-pins.sh, not executed
#
# every pinned tool download carries its metadata in one annotation comment, directly above the pin line
# (same indentation in yaml), and renovate (one regex manager in renovate.json), the drift check and the
# pin updater all read it from there:
#
#   # renovate: datasource=<github-tags|github-release-attachments> depName=<owner/repo>[ asset=<template>]
#   <NAME>=<tag>@<digest>          (Dockerfile ARG line)   or   <NAME>: <tag>@<digest>   (action.yml env line)
#
# the annotation has exactly this shape, keys in this order and nothing else on the line, because that is all the
# renovate regex matches; anything else is reported as an invalid annotation.
# asset= is required for github-release-attachments and absent for github-tags; its placeholders are {tag}
# (e.g. v0.10.0) and {version} (the tag without the leading v). github-tags pins carry the 40 hex commit of
# the tag, github-release-attachments pins the 64 hex sha256 of the release asset.

# the files scanned for pins, one per line
pin_files() {
  printf '%s\n' scripts/docker/Dockerfile.* .github/actions/setup/action.yml
}

# one row per annotated pin occurrence: name file depName kind asset (asset is - for commits)
# kind is commit, sha256, or invalid when the annotation does not have the exact shape renovate matches
tool_pins() {
  local files
  files=$(pin_files)
  # shellcheck disable=SC2086 # the file list has no spaces
  awk '
    FNR == 1 { ann = "" }
    /^[[:space:]]*# renovate:/ { ann = $0; next }
    match($0, /[A-Z0-9_]+_PIN[A-Z0-9_]*[=:] ?v[0-9]/) {
      if (ann != "") {
        name = substr($0, RSTART, RLENGTH)
        sub(/[=:].*/, "", name)
        kind = "invalid"; dep = "-"; asset = "-"
        if (ann ~ /^[[:space:]]*# renovate: datasource=github-tags depName=[^[:space:]]+$/) kind = "commit"
        if (ann ~ /^[[:space:]]*# renovate: datasource=github-release-attachments depName=[^[:space:]]+ asset=[^[:space:]]+$/) kind = "sha256"
        if (kind != "invalid") {
          if (match(ann, /depName=[^[:space:]]+/)) dep = substr(ann, RSTART + 8, RLENGTH - 8)
          if (match(ann, /asset=[^[:space:]]+/)) asset = substr(ann, RSTART + 6, RLENGTH - 6)
        }
        print name, FILENAME, dep, kind, asset
      }
      ann = ""
      next
    }
    { ann = "" }
  ' $files
}
