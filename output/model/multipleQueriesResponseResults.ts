import { RequestFile } from './models';
import { Record } from './record';

export class MultipleQueriesResponseResults {
  'hits'?: Array<Record>;
  'nbHits'?: number;
  'queryID'?: string;

  static discriminator: string | undefined = undefined;

  static attributeTypeMap: Array<{ name: string; baseName: string; type: string }> = [
    {
      name: 'hits',
      baseName: 'hits',
      type: 'Array<Record>',
    },
    {
      name: 'nbHits',
      baseName: 'nbHits',
      type: 'number',
    },
    {
      name: 'queryID',
      baseName: 'queryID',
      type: 'string',
    },
  ];

  static getAttributeTypeMap() {
    return MultipleQueriesResponseResults.attributeTypeMap;
  }
}
