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
            if hasattr(received, "to_dict"):
                received = received.to_dict()
            _res = {}
            for k, v in expected.items():
                if k not in received or received[k] is None:
                    continue
                _res[k] = self.union(v, received[k])
            return _res

        return received
