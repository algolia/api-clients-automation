import { buildConfigs } from '../../base.rollup.config';

import pkg from './package.json';

const configs = buildConfigs(pkg);

export default configs;
