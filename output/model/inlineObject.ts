import { RequestFile } from './models';
import { RequestOptions } from './requestOptions';
import { SearchParams } from './searchParams';

export class InlineObject {
  /**
   * The text to search in the index.
   */
  'query'?: string;
  'searchParameters'?: SearchParams;
  '_requestOptions'?: RequestOptions;

  static discriminator: string | undefined = undefined;

  static attributeTypeMap: Array<{ name: string; baseName: string; type: string }> = [
    {
      name: 'query',
      baseName: 'query',
      type: 'string',
    },
    {
      name: 'searchParameters',
      baseName: 'searchParameters',
      type: 'SearchParams',
    },
    {
      name: '_requestOptions',
      baseName: 'requestOptions',
      type: 'RequestOptions',
    },
  ];

  static getAttributeTypeMap() {
    return InlineObject.attributeTypeMap;
  }
}
