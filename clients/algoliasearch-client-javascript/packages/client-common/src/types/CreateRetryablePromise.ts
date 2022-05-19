export type CreateRetryablePromiseOptions<TResponse> = {
  func: () => Promise<TResponse>;
  validate: (response: TResponse) => boolean;
  maxTrial?: number;
  timeout?: (retryCount: number) => number;
};
