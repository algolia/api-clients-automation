/** @type {import('@docusaurus/types').Config} */
(
  module.exports = {
    title: 'Algolia API clients automation',
    tagline: 'Documentation for the API clients automation repository',
    url: 'https://api-clients-automation.netlify.app/',
    baseUrl: '/',
    favicon: 'img/logo-small.svg',
    organizationName: 'Algolia',
    projectName: 'Algolia API clients automation',
    onBrokenLinks: 'throw',

    presets: [
      [
        '@docusaurus/preset-classic',
        /** @type {import('@docusaurus/preset-classic').Options} */
        ({
          docs: {
            path: 'docs',
            sidebarPath: 'sidebars.js',
            editUrl: 'https://github.com/algolia/api-clients-automation/edit/main/website/',
            showLastUpdateAuthor: true,
            showLastUpdateTime: true,
          },
          blog: false,
          theme: {
            customCss: require.resolve('./src/css/custom.css'),
          },
        }),
      ],
    ],

    themeConfig:
      /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
      ({
        navbar: {
          title: 'Algolia API clients Automation',
          logo: {
            alt: 'Algolia',
            src: 'img/logo-small.svg',
            srcDark: 'img/logo-small.svg',
          },
          items: [
            {
              label: 'Contributing',
              to: 'docs/introduction',
              position: 'left',
            },
            {
              label: 'Algolia API clients documentation',
              href: 'https://www.algolia.com/doc/',
              position: 'right',
            },
            {
              href: 'https://github.com/algolia/api-clients-automation',
              position: 'right',
              className: 'header-github-link',
            },
          ],
        },
        algolia: {
          appId: 'QPBQ67WNIG',
          apiKey: 'b590ae1153bf574215ca1605c19eb1fe',
          indexName: 'api-clients-automation',
        },
        colorMode: {
          defaultMode: 'light',
          disableSwitch: false,
          respectPrefersColorScheme: true,
        },
        footer: {
          style: 'dark',
          links: [
            {
              label: 'GitHub',
              to: 'https://github.com/algolia/api-clients-automation',
            },
            {
              label: 'Twitter',
              to: 'https://twitter.com/algolia',
            },
            {
              label: 'Algolia Website',
              to: 'https://algolia.com/',
            },
            {
              label: 'Algolia Documentation',
              to: 'https://algolia.com/doc',
            },
            {
              label: 'Algolia Blog',
              to: 'https://algolia.com/blog',
            },
          ],
          copyright: `Copyright © ${new Date().getFullYear()} Algolia | Built with Docusaurus.`,
        },
      }),
    markdown: {
      hooks: {
        onBrokenMarkdownLinks: 'throw',
        onBrokenMarkdownImages: 'throw',
      },
    },
  }
);
