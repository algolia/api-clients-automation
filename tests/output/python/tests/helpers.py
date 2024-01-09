class Helpers:
    def union(self, expected: dict, received: dict) -> dict:
        """
        creates a new dict based on the keys of 'expected' that are also in 'received'
        """
        _res = {}

        if not isinstance(expected, dict) or not isinstance(received, dict):
            return received

        for k, v in expected.items():
            if k in received:
                if isinstance(v, dict):
                    _res[k] = self.union(v, received[k])
                elif isinstance(v, list):
                    if _res.get(k) is None:
                        _res[k] = []

                    for _iv, _v in enumerate(v):
                        _res[k].append(self.union(_v, received[k][_iv]))
                else:
                    _res[k] = received[k]

        return _res
