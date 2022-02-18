import type { Config } from './config';

export type ListConfigVersionsResponse = {
  version: number;
  config: Config;
  createdAt: string;
  authorId?: string;
};
