package com.spring.start.service.impl;

import com.alibaba.fastjson.JSON;
import com.spring.start.service.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.JedisCluster;

import java.util.List;
import java.util.Map;

@Service
public class JedisServiceImpl implements JedisService {


    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public boolean exists(String key) {
        boolean flag = false;
        flag = jedisCluster.exists(key);
        return flag;
    }

    @Override
    public String set(String key, String value, int seconds) {
        String responseResult = jedisCluster.set(key,value);
        if(seconds!=0)
            jedisCluster.expire(key,seconds);
        return responseResult;
    }

    @Override
    public String getSet(String key, String value, int seconds) {
        String jedisClusterSet = jedisCluster.getSet(key, value);
        jedisCluster.expire(key,seconds);
        return jedisClusterSet;
    }

    @Override
    public String get(String key) {
        String str = jedisCluster.get(key);
        return str;
    }

    @Override
    public Long geoadd(String key, double longitude, double latitude, byte[] obj) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude) {
        return null;
    }

    @Override
    public void delKey(String key) {
        jedisCluster.del(key);
    }

    @Override
    public void delNativeKey(String key) {
        jedisCluster.del(key);
    }

    @Override
    public Map<String, Object> getMapData(String key) {
        String str = jedisCluster.get(key);
        Map<String,Object> map = JSON.parseObject(str, Map.class);
        return map;
    }

    /**
     * @Description: 如为第一次，则加上锁，每次调用值会自动加1
     * @Param:
     * @return:
     * @Author:
     * @Date: 2018/5/16
     */
    @Override
    public boolean lock(String key, int seconds) {
        if(jedisCluster.incr(key)==1) {
            jedisCluster.expire(key,seconds);
            return false;
        }
        return true;
    }

    @Override
    public void unlock(String key) {
        jedisCluster.del(key);
    }

    @Override
    public String getLocakValue(String key) {
        return jedisCluster.get(key);
    }

}