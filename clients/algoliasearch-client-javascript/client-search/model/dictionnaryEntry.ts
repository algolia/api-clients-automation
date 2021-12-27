/**
 * A dictionary entry.
 */
export type DictionnaryEntry = {
  /**
   * Unique identifier of the object.
   */
  objectID: string;
  /**
   * Language ISO code supported by the dictionary (e.g., \"en\" for English).
   */
  language: string;
  /**
   * The word of the dictionary entry.
   */
  word?: string;
  /**
   * The words of the dictionary entry.
   */
  words?: string[];
  /**
   * A decomposition of the word of the dictionary entry.
   */
  decomposition?: string[];
  /**
   * The state of the dictionary entry.
   */
  state?: DictionnaryEntry.StateEnum;
};

export namespace DictionnaryEntry {
  export enum StateEnum {
    Enabled = 'enabled',
    Disabled = 'disabled',
  }
}
