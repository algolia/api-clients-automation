import { RequestFile } from './models';

export class RequestOptionsTimeouts {
  /**
   * Connection timeout in seconds.
   */
  'connect'?: number;
  /**
   * Read timeout in seconds.
   */
  'read'?: number;
  /**
   * Write timeout in seconds.
   */
  'write'?: number;

  static discriminator: string | undefined = undefined;

  static attributeTypeMap: Array<{ name: string; baseName: string; type: string }> = [
    {
      name: 'connect',
      baseName: 'connect',
      type: 'number',
    },
    {
      name: 'read',
      baseName: 'read',
      type: 'number',
    },
    {
      name: 'write',
      baseName: 'write',
      type: 'number',
    },
  ];

  static getAttributeTypeMap() {
    return RequestOptionsTimeouts.attributeTypeMap;
  }
}
