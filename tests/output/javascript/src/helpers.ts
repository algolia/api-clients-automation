export function union(
  expected: Record<string, any>,
  received: Record<string, any>
): Record<string, any> {
  const res = {};

  if (!expected) {
    return expected;
  }

  if (typeof expected !== 'object' && !Array.isArray(expected)) {
    return expected;
  }

  for (const [key, value] of Object.entries(expected)) {
    if (key in received) {
      if (Array.isArray(value)) {
        if (res[key] === undefined) {
          res[key] = [];
        }

        for (const [i, v] of value.entries()) {
          res[key].push(union(v, received[key][i]));
        }
      } else if (typeof value === 'object') {
        res[key] = union(value, received[key]);
      } else {
        res[key] = received[key];
      }
    }
  }

  return res;
}
