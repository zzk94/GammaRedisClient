package com.gamma.redis.client;

import java.net.InetAddress;

public class RedisClient {
    final String host_ip_address = "127.0.0.1";
    final int port = 6379;

    public Response connectWithCommand(final Command cmd) {

    }

    public String getKey(final String key) {
        final String cmd = RedisUtil.constructMsg(RedisUtil.GET, key);
        try(RedisConnection conn = new RedisConnection(InetAddress.getByName(host_ip_address), port)) {
            conn.send(new RedisRequest(cmd));
            return conn.recv().toString();
        } catch (Exception e) {
            System.out.println(String.format("Exception while getting key %s, error message %s", key, e.getMessage()));
        }
        return null;
    }
}
