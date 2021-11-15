import { RequestFile } from './models';

export class RequestOptionsHeaders {
  'xAlgoliaUserToken'?: string;
  'xForwardedFor'?: string;

  static discriminator: string | undefined = undefined;

  static attributeTypeMap: Array<{ name: string; baseName: string; type: string }> = [
    {
      name: 'xAlgoliaUserToken',
      baseName: 'X-Algolia-UserToken',
      type: 'string',
    },
    {
      name: 'xForwardedFor',
      baseName: 'X-Forwarded-For',
      type: 'string',
    },
  ];

  static getAttributeTypeMap() {
    return RequestOptionsHeaders.attributeTypeMap;
  }
}
