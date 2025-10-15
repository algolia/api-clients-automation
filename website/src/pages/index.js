import { Hero as AlgoliaHero, Button, Heading1 } from '@algolia/ui-library';
import Layout from '@theme/Layout';

function Hero() {
  function Title() {
    return (
      <Heading1 className="hero-title">
        Generated API clients, by <span className="uil-color-nebula-500">Algolia</span>.
      </Heading1>
    );
  }

  return (
    <AlgoliaHero
      id="hero"
      cta={[
        <Button key="contribute" id="button" href="/docs/introduction">
          Contribute
        </Button>,
        <iframe
          src="https://ghbtns.com/github-btn.html?user=algolia&amp;repo=api-clients-automation&amp;type=star&amp;count=true&amp;size=large"
          width={160}
          height={30}
          title="GitHub Stars"
        />,
      ]}
    >
      <Title />
    </AlgoliaHero>
  );
}

export default function Home() {
  return (
    <Layout description="API Clients Automation by Algolia">
      <Hero />
    </Layout>
  );
}
