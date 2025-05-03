export default {
  "generators/**/*.java": () => "yarn cli format java generators",
  ".github/**/*.yml": "yarn github-actions:lint --fix",
  "*.json": "yarn fix:json",
  "scripts/**/*.(js|ts|mjs|cjs)": () => "yarn cli format javascript scripts",
  "specs/**/*.yml": "yarn eslint --ext=yml --fix"
}
