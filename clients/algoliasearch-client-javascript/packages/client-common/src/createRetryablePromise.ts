export function createRetryablePromise<TResponse>({
  func,
  validate,
  maxTrial = 10,
  timeout = (retryCount: number): number => Math.min(retryCount * 10, 1000),
}: {
  func: () => Promise<TResponse>;
  validate: (response: TResponse) => boolean;
  maxTrial?: number;
  timeout?: (retryCount: number) => number;
}): Promise<TResponse> {
  let retryCount = 0;
  const retry = (): Promise<TResponse> => {
    return new Promise<TResponse>((resolve, reject) => {
      func()
        .then((response) => {
          const isValid = validate(response);
          if (isValid) {
            resolve(response);
          } else if (retryCount + 1 >= maxTrial) {
            reject(new Error('The maximum number of trials exceeded.'));
          } else {
            retryCount += 1;
            setTimeout(() => {
              retry().then(resolve).catch(reject);
            }, timeout(retryCount));
          }
        })
        .catch((error) => {
          reject(error);
        });
    });
  };

  return retry();
}
