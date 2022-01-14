import { generateTests } from './generate';
import { parseCLI } from '../utils';

async function main() {
  const { lang, client } = parseCLI(process.argv, 'generate:client');
  /* eslint-disable-next-line no-console */
  console.log(`Generating CTS > generate:client for ${lang}-${client}`);

  try {
    await generateTests(lang, client);
  } catch (e) {
    if (e instanceof Error) {
      console.error(e);
    }
  }
}

main();
