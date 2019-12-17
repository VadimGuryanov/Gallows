package ru.kpfu.itis.gallows.provider;

import ru.kpfu.itis.gallows.exception.HostProviderException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HostProvider {
    private static boolean init = false;
    private static String host;
    private static int port;

    private static void init() throws HostProviderException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("connection.properties"));
            host = properties.getProperty("host");
            port = Integer.parseInt(properties.getProperty("port"));
        } catch (IOException e) {
            throw new HostProviderException("Properties file not found.");
        }
    }

    public static String getHost() throws HostProviderException {
        if (!init){
            init();
        }
        return host;
    }

    public static int getPort() throws HostProviderException {
        if (!init){
            init();
        }
        return port;
    }
}
