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
    public String flipkartURL()
    {
        String URL = prop.getProperty("flipkartBaseURL");
        return URL;
    }

    public String amazonURL()
    {
        String URL = prop.getProperty("amazonBaseURL");
        return URL;
    }

    public String productToSearch()
    {
        String product = prop.getProperty("product");
        return product;
    }

    public String browserToUse(){
        return prop.getProperty("browser.name");
    }

}

