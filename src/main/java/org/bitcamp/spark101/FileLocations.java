package org.bitcamp.spark101;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by aosama on 4/8/17.
 */
public class FileLocations {

    public static String getSamplefileLocation()
    {
        ClassLoader classLoader = FileLocations.class.getClassLoader();
        try {
            return classLoader.getResource("countries.txt").toURI().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
}
