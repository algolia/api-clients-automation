import type { BrowserLocalStorageCacheItem, BrowserLocalStorageOptions, Cache, CacheEvents } from '../types';

export function createBrowserLocalStorageCache(options: BrowserLocalStorageOptions): Cache {
  let storage: Storage;
  // We've changed the namespace to avoid conflicts with v4, as this version is a huge breaking change
  const namespaceKey = `algolia-client-js-${options.key}`;

  function getStorage(): Storage {
    if (storage === undefined) {
      storage = options.localStorage || window.localStorage;
    }

    return storage;
  }

  function getNamespace<TValue>(): Record<string, TValue> {
    return JSON.parse(getStorage().getItem(namespaceKey) || '{}');
  }

  function setNamespace(namespace: Record<string, any>): void {
    getStorage().setItem(namespaceKey, JSON.stringify(namespace));
  }

  function yieldToMain(): Promise<void> {
    return new Promise((resolve) => setTimeout(resolve, 0));
  }

  function getFilteredNamespace(): Record<string, BrowserLocalStorageCacheItem> {
    const timeToLive = options.timeToLive ? options.timeToLive * 1000 : null;
    const namespace = getNamespace<BrowserLocalStorageCacheItem>();
    const currentTime = new Date().getTime();

    return Object.fromEntries(
      Object.entries(namespace).filter(([, cacheItem]) => {
        if (!cacheItem || cacheItem.timestamp === undefined) {
          return false;
        }

        if (!timeToLive) {
          return true;
        }

        return cacheItem.timestamp + timeToLive >= currentTime;
      }),
    );
  }

  return {
    get<TValue>(
      key: Record<string, any> | string,
      defaultValue: () => Promise<TValue>,
      events: CacheEvents<TValue> = {
        miss: () => Promise.resolve(),
      },
    ): Promise<TValue> {
      return yieldToMain().then(() => {
        const namespace = getFilteredNamespace();
        const cachedItem = namespace[JSON.stringify(key)];

        setNamespace(namespace);

        if (cachedItem) {
          return cachedItem.value as TValue;
        }

        return defaultValue().then((value) => events.miss(value).then(() => value));
      });
    },

    set<TValue>(key: Record<string, any> | string, value: TValue): Promise<TValue> {
      return yieldToMain().then(() => {
        const namespace = getNamespace();

        namespace[JSON.stringify(key)] = {
          timestamp: new Date().getTime(),
          value,
        };

        getStorage().setItem(namespaceKey, JSON.stringify(namespace));

        return value;
      });
    },

    delete(key: Record<string, any> | string): Promise<void> {
      return yieldToMain().then(() => {
        const namespace = getNamespace();

        delete namespace[JSON.stringify(key)];

        getStorage().setItem(namespaceKey, JSON.stringify(namespace));
      });
    },

    clear(): Promise<void> {
      return Promise.resolve().then(() => {
        getStorage().removeItem(namespaceKey);
      });
    },
  };
}
