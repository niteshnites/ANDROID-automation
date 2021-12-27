package driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loader {

    private Properties properties;

    /**
     * Loader class Constructor
     */
    public Loader() {
        setProperties(loadProperties());
        applyProperties(getProperties());
    }

    /**
     * Method to set Properties file
     *
     * @param properties Properties
     */
    protected void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * Method to get Properties file
     *
     * @return properties
     */
    public Properties getProperties() {
        return this.properties;
    }

    /**
     * abstract method to Apply Properties file
     *
     * @param properties properties
     */
    protected void applyProperties(Properties properties) {

    }

    protected ArrayList<String> getPropertyFileList() {
        ArrayList<String> propFileList = new ArrayList<String>();
        propFileList.add(new File("src/main/resources/data.properties").getAbsolutePath());
        return propFileList;
    }

    /**
     * Method to get Logger to log information
     *
     * @return logger to log information
     */
    protected Logger getLogger() {
        Logger logger = Logger.getLogger(getClass().toString());
        logger.setLevel(Level.INFO);
        return logger;
    }

    /**
     * Method to Load Properties
     *
     * @return Properties file list
     */
    protected Properties loadProperties() {
        ArrayList<String> propFileList = getPropertyFileList();
        return loadDefaultAndCustomProps(propFileList);
    }

    /**
     * Method to load Default and custom Properties files
     *
     * @param propFilePathList list of properties file
     * @return test properties file
     */
    public Properties loadDefaultAndCustomProps(List<String> propFilePathList) {
        Properties testProps = new Properties();
        for (String propFilePath : propFilePathList) {
            try {
                testProps.load(new FileInputStream(propFilePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        testProps.putAll(System.getProperties());
        return testProps;
    }
}