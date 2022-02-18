import type { Config } from './config';

export type InlineResponse2003 = {
  version: number;
  config: Config;
  createdAt: string;
  authorId?: string;
};
