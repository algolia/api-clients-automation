import { RequestFile } from './models';

export class InlineResponse200 {
  'taskID'?: number;
  'objectID'?: string;

  static discriminator: string | undefined = undefined;

  static attributeTypeMap: Array<{ name: string; baseName: string; type: string }> = [
    {
      name: 'taskID',
      baseName: 'taskID',
      type: 'number',
    },
    {
      name: 'objectID',
      baseName: 'objectID',
      type: 'string',
    },
  ];

  static getAttributeTypeMap() {
    return InlineResponse200.attributeTypeMap;
  }
}
