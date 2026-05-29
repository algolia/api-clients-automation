export default {
  'generators/**/*.java': () => 'yarn cli format java generators',
  '.github/**/*.yml': 'yarn eslint --fix',
  '*.json': 'yarn eslint --fix',
  'scripts/**/*.(js|ts|mjs|cjs)': () => 'yarn cli format javascript scripts',
  'specs/**/*.yml': 'yarn eslint --fix',
};
