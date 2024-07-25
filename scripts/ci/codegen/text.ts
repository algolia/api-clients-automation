import { TODAY } from '../../common.js';

export const commitStartPrepareRelease = 'chore: prepare release';
export const commitStartRelease = 'chore: release';

const commitEndMessage = '(generated).';

export default {
  commitEndMessage,
  commitPrepareReleaseMessage: `${commitStartPrepareRelease} ${TODAY}`,
  commitReleaseMessage: `${commitStartRelease} ${TODAY}`,
};

export function isGeneratedCommit(text: string): boolean {
  return text.endsWith(commitEndMessage);
}
