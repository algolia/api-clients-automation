import type { DictionnaryEntry } from './dictionnaryEntry';

export type BatchDictionaryEntriesRequest = {
  /**
   * Actions to perform.
   */
  action: BatchDictionaryEntriesRequest.ActionEnum;
  body: DictionnaryEntry;
};

export namespace BatchDictionaryEntriesRequest {
  export enum ActionEnum {
    AddEntry = 'addEntry',
    DeleteEntry = 'deleteEntry',
  }
}
