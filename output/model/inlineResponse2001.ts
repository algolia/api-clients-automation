import { RequestFile } from './models';

export class InlineResponse2001 {
  'taskID'?: number;
  'objectIDs'?: Array<string>;

  static discriminator: string | undefined = undefined;

  static attributeTypeMap: Array<{ name: string; baseName: string; type: string }> = [
    {
      name: 'taskID',
      baseName: 'taskID',
      type: 'number',
    },
    {
      name: 'objectIDs',
      baseName: 'objectIDs',
      type: 'Array<string>',
    },
  ];

  static getAttributeTypeMap() {
    return InlineResponse2001.attributeTypeMap;
  }
}
