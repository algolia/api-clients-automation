export type FetchUserProfileResponsePredictionsFunnelStageValue = {
  name?: FetchUserProfileResponsePredictionsFunnelStageValueName;
  probability?: number;
};

export type FetchUserProfileResponsePredictionsFunnelStageValueName =
  | 'add_to_cart'
  | 'all_visits'
  | 'checkout'
  | 'click_product_list'
  | 'product_view'
  | 'transaction';
