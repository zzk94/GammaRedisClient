package com.gamma.redis.client;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RedisConnection implements AutoCloseable {
    private final InetAddress address;
    private final int port;
    private Socket socket;
    public RedisConnection(final InetAddress address, final int port) {
        this.address = address;
        this.port = port;
    }

    public void send(final RedisRequest msg) {
        try {
            socket = new Socket(address, port);
            final BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
            out.write(msg.toByteArray());
            out.flush();
        } catch (final IOException ioe) {
            final String errorMsg = String.format("IOException while sending %s", msg.toStringMsg());
            System.out.println(errorMsg);
        }
    }

    public RedisResponse recv() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.US_ASCII));
            RedisResponse resp = RedisUtil.buildResponseFromReader(in);
            socket.close();
            return resp;
        } catch (final IOException ioe) {
            final String errorMsg = String.format("IOException while receiving for connection %s", ioe.getMessage());
            System.out.println(errorMsg);
        }
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
