import { algoliasearch } from 'algoliasearch';

const APP_ID = requireEnv('ALGOLIA_APPLICATION_ID');
const ADMIN_KEY = requireEnv('ALGOLIA_ADMIN_KEY');
const INDEX = process.env.QC_INDEX ?? 'cts_e2e_query_categorization';

const RECORDS_PER_QUERY = 12;

type CategoryGroup = { lvl1: string; lvl2: string; queries: string[] };

export const CATEGORY_QUERIES: CategoryGroup[] = [
  {
    lvl1: 'Living Room',
    lvl2: 'Sofas',
    queries: [
      'sofa',
      'couch',
      'loveseat',
      'sectional',
      'sleeper sofa',
      'reclining sofa',
      'leather sofa',
      'velvet sofa',
    ],
  },
  {
    lvl1: 'Living Room',
    lvl2: 'Chairs',
    queries: [
      'armchair',
      'accent chair',
      'rocking chair',
      'club chair',
      'wingback chair',
      'swivel chair',
      'papasan chair',
    ],
  },
  {
    lvl1: 'Living Room',
    lvl2: 'Lamps',
    queries: ['lamp', 'floor lamp', 'table lamp', 'reading lamp', 'arc lamp', 'tripod lamp'],
  },
  {
    lvl1: 'Living Room',
    lvl2: 'Tables',
    queries: ['coffee table', 'side table', 'console table', 'end table', 'accent table'],
  },
  {
    lvl1: 'Living Room',
    lvl2: 'Storage',
    queries: ['bookshelf', 'tv stand', 'media console', 'display cabinet', 'bookcase'],
  },
  {
    lvl1: 'Dining Room',
    lvl2: 'Tables',
    queries: ['dining table', 'kitchen table', 'pub table', 'round table', 'extending table'],
  },
  {
    lvl1: 'Dining Room',
    lvl2: 'Chairs',
    queries: ['dining chair', 'bar stool', 'counter stool', 'dining bench', 'banquette'],
  },
  { lvl1: 'Dining Room', lvl2: 'Storage', queries: ['buffet', 'sideboard', 'china cabinet', 'hutch', 'wine cabinet'] },
  {
    lvl1: 'Office',
    lvl2: 'Desks',
    queries: [
      'desk',
      'standing desk',
      'writing desk',
      'executive desk',
      'computer desk',
      'corner desk',
      'secretary desk',
    ],
  },
  {
    lvl1: 'Office',
    lvl2: 'Chairs',
    queries: ['office chair', 'ergonomic chair', 'task chair', 'drafting chair', 'mesh chair'],
  },
  { lvl1: 'Office', lvl2: 'Storage', queries: ['filing cabinet', 'credenza', 'office shelf', 'lateral file'] },
  {
    lvl1: 'Bedroom',
    lvl2: 'Beds',
    queries: ['bed frame', 'platform bed', 'canopy bed', 'daybed', 'bunk bed', 'king bed', 'queen bed', 'storage bed'],
  },
  {
    lvl1: 'Bedroom',
    lvl2: 'Storage',
    queries: ['dresser', 'nightstand', 'wardrobe', 'armoire', 'chest of drawers', 'bedroom bench'],
  },
  { lvl1: 'Bedroom', lvl2: 'Accessories', queries: ['mattress', 'headboard', 'vanity', 'jewelry box', 'hope chest'] },
  {
    lvl1: 'Outdoor',
    lvl2: 'Seating',
    queries: ['patio chair', 'outdoor sofa', 'lounge chair', 'hammock', 'adirondack chair', 'porch swing'],
  },
  { lvl1: 'Outdoor', lvl2: 'Tables', queries: ['patio table', 'outdoor dining table', 'garden table', 'bistro table'] },
  { lvl1: 'Outdoor', lvl2: 'Accessories', queries: ['fire pit', 'patio umbrella', 'outdoor bench'] },
  { lvl1: 'Kids Room', lvl2: 'Beds', queries: ['toddler bed', 'kids bed', 'crib', 'trundle bed'] },
  {
    lvl1: 'Kids Room',
    lvl2: 'Furniture',
    queries: ['kids desk', 'play table', 'toy chest', 'kids chair', 'changing table'],
  },
];

export const QUERIES: string[] = CATEGORY_QUERIES.flatMap((g) => g.queries);

function requireEnv(name: string): string {
  const v = process.env[name];
  if (!v) throw new Error(`missing required env var ${name}`);
  return v;
}

function buildRecords(): Array<Record<string, unknown>> {
  const records: Array<Record<string, unknown>> = [];
  for (const { lvl1, lvl2, queries } of CATEGORY_QUERIES) {
    for (const query of queries) {
      const objectIDBase = query.replace(/ /g, '_');
      const title = query.replace(/\b\w/g, (c) => c.toUpperCase());
      for (let i = 0; i < RECORDS_PER_QUERY; i++) {
        records.push({
          objectID: `${objectIDBase}-${i}`,
          title: `${title} model ${i}`,
          price: 50 + ((i * 17) % 400),
          hierarchicalCategories: {
            lvl0: 'Furniture',
            lvl1: `Furniture > ${lvl1}`,
            lvl2: `Furniture > ${lvl1} > ${lvl2}`,
          },
        });
      }
    }
  }
  return records;
}

export async function setupIndex(): Promise<void> {
  const records = buildRecords();
  const client = algoliasearch(APP_ID, ADMIN_KEY);

  await client.clearObjects({ indexName: INDEX });
  await client.saveObjects({ indexName: INDEX, objects: records, waitForTasks: true });
  await client.setSettings({
    indexName: INDEX,
    indexSettings: {
      searchableAttributes: ['title'],
      attributesForFaceting: [
        'hierarchicalCategories.lvl0',
        'hierarchicalCategories.lvl1',
        'hierarchicalCategories.lvl2',
      ],
    },
  });

  console.log(
    `Populated '${INDEX}' with ${records.length} records across ${QUERIES.length} unique queries and configured facets.`,
  );
}

if (import.meta.url.endsWith(process.argv[1])) {
  await setupIndex();
}
