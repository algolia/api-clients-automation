export type Test = {
  testName: string;
  autoCreateClient?: boolean; // `true` by default
  steps: Step[];
};

type Step = CreateClientStep | VariableStep | MethodStep;

type CreateClientStep = {
  type: 'createClient';
  parameters: {
    appId: string;
    apiKey: string;
  };
  expected?: Expected;
};

type VariableStep = {
  type: 'variable';
  object: string;
  path: string[];
  expected?: Expected;
};

type MethodStep = {
  type: 'method';
  object: string;
  path: string[];
  parameters?: any;
  expected?: Expected;
};

type Expected = {
  length?: number;
  error?: string | false;
  match?: { objectContaining: object } | any;
};

export type TestsBlock = {
  operationId: string;
  tests: Test[];
};

type AllTests = {
  [client: string]: TestsBlock[];
};
