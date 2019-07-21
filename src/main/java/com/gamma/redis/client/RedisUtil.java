package com.gamma.redis.client;

import java.io.BufferedReader;
import java.io.IOException;

public class RedisUtil {
    static final public String GET = "GET";
    static final public String APPEND = "APPEND";
    static final public String SET = "SET";
    static final public String DELETE = "DEL";
    static final int RESPONSE_MAX_LINE = 5;
    static final int MSG_MAX_LENGTH = 256;

    static public String constructMsg(final String cmd, final String ...params) {
        StringBuilder sb = new StringBuilder(cmd + " ");
        for(String param : params) {
            sb.append(param);
            sb.append(" ");
        }
        sb.append('\n');
        System.out.println(String.format("msg is %s", sb.toString()));
        return sb.toString();
    }

    static public RedisResponse buildResponse(final String[] respMsg) {

        return new RedisResponse();
    }

    static private byte[] toByteArray(final String in) {
        byte[] res = new byte[in.length()];
        for(int i = 0 ; i < res.length ; i++) {
            res[i] = (byte) in.charAt(i);
        }
        return res;
    }

    static public RedisResponse buildResponseFromReader(BufferedReader in) {
        try {
            int c = 0;
            String[] lines = new String[RESPONSE_MAX_LINE];
            while (in.ready() && c < 5) {
                lines[c] = in.readLine();
                c++;
            }
            return buildResponse(lines);
        } catch (IOException e) {
            System.out.println(String.format("IOException whilte building response from buffered reader, error msg: %s",
                    e.getMessage()));
        }
        return null;
    }
}
