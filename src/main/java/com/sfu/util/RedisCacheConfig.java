package com.sfu.util;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;


@Configuration
@EnableCaching
public class RedisCacheConfig  extends CachingConfigurerSupport {
    private volatile JedisConnectionFactory jedisConnectionFactory;
    private volatile RedisTemplate<String, String> redisTemplate;
    private volatile RedisCacheManager redisCacheManager;

    public RedisCacheConfig() {
        super();
    }

    public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, String> redisTemplate, RedisCacheManager redisCacheManager)
    {
        this.jedisConnectionFactory = jedisConnectionFactory;
        this.redisTemplate = redisTemplate;
        this.redisCacheManager = redisCacheManager;
    }
    public JedisConnectionFactory getJedisConnecionFactory() { return jedisConnectionFactory; }
    public RedisTemplate<String, String> getRedisTemplate() { return redisTemplate;	}
    public RedisCacheManager getRedisCacheManager() { return redisCacheManager;	}

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                if(objects.length != 0){
                    sb.append("_");
                    for (Object obj : objects) {
                        sb.append(obj.toString());
                    }
                }
                return sb.toString();
            }
        };
    }

}
