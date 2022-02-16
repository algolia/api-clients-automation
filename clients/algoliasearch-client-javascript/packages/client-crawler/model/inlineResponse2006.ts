import type { Config } from './config';

export type InlineResponse2006 = {
  version: number;
  config: Config;
  createdAt: string;
  authorId?: string;
};
