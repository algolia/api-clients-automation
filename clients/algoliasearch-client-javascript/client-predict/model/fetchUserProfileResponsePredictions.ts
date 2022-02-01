import { FetchUserProfileResponsePredictionsAffinities } from './fetchUserProfileResponsePredictionsAffinities';
import { FetchUserProfileResponsePredictionsFunnelStage } from './fetchUserProfileResponsePredictionsFunnelStage';
import { FetchUserProfileResponsePredictionsOrderValue } from './fetchUserProfileResponsePredictionsOrderValue';


export type FetchUserProfileResponsePredictions = {
    funnel_stage?: FetchUserProfileResponsePredictionsFunnelStage;
    order_value?: FetchUserProfileResponsePredictionsOrderValue;
    affinities?: FetchUserProfileResponsePredictionsAffinities;
}



