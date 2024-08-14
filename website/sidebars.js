// @ts-check

/** @type {import('@docusaurus/plugin-content-docs').SidebarsConfig} */
const sidebars = {
  // Everything related to the API Clients Automation
  automation: [
    'contributing/introduction',
    {
      type: 'category',
      label: 'Getting Started',
      collapsed: false,
      items: [
        'contributing/setup-repository',
        {
          type: 'category',
          label: 'CLI',
          collapsed: false,
          items: [
            'contributing/CLI/specs-commands',
            'contributing/CLI/clients-commands',
            'contributing/CLI/release-commands',
            'contributing/CLI/cts-commands',
          ],
        },
      ],
    },
    {
      type: 'category',
      label: 'Contributing',
      collapsed: false,
      items: [
        'contributing/add-new-api-client',
        'contributing/docs',
        'contributing/add-new-language',
        {
          type: 'category',
          label: 'Testing',
          collapsed: false,
          items: [
            'contributing/testing/common-test-suite',
            'contributing/testing/playground',
          ],
        },
        'contributing/commit-and-pull-request',
        'contributing/release-process',
        {
          type: 'category',
          label: 'CI',
          collapsed: false,
          items: ['contributing/CI/overview'],
        },
      ],
    },
  ],
};

// eslint-disable-next-line import/no-commonjs
module.exports = sidebars;
