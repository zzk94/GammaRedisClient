package com.gamma.redis.client;

public class main {
    public static void main(String[] args) {
        RedisClient client = new RedisClient();
        String val = client.getKey("haha");
        System.out.println(val);

    }
}
