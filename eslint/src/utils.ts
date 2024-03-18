import type { AST } from 'yaml-eslint-parser';

// a scalar is a primitive value, such as a string, number, or boolean
export function isScalar(node: AST.YAMLNode | null): node is AST.YAMLScalar {
  return node !== null && node.type === 'YAMLScalar';
}

export function isBlockScalar(
  node: AST.YAMLNode | null
): node is AST.YAMLBlockFoldedScalar | AST.YAMLBlockLiteralScalar {
  return isScalar(node) && 'chomping' in node;
}

export function isSequence(
  node: AST.YAMLNode | null
): node is AST.YAMLSequence {
  return node !== null && node.type === 'YAMLSequence';
}

export function isMapping(node: AST.YAMLNode | null): node is AST.YAMLMapping {
  return node !== null && node.type === 'YAMLMapping';
}

export function isPairWithKey(
  node: AST.YAMLNode | null,
  key: string
): node is AST.YAMLPair {
  if (node === null || node.type !== 'YAMLPair' || node.key === null)
    return false;
  return isScalar(node.key) && node.key.value === key;
}
