// @ts-check

/** @type {import('@docusaurus/plugin-content-docs').SidebarsConfig} */
const sidebars = {
  // Everything related to the API Clients Automation
  automation: [
    'introduction',
    {
      type: 'category',
      label: 'Getting Started',
      collapsed: false,
      items: [
        'setup-repository',
        {
          type: 'category',
          label: 'CLI',
          collapsed: false,
          items: ['CLI/generate-commands', 'CLI/build-commands', 'CLI/cts-commands', 'CLI/release-commands'],
        },
      ],
    },
    {
      type: 'category',
      label: 'Contributing',
      collapsed: false,
      items: [
        'add-new-api-client',
        'docs',
        'add-new-language',
        {
          type: 'category',
          label: 'Testing',
          collapsed: false,
          items: ['testing/common-test-suite', 'testing/playground'],
        },
        'commit-and-pull-request',
        'release-process',
        {
          type: 'category',
          label: 'CI',
          collapsed: false,
          items: ['CI/overview'],
        },
      ],
    },
  ],
};

module.exports = sidebars;
