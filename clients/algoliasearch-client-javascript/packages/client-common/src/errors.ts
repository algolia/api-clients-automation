import type {
  ApiError,
  DeserializationError,
  Response,
  RetryError,
  StackFrame,
} from './types';

export function createRetryError(stackTrace: StackFrame[]): RetryError {
  return {
    name: 'RetryError',
    message:
      'Unreachable hosts - your application id may be incorrect. If the error persists, contact support@algolia.com.',
    stackTrace,
  };
}

export function createApiError(
  message: string,
  status: number,
  stackTrace: StackFrame[]
): ApiError {
  return {
    name: 'ApiError',
    message,
    status,
    stackTrace,
  };
}

export function createDeserializationError(
  message: string,
  response: Response
): DeserializationError {
  return {
    name: 'DeserializationError',
    message,
    response,
  };
}
