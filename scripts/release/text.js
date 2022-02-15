// eslint-disable-next-line import/no-commonjs
module.exports = {
  header: `## Summary`,

  versionChangeHeader: `## Version Changes`,
  noCommit: `no commit`,
  currentVersionNotFound: `current version not found`,
  descriptionForSkippedLang: (langName) =>
    [
      `  - No \`feat\` or \`fix\` commit, thus unchecked by default.`,
      `  - **Checked** → Update version, update ${langName} repository, and release the library.`,
      `  - **Unchecked** → Update ${langName} repository.`,
      `  - **Line removed** → Do nothing.`,
    ].join('\n'),

  changelogHeader: `## CHANGELOG`,
  changelogDescription: `Update the following lines. Once merged, it will be reflected to \`docs/changelogs/*.\``,

  approvalHeader: `## Approval`,
  approved: `Approved`,
  approval: [
    `To proceed this release, check the box below and close the issue.`,
    `To skip this release, just close the issue.`,
    `- [ ] ${this.approved}`,
  ].join('\n'),

  commitMessage: `chore: update versions and changelogs`,
};
