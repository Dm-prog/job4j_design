package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean flag = true;
            while (flag) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Hello")) {
                            str = "Hello, Dear friend";
                        } else if (str.contains("Exit")) {
                            str = "Goodby";
                            flag = false;
                        } else {
                            str = "What?";
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(str.getBytes());
                }
            }
        } catch (IOException e) {
            LOG.error("Error", e);
        }
    }
}

