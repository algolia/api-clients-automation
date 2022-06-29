import type { Response, StackFrame } from '../types';

export class ErrorWithStackTrace extends Error {
  stackTrace: StackFrame[];
  name: string;

  constructor(message: string, stackTrace: StackFrame[], name: string) {
    super(message);
    // the array and object should be frozen to reflect the stackTrace at the time of the error
    this.stackTrace = stackTrace;
    this.name = name ?? 'ErrorWithStackTrace';
  }
}

export class RetryError extends ErrorWithStackTrace {
  constructor(stackTrace: StackFrame[]) {
    super(
      'Unreachable hosts - your application id may be incorrect. If the error persists, contact support@algolia.com.',
      stackTrace,
      'RetryError'
    );
  }
}

export class ApiError extends ErrorWithStackTrace {
  status: number;

  constructor(message: string, status: number, stackTrace: StackFrame[]) {
    super(message, stackTrace, 'ApiError');
    this.status = status;
  }
}

export class DeserializationError extends Error {
  response: Response;
  name: string;

  constructor(message: string, response: Response) {
    super(message);
    this.response = response;
    this.name = 'DeserializationError';
  }
}
