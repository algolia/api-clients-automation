import { RequestFile } from './models';

export class SingleQueryResponseHits {
  /**
   * Unique identifier of the object
   */
  'objectID'?: string;

  static discriminator: string | undefined = undefined;

  static attributeTypeMap: Array<{ name: string; baseName: string; type: string }> = [
    {
      name: 'objectID',
      baseName: 'objectID',
      type: 'string',
    },
  ];

  static getAttributeTypeMap() {
    return SingleQueryResponseHits.attributeTypeMap;
  }
}
