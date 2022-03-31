export type BaseCreateMatrix = {
  baseChanged: boolean;
  baseBranch: string;
};

export type Client = {
  name: string;
  folder: string;
  config?: string;
  api?: string;
  capitalizedApi?: string;
};

export type Matrix<TMatrix> = {
  client: TMatrix[];
};
