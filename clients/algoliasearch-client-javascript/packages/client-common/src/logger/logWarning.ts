import type { Logger } from '../types';

/**
 * Prefers the logger's optional `warn` method and falls back to `console.warn`, so warnings stay visible with the default no-op logger.
 */
export function logWarning(logger: Logger, message: string): void {
  if (logger.warn) {
    logger.warn(message);
  } else {
    console.warn(message);
  }
}
