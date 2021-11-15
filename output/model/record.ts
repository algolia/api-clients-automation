import { RequestFile } from './models';

/**
 * A single record
 */
export class Record extends null<String, object> {
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
    return super.getAttributeTypeMap().concat(Record.attributeTypeMap);
  }
}
