class Helpers:
    def union(self, expected, received):
        """
        creates a new result based on the keys of 'expected' that are also in 'received'
        """
        if isinstance(expected, list):
            _res = []
            for _iv, _v in enumerate(expected):
                _res.append(self.union(_v, received[_iv]))
            return _res
        if isinstance(expected, dict):
            _res = {}
            for k, v in expected.items():
                _res[k] = self.union(v, received[k])
            return _res
        return received
