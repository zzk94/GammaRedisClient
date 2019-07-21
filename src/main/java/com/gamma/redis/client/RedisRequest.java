package com.gamma.redis.client;


import static com.gamma.redis.client.RedisUtil.MSG_MAX_LENGTH;

public class RedisRequest {
    private byte[] msgBytes;

    public RedisRequest(final String cmd) {
        int i = 0;
        msgBytes = new byte[MSG_MAX_LENGTH];
        for(; i < Math.min(MSG_MAX_LENGTH - 1, cmd.length()) ; i++) {
            msgBytes[i] = (byte) cmd.charAt(i);
        }
        msgBytes[i + 1] = (byte) '\n';
    }

    public RedisRequest(final int[] arr) {
        int i = 0;
        msgBytes = new byte[MSG_MAX_LENGTH];
        for(; i < Math.min(MSG_MAX_LENGTH, arr.length) ; i++) {
            msgBytes[i] = (byte) arr[i];
        }
    }

    public RedisRequest(final byte[] bytes) {
        int i = 0;
        msgBytes = new byte[MSG_MAX_LENGTH];
        for(; i < Math.min(MSG_MAX_LENGTH, bytes.length) ; i++) {
            msgBytes[i] = bytes[i];
        }
    }

    public byte[] toByteArray() {
        return msgBytes;
    }

    public String toStringMsg() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < MSG_MAX_LENGTH ; i++) {
            if((char) msgBytes[i] == '\n') {
                break;
            }
            sb.append((char) msgBytes[i]);
        }
        return sb.toString();
    }

    public char[] toCharArray() {
        return toStringMsg().toCharArray();
    }
}
