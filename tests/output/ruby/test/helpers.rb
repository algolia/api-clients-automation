def union(expected, received)
  res = {}

  expected.each do |key, value|
    if received.key?(key)
      if value.is_a?(Array)
        res[key] = [] if res[key].nil?

        value.each_with_index do |v, i|
          res[key].push(union(v, received[key][i]))
        end
      elsif value.is_a?(Hash)
        res[key] = union(value, received[key])
      else
        res[key] = received[key]
      end
    end
  end

  res
end
