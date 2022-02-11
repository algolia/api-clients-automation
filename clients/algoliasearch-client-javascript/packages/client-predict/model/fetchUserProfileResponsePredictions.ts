import type { FetchUserProfileResponsePredictionsAffinities } from './fetchUserProfileResponsePredictionsAffinities';
import type { FetchUserProfileResponsePredictionsFunnelStage } from './fetchUserProfileResponsePredictionsFunnelStage';
import type { FetchUserProfileResponsePredictionsOrderValue } from './fetchUserProfileResponsePredictionsOrderValue';

export type FetchUserProfileResponsePredictions = {
  funnel_stage?: FetchUserProfileResponsePredictionsFunnelStage;
  order_value?: FetchUserProfileResponsePredictionsOrderValue;
  affinities?: FetchUserProfileResponsePredictionsAffinities;
};
