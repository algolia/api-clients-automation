import { searchApi } from '@algolia/client-search/dist/search.umd';

import './app.css';

const searchClient = searchApi(
  'QPBQ67WNIG',
  '5cdfc89a2f7b8cfc6a5ffe9c922479fa'
);

const searchButton = document.querySelector('#search');

searchButton?.addEventListener('click', async () => {
  const results = await searchClient.search({
    indexName: 'docsearch',
    searchParams: {
      query: 'docsearch',
    },
  });

  const parent = document.querySelector('#results');

  results.hits?.forEach(({ objectID }) => {
    const children = document.createElement('p');
    children.innerHTML = objectID;

    parent?.appendChild(children);
  });
});
