class Helpers:
    def unwrap(self, resp):
        """converts the object response to its dictionary form, if it's a list, every items are iterated on and we call to_dict on it, otherwise we just call to_dict"""
        if isinstance(resp, list):
            _res = []
            for _, r in enumerate(resp):
                _res.append(r.to_dict())
            return _res
        return resp.to_dict()

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
                if k not in received or received[k] is None:
                    continue
                _res[k] = self.union(v, received[k])
            return _res

        return received
