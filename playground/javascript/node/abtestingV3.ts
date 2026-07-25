import type { ABTestSettingsResponse, Region } from '@algolia/abtesting';
import { abtestingV3Client } from '@algolia/abtesting';
import { ApiError, RetryError } from '@algolia/client-common';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const adminKey = process.env.ALGOLIA_ADMIN_KEY || '**** ADMIN_API_KEY *****';
const region = (process.env.ALGOLIA_ABTESTING_REGION || 'de') as Region;

const abTestId = Number(process.env.ABTEST_ID || 0);
const variantId = Number(process.env.ABTEST_VARIANT_ID || 2);
const saveFeaturesSettings = process.env.ABTEST_SAVE_FEATURE_SETTINGS === 'true';

const client = abtestingV3Client(appId, adminKey, region);

function printSettings(label: string, response: ABTestSettingsResponse): void {
  console.log(label, JSON.stringify(response, null, 2));
}

async function getSettings(): Promise<void> {
  printSettings('getABTestSettings', await client.getABTestSettings({ id: abTestId }));
}

async function saveSettings(): Promise<void> {
  await client.saveVariantSettings({
    id: abTestId,
    variantId,
    saveSettingsRequest: { saveFeaturesSettings },
  });
  console.log(`saved settings for variant ${variantId}`);
}

async function applySettings(variantIdToApply = variantId): Promise<void> {
  await client.applyVariantSettings({ id: abTestId, variantId: variantIdToApply });
  console.log(`applied settings for variant ${variantIdToApply}`);
}

async function lifecycle(): Promise<void> {
  try {
    await client.getABTestSettings({ id: abTestId });
    throw new Error('settings were already captured for this A/B test');
  } catch (error) {
    if (!(error instanceof ApiError) || error.status !== 404) {
      throw error;
    }

    console.log('settings are not captured yet');
  }

  await saveSettings();
  printSettings('after capture', await client.getABTestSettings({ id: abTestId }));

  await applySettings();
  printSettings('after apply', await client.getABTestSettings({ id: abTestId }));

  await applySettings(1);
  printSettings('after revert', await client.getABTestSettings({ id: abTestId }));
}

const scenarios: Record<string, () => Promise<void>> = {
  get: getSettings,
  save: saveSettings,
  apply: applySettings,
  revert: () => applySettings(1),
  lifecycle,
};

const requested = process.env.ABTEST_SCENARIO || 'get';
const scenario = scenarios[requested];

if (!abTestId) {
  console.error('set ABTEST_ID to an existing A/B test owned by this application');
  process.exit(1);
}

if (!scenario) {
  console.error(`unknown scenario '${requested}'. available: ${Object.keys(scenarios).join(', ')}`);
  process.exit(1);
}

console.log(
  `running '${requested}' against ${appId} (${region}), abTestId=${abTestId}, ` +
    `variantId=${variantId}, saveFeaturesSettings=${saveFeaturesSettings}`,
);

scenario().catch((error: unknown) => {
  if (error instanceof ApiError) {
    console.error(`[${error.status}] ${error.message}`, error.stackTrace);
  } else if (error instanceof RetryError) {
    console.error(error.message, error.stackTrace);
  } else {
    console.error(error);
  }

  process.exitCode = 1;
});
