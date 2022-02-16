import path from 'path';

import babel from '@rollup/plugin-babel';
import { nodeResolve } from '@rollup/plugin-node-resolve';
import filesize from 'rollup-plugin-filesize';
import globals from 'rollup-plugin-node-globals';
import { terser } from 'rollup-plugin-terser';
import ts from 'rollup-plugin-typescript2';

import { version } from './version';

// Retrieve package to build
const client = process.env.CLIENT?.replace('@algolia/', '');
const onlyBuildUtils = Boolean(process.env.BUILD_UTILS);

function createLicence(name) {
  return `/*! ${name}.umd.js | ${version} | © Algolia, inc. | https://github.com/algolia/algoliasearch-client-javascript */`;
}

function createBundlers({ output, clientPath }) {
  return {
    'esm-node': {
      file: `${clientPath}/dist/${output}.esm.node.js`,
      format: 'es',
    },
    'esm-browser': {
      file: `${clientPath}/dist/${output}.esm.browser.js`,
      format: 'es',
    },
    'umd-browser': {
      file: `${clientPath}/dist/${output}.umd.browser.js`,
      format: 'umd',
    },
    'cjs-node': {
      file: `${clientPath}/dist/${output}.cjs.node.js`,
      format: 'cjs',
    },
    'cjs-browser': {
      file: `${clientPath}/dist/${output}.cjs.browser.js`,
      format: 'cjs',
    },
  };
}

function initPackagesConfig() {
  if (onlyBuildUtils) {
    const commonOptions = {
      input: 'index.ts',
      formats: ['cjs-node', 'esm-node'],
      external: [],
      dependencies: [],
    };

    return [
      // Common
      {
        ...commonOptions,
        output: 'client-common',
        package: 'client-common',
        name: '@algolia/client-common',
      },
      // Browser requester
      {
        ...commonOptions,
        output: 'requester-browser-xhr',
        package: 'requester-browser-xhr',
        name: '@algolia/requester-browser-xhr',
        external: ['dom'],
        dependencies: ['@algolia/client-common'],
      },
      // Node requester
      {
        ...commonOptions,
        output: 'requester-node-http',
        package: 'requester-node-http',
        name: '@algolia/requester-node-http',
        external: ['https', 'http', 'url'],
        dependencies: ['@algolia/client-common'],
      },
    ];
  }

  const availableClients = [
    // We don't have the `algoliasearch` package for now.
    // 'algoliasearch'
    'client-abtesting',
    'client-analytics',
    'client-insights',
    'client-personalization',
    'client-query-suggestions',
    'client-search',
    'client-sources',
    'client-predict',
    'recommend',
  ].filter((availableClient) =>
    client === 'all' ? true : availableClient === client
  );

  if (availableClients.length === 0) {
    throw new Error(`No clients matching ${client}.`);
  }

  return availableClients.flatMap((packageName) => {
    const commonConfig = {
      package: packageName,
      name: `@algolia/${packageName}`,
      output: packageName,
      dependencies: [
        '@algolia/client-common',
        '@algolia/requester-browser-xhr',
        '@algolia/requester-node-http',
      ],
      external: [],
    };
    const browserFormats = ['umd-browser', 'esm-browser', 'cjs-browser'];
    const nodeFormats = ['cjs-node', 'esm-node'];

    return [
      {
        ...commonConfig,
        input: 'builds/browser.ts',
        formats: browserFormats,
        external: ['dom'],
        globals: {
          [packageName]: packageName,
        },
      },
      {
        ...commonConfig,
        input: 'builds/node.ts',
        formats: nodeFormats,
      },
    ];
  });
}

const packagesConfig = initPackagesConfig();
const rollupConfig = [];

packagesConfig.forEach((packageConfig) => {
  const clientPath = path.resolve('packages', packageConfig.package);
  const bundlers = createBundlers({
    output: packageConfig.output,
    clientPath,
  });

  packageConfig.formats.forEach((format) => {
    // Avoid generating types multiple times.
    let isTypesGenerated = false;
    const output = bundlers[format];
    const isUmdBuild = format === 'umd-browser';
    const isEsmBrowserBuild = format === 'esm-browser';

    if (isUmdBuild) {
      output.name = packageConfig.name;
      output.banner = createLicence(packageConfig.package);
    }

    const externalRuntime = isUmdBuild ? [/@babel\/runtime/] : [];
    const compressorPlugins = isUmdBuild ? [terser()] : [];
    const transpilerPlugins = isUmdBuild
      ? [
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
                    browsers: ['last 2 versions', 'ie >= 11'],
                  },
                },
              ],
            ],
            plugins: ['@babel/plugin-transform-runtime'],
          }),
        ]
      : [];

    if (isUmdBuild || isEsmBrowserBuild) {
      // eslint-disable-next-line no-param-reassign
      packageConfig.dependencies = [];
    }

    rollupConfig.push({
      input: path.resolve(clientPath, packageConfig.input),
      external: [
        ...packageConfig.dependencies,
        ...packageConfig.external,
        ...externalRuntime,
      ],
      plugins: [
        globals({
          global: true,
        }),
        nodeResolve(),
        ts({
          check: !isTypesGenerated,
          tsconfig: path.resolve(clientPath, 'tsconfig.json'),
          tsconfigOverride: {
            compilerOptions: {
              declaration: !isTypesGenerated,
              declarationMap: !isTypesGenerated,
            },
          },
        }),
        ...transpilerPlugins,
        ...compressorPlugins,
        filesize({
          showMinifiedSize: false,
          showGzippedSize: true,
        }),
      ],
      output,
      onwarn(msg, warn) {
        if (!/Circular/.test(msg)) {
          warn(msg);
        }
      },
    });

    isTypesGenerated = true;
  });
});

export default rollupConfig;
