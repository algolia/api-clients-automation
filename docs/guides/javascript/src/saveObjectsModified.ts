import { algoliasearch } from 'algoliasearch';

try {
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // @ts-ignore
  const { default: products } = await import('./products.json');

  const records = products.map((product) => {
    const reference = product['product_reference'];
    const suffixes: string[] = [];

    for (let i = reference.length; i > 1; i--) {
      suffixes.unshift(reference.slice(i));
    }
    return { ...product, product_reference_suffixes: suffixes };
  });

  await client.saveObjects({ indexName: 'indexName', objects: records });
} catch (e) {
  console.error(e);
}
