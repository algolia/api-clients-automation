export default {
  header: '## Summary',
  summary:
    'This PR has been created using the `apic release` script. Once merged, the clients will try to release their new version if their version has changed.',

  versionChangeHeader: '## Version Changes',
  skippedCommitsHeader: '### Skipped Commits',
  skippedCommitsDesc:
    "It doesn't mean these commits are being excluded from the release. It means they're not taken into account when the release process figured out the next version number, and updated the changelog.",
};
