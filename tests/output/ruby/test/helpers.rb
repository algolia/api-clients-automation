def union(expected, received)
  case expected
  when Array
    res = []
    expected.each_with_index do |v, i|
      res.push(union(v, received[i]))
    end

    return res
  when Hash
    res = {}
    expected.each do |key, value|
      res[key] = union(value, received[key])
    end

    return res
  else
    return received
  end
end
