package util;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class PropertyReader{
    public static Properties getProperties(String filename) {
        Properties properties = new Properties();
        try(InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(filename)){
            properties.load(inputStream);
        } catch (IOException e) {
            e.getMessage();
        }
        return properties;
    }
}