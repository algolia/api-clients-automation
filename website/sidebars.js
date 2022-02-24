// @ts-check

/** @type {import('@docusaurus/plugin-content-docs').SidebarsConfig} */
const sidebars = {
  docs: [
    {
      type: 'category',
      label: 'Getting Started',
      items: ['introduction', 'setupRepository'],
    },
    {
      type: 'category',
      label: 'Contributing',
      items: ['addNewClient', 'addNewLanguage'],
    },
    {
      type: 'category',
      label: 'Testing',
      items: ['CTS', 'playground'],
    },
  ],
};

// eslint-disable-next-line import/no-commonjs
module.exports = sidebars;
