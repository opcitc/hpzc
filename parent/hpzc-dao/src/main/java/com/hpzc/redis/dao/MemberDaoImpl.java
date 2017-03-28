package com.hpzc.redis.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

//@Repository(value = "memberDao")
public class MemberDaoImpl implements MemberDao {

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(final Member member) {
		boolean result = (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(member.getId());
				byte[] name = serializer.serialize(member.getName());
				return connection.setNX(key, name);
			}
		});
		return result;
	}

	/**
	 * 添加集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(final List<Member> list) {
		boolean result = false;
		if (list != null && list.size() > 0) {
			result = (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
					RedisSerializer<String> serializer = getRedisSerializer();
					for (Member member : list) {
						byte[] key = serializer.serialize(member.getId());
						byte[] name = serializer.serialize(member.getName());
						connection.setNX(key, name);
					}
					return true;
				}
			}, false, true);
		}
		return result;
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
		// List<String> list = new ArrayList<String>();
		// list.add(key);
		// delete(list);
	}

	/**
	 * 删除集合 ,依赖key集合
	 */
	@Override
	public void batchDelete(List<String> keys) {
		redisTemplate.delete(keys);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Member get(final String keyId) {
		Object result = redisTemplate.execute(new RedisCallback<Member>() {
			public Member doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(keyId);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				String nickname = serializer.deserialize(value);
				return new Member(keyId, nickname);
			}
		});
		Member mm = (Member) result;
		return mm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean update(final Member member) {
		String key = member.getId();
		if (StringUtils.isEmpty(key)) {
			throw new NullPointerException("数据行不存在, key = " + key);
		}
		boolean result = (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(member.getId());
				byte[] name = serializer.serialize(member.getName());
				connection.set(key, name);
				return true;
			}
		});
		return result;
	}

	protected RedisSerializer<String> getRedisSerializer() {
		return redisTemplate.getStringSerializer();
	}
}
