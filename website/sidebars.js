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
          items: ['CLI/specs-commands', 'CLI/clients-commands', 'CLI/release-commands', 'CLI/cts-commands'],
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
