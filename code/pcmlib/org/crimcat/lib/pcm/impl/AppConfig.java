/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crimcat.lib.pcm.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgx647
 */
public class AppConfig {
    
    private static AppConfig appConfig = null;
    public static AppConfig getAppConfig() {
        if(appConfig == null) {
            appConfig = new AppConfig();
        }
        return appConfig;
    }
    
    public String getAppDatabaseDir() {
        return getAppDataDirFQN();
    }
    
    private AppConfig() {
        path = new File(getAppDataDirFQN());
        path.mkdir();
        configProps = new Properties();
        try {
        File configPropsFile = new File(getAppConfigFilePath());
            if(configPropsFile.exists() && configPropsFile.canRead()) {
                try(FileInputStream fis = new FileInputStream(configPropsFile)) {
                    configProps.load(fis);
                }
            } else {
                // Fill in default properties
                
                try(FileOutputStream fos = new FileOutputStream(configPropsFile)) {
                    configProps.store(fos, "");
                    fos.flush();
                }
            }
        } catch(FileNotFoundException fnfe) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, fnfe);
        } catch (IOException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static String getAppDataDirFQN() {
        if(null == SYSTEM_USER_HOME) {
            throw new RuntimeException("Cannot find user home. Bailing out...");
        }
        return SYSTEM_USER_HOME + SYSTEM_FILE_SEPARATOR + APP_DATA_DIR;
    }
    private static String getAppConfigFilePath() {
        return getAppDataDirFQN() + SYSTEM_FILE_SEPARATOR + APP_CONFIG_FILE;
    }
    
    private File path = null;
    private Properties configProps = null;
    
    private static final String APP_DATA_DIR = ".pcm";
    private static final String APP_CONFIG_FILE = ".global_config";
    private static final String SYSTEM_USER_HOME = System.getProperty("user.home");
    private static final String SYSTEM_FILE_SEPARATOR = System.getProperty("file.separator");
}
