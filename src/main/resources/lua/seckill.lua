local key = KEYS[1]
local val = redis.call('get', key);

if tonumber(val) <= 0 then
  return false
else
  redis.call('decr', key);
  return true
end

