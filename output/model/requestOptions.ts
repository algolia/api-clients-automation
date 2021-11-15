import { RequestFile } from './models';
import { RequestOptionsHeaders } from './requestOptionsHeaders';
import { RequestOptionsTimeouts } from './requestOptionsTimeouts';

export class RequestOptions {
  'headers'?: RequestOptionsHeaders;
  'timeouts'?: RequestOptionsTimeouts;

  static discriminator: string | undefined = undefined;

  static attributeTypeMap: Array<{ name: string; baseName: string; type: string }> = [
    {
      name: 'headers',
      baseName: 'headers',
      type: 'RequestOptionsHeaders',
    },
    {
      name: 'timeouts',
      baseName: 'timeouts',
      type: 'RequestOptionsTimeouts',
    },
  ];

  static getAttributeTypeMap() {
    return RequestOptions.attributeTypeMap;
  }
}
