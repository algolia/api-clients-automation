export type Host = {
  url: string;
  accept: 'read' | 'readWrite' | 'write';
  protocol: 'http' | 'https';
};
