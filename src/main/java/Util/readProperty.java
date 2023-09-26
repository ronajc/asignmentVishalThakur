package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readProperty {
    Properties prop;

    public readProperty() {
        File sourceFile = new File("src/test/java/resources/tests.properties");

        FileInputStream fisFileInputStream;
        try {
            fisFileInputStream = new FileInputStream(sourceFile);
            prop = new Properties();
            prop.load(fisFileInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public String baseUrl()
    {
        String URL = prop.getProperty("base_url");
        return URL;
    }


}

