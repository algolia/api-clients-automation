import { TODAY } from '../../common.js';

export const commitStartPrepareRelease = 'chore: prepare release';
export const commitStartRelease = 'chore: release';

export default {
  commitStartMessage: 'chore: generated code for commit',
  commitPrepareReleaseMessage: `${commitStartPrepareRelease} ${TODAY}`,
  commitReleaseMessage: `${commitStartRelease} ${TODAY}`,
};
