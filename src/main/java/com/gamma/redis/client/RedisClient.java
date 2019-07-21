package com.gamma.redis.client;

import java.net.InetAddress;

public class RedisClient {
    final static String host_ip_address = "127.0.0.1";
    final static int port = 6379;

    /**
     * TODO:
     * Responsibility of Redis Client is to connect with remote redis server.
     * getKey function should not be here.
     *
     * @Params Command, An object with redis commands and parameters
     * @Return Response, An object representing the
     */
//    public Response connectWithCommand(final Command cmd) {
//
//    }

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
