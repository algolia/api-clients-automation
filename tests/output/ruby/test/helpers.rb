def union(expected, received)
  if !expected.is_a?(Array) and !expected.is_a?(Hash)
    return expected
  end

  if received.nil?
    return nil
  end

  if expected.is_a?(Array)
    res = []
    expected.each_with_index do |v, i|
      res.push(union(v, received[i]))
    end

    return res
  end

  res = {}
  expected.each do |key, value|
    res[key] = union(value, received[key])
  end

  res
end
