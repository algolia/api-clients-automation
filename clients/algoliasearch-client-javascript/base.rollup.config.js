import babel from '@rollup/plugin-babel';
import { nodeResolve } from '@rollup/plugin-node-resolve';
import globals from 'rollup-plugin-node-globals';
import { terser } from 'rollup-plugin-terser';
import ts from 'rollup-plugin-typescript2';

// Org where the packages are pushed
const NPM_ORG = '@algolia/';

// Output formats
const BROWSER_FORMATS = ['esm-browser', 'umd'];
const NODE_FORMATS = ['esm-node', 'cjs'];

// Utils package with default options
const UTILS = {
  'client-common': {
    external: [],
    plugins: [
      babel({
        babelrc: false,
        extensions: ['.ts'],
        exclude: 'node_modules/**',
        plugins: ['@babel/plugin-proposal-class-properties'],
      }),
    ],
  },
  'requester-browser-xhr': {
    external: ['dom'],
    plugins: [],
  },
  'requester-fetch': {
    external: ['dom'],
    plugins: [],
  },
  'requester-node-http': {
    external: ['https', 'http', 'url'],
    plugins: [],
  },
};

/**
 * Returns the license at the top of the UMD bundled file.
 */
function createLicense(name, version) {
  return `/*! ${name}.umd.js | ${version} | © Algolia, inc. | https://github.com/algolia/algoliasearch-client-javascript */`;
}

/**
 * Bundlers with their output format and file name for the given client.
 */
function createBundlers({ output, isLiteClient }) {
  const commonOptions = {
    exports: 'named',
  };

  const path = isLiteClient ? `./dist/lite` : `./dist`;

  return {
    'esm-node': {
      ...commonOptions,
      file: `${path}/${output}.esm.node.js`,
      format: 'es',
    },
    'esm-browser': {
      ...commonOptions,
      file: `${path}/${output}.esm.browser.js`,
      format: 'es',
    },
    umd: {
      ...commonOptions,
      file: `${path}/${output}.umd.js`,
      format: 'umd',
      esModule: false,
    },
    cjs: {
      ...commonOptions,
      file: `${path}/${output}.cjs.js`,
      format: 'cjs',
    },
  };
}

/**
 * Build configs to iterate on based on the package.json information.
 */
function getBaseConfigs(pkg) {
  const packageName = pkg.name.replace(NPM_ORG, '');
  const isUtils = UTILS[packageName] !== undefined;

  if (isUtils) {
    return [
      {
        ...UTILS[packageName],
        formats: NODE_FORMATS,
        input: 'index.ts',
        dependencies: pkg.dependencies ? Object.keys(pkg.dependencies) : [],
        package: packageName,
        name: pkg.name,
        output: packageName,
      },
    ];
  }

  const baseConfigs = [];
  const isAlgoliasearchClient = packageName === 'algoliasearch';
  const commonConfig = {
    package: packageName,
    name: pkg.name,
    output: packageName,
    dependencies: pkg.dependencies ? Object.keys(pkg.dependencies) : [],
    external: [],
    plugins: [],
  };
  const configPerEnv = {
    browser: {
      ...commonConfig,
      input: 'builds/browser.ts',
      formats: BROWSER_FORMATS,
      external: ['dom'],
      globals: {
        [packageName]: packageName,
      },
    },
    node: {
      ...commonConfig,
      input: 'builds/node.ts',
      formats: NODE_FORMATS,
    },
  };

  // This non-generated client is an aggregation of client, hence does not follow
  // the same build process.
  if (isAlgoliasearchClient) {
    const litePackageName = `${packageName}/lite`;
    baseConfigs.push(
      {
        ...commonConfig,
        ...configPerEnv.browser,
        package: litePackageName,
        name: litePackageName,
        output: 'lite',
        input: 'lite/builds/browser.ts',
        dependencies: [
          `${NPM_ORG}client-common`,
          `${NPM_ORG}requester-browser-xhr`,
        ],
        globals: {
          [litePackageName]: litePackageName,
        },
      },
      // Node build
      {
        ...commonConfig,
        ...configPerEnv.node,
        package: litePackageName,
        name: litePackageName,
        output: 'lite',
        input: 'lite/builds/node.ts',
        dependencies: [
          `${NPM_ORG}client-common`,
          `${NPM_ORG}requester-node-http`,
        ],
      }
    );
  }

  return [...baseConfigs, configPerEnv.browser, configPerEnv.node];
}

export function buildConfigs(pkg) {
  const baseConfigs = getBaseConfigs(pkg);
  const rollupConfig = [];
  let checkForTypes = true;

  baseConfigs.forEach((baseConfig) => {
    const isLiteClient = baseConfig.name === 'algoliasearch/lite';
    const bundlers = createBundlers({
      output: baseConfig.output,
      isLiteClient,
    });

    baseConfig.formats.forEach((format) => {
      const isUmdBuild = format === 'umd';
      const isEsmBrowserBuild = format === 'esm-browser';
      const umdConfig = {
        compressorPlugins: [],
        transpilerPlugins: [],
      };

      if (isUmdBuild || isEsmBrowserBuild) {
        // eslint-disable-next-line no-param-reassign
        baseConfig.dependencies = [];
      }

      if (isUmdBuild) {
        bundlers[format].name = baseConfig.name;
        bundlers[format].banner = createLicense(
          baseConfig.package,
          pkg.version
        );

        umdConfig.compressorPlugins = [terser()];
        umdConfig.transpilerPlugins = [
          babel({
            babelrc: false,
            babelHelpers: 'runtime',
            extensions: ['.ts'],
            exclude: 'node_modules/**',
            presets: [
              [
                '@babel/preset-env',
                {
                  targets: {
                    browsers: ['> .5%', 'ie >= 11'],
                  },
                },
              ],
            ],
            plugins: ['@babel/plugin-transform-runtime'],
          }),
        ];
      }

      rollupConfig.push({
        input: baseConfig.input,
        external: [...baseConfig.dependencies, ...baseConfig.external],
        plugins: [
          globals({
            global: true,
          }),
          nodeResolve(),
          ts({
            check: checkForTypes,
            tsconfig: 'tsconfig.json',
            tsconfigOverride: {
              compilerOptions: {
                declaration: checkForTypes,
                declarationMap: checkForTypes,
                noEmit: !checkForTypes,
              },
            },
          }),
          ...umdConfig.transpilerPlugins,
          ...umdConfig.compressorPlugins,
          ...baseConfig.plugins,
        ],
        output: bundlers[format],
        onwarn(msg, warn) {
          if (!/Circular/.test(msg)) {
            warn(msg);
          }
        },
      });

      checkForTypes = false;
    });
  });

  return rollupConfig;
}
