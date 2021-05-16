package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        if (str.contains("msg=Exit")) {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            server.close();
                        } else if (str.contains("msg=Hello")) {
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            out.write("Hello\r\n".getBytes());
                        } else if (str.contains("msg=")) {
                            String answer = str.split("=")[1].split(" ")[0];
                            out.write("HTTP/1.1 200 OK\r\n".getBytes());
                            out.write(answer.getBytes());
                            out.write("\r\n".getBytes());
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Exception input/output", e);
        }
    }
}
