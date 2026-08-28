import type { Headers, StackFrame } from '../types';

const CREDENTIAL_MASK = '*****';

export function stackTraceWithoutCredentials(stackTrace: StackFrame[]): StackFrame[] {
  return stackTrace.map((stackFrame) => stackFrameWithoutCredentials(stackFrame));
}

function maskBodyData(data: StackFrame['request']['data']): StackFrame['request']['data'] {
  if (typeof data !== 'string') {
    return data;
  }

  try {
    const parsed: unknown = JSON.parse(data);
    if (parsed !== null && typeof parsed === 'object' && !Array.isArray(parsed) && 'apiKey' in parsed) {
      return JSON.stringify({ ...parsed, apiKey: CREDENTIAL_MASK });
    }
  } catch {
    // Invalid JSON — leave the body as-is.
  }

  return data;
}

function maskUrl(url: string): string {
  return url.replace(/([?&]x-algolia-api-key=)[^&]*/g, `$1${CREDENTIAL_MASK}`);
}

export function stackFrameWithoutCredentials(stackFrame: StackFrame): StackFrame {
  const modifiedHeaders: Headers = stackFrame.request.headers['x-algolia-api-key']
    ? { 'x-algolia-api-key': CREDENTIAL_MASK }
    : {};

  return {
    ...stackFrame,
    request: {
      ...stackFrame.request,
      headers: {
        ...stackFrame.request.headers,
        ...modifiedHeaders,
      },
      data: maskBodyData(stackFrame.request.data),
      url: maskUrl(stackFrame.request.url),
    },
  };
}
