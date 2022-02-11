import path from 'path';

import babel from '@rollup/plugin-babel';
import filesize from 'rollup-plugin-filesize';
import globals from 'rollup-plugin-node-globals';
import { terser } from 'rollup-plugin-terser';
import ts from 'rollup-plugin-typescript2';

import { version } from './version';

// Retrieve package to build
const client = process.env.CLIENT?.replace('@algolia/', '');
const onlyBuildUtils = Boolean(process.env.BUILD_UTILS);

function createLicence(name) {
  return `/*! ${name} | ${version} | © Algolia, inc. | https://github.com/algolia/algoliasearch-client-javascript */`;
}

function createBundlers({ output, clientPath }) {
  return {
    esm: {
      file: `${clientPath}/dist/${output}.esm.js`,
      format: 'es',
    },
    'esm-browser': {
      file: `${clientPath}/dist/${output}.esm.browser.js`,
      format: `es`,
    },
    umd: {
      file: `${clientPath}/dist/${output}.umd.js`,
      format: 'umd',
    },
  };
}

function initPackagesConfig() {
  if (onlyBuildUtils) {
    return [
      // Common
      {
        input: 'index.ts',
        output: 'client-common',
        package: 'client-common',
        name: '@algolia/client-common',
        external: ['url'],
        dependencies: [],
        formats: ['esm', 'esm-browser', 'umd'],
      },
      // Browser requester
      {
        input: 'index.ts',
        output: 'requester-browser-xhr',
        package: 'requester-browser-xhr',
        name: '@algolia/requester-browser-xhr',
        external: ['dom'],
        dependencies: ['@algolia/client-common'],
        formats: ['esm', 'esm-browser', 'umd'],
      },
      // Node requester
      {
        input: 'index.ts',
        output: 'requester-node-http',
        package: 'requester-node-http',
        name: '@algolia/requester-node-http',
        external: ['https', 'http', 'url'],
        dependencies: ['@algolia/client-common'],
        formats: ['esm', 'umd'],
      },
    ];
  }

  const packages =
    client === 'all'
      ? [
          // We don't have the `algoliasearch` package for now.
          // 'algoliasearch'
          'client-abtesting',
          'client-analytics',
          'client-insights',
          'client-personalization',
          'client-query-suggestions',
          'client-search',
          'client-sources',
          'recommend',
        ]
      : [client];

  return packages.flatMap((packageName) => {
    const commonConfig = {
      package: packageName,
      name: `@algolia/${packageName}`,
      output: packageName.replace('client-', ''),
      dependencies: [
        '@algolia/client-common',
        '@algolia/requester-browser-xhr',
        '@algolia/requester-node-http',
      ],
      external: [],
    };

    return [
      {
        ...commonConfig,
        input: 'builds/browser.ts',
        formats: ['umd'],
        external: ['dom'],
      },
      {
        ...commonConfig,
        input: 'builds/browser.ts',
        formats: ['esm-browser'],
        external: ['dom'],
      },
      {
        ...commonConfig,
        input: 'builds/node.ts',
        formats: ['esm'],
      },
    ];
  });
}

const packagesConfig = initPackagesConfig();
const rollupConfig = [];

packagesConfig.forEach((packageConfig) => {
  const clientPath = path.resolve(__dirname, 'packages', packageConfig.package);
  const bundlers = createBundlers({
    output: packageConfig.output,
    clientPath,
  });

  packageConfig.formats.forEach((format) => {
    // Avoid generating types multiple times.
    let isTypesGenerated = false;

    const output = bundlers[format];
    const isUmdBuild = format === 'umd';

    if (isUmdBuild) {
      output.name = packageConfig.name;
      output.banner = createLicence(output.file);
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
