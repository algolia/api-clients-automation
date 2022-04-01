import type { AST } from 'yaml-eslint-parser';

export function isScalar(node: AST.YAMLNode | null): node is AST.YAMLScalar {
  return node !== null && node.type === 'YAMLScalar';
}

export function isBLockScalar(
  node: AST.YAMLNode | null
): node is AST.YAMLBlockFoldedScalar | AST.YAMLBlockLiteralScalar {
  return isScalar(node) && 'chomping' in node;
}

export function isPairWithKey(
  node: AST.YAMLPair | null,
  key: string
): node is AST.YAMLPair {
  return (
    node !== null &&
    node.type === 'YAMLPair' &&
    isScalar(node.key) &&
    node.key.value === key
  );
}
