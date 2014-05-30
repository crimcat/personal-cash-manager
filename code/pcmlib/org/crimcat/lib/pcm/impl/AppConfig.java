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
import org.crimcat.lib.pcm.IApplicationConfig;

/**
 *
 * @author mgx647
 */
public class AppConfig implements IApplicationConfig {
    
    private static AppConfig appConfig = null;
    public static IApplicationConfig loadConfig() {
        if(appConfig == null) {
            appConfig = new AppConfig();
        }
        return appConfig;
    }
    
    // -------------------------------------------------------------------------
    
    @Override
    public boolean isAvailable() {
        return isLoaded;
    }

    // -------------------------------------------------------------------------
    
    private AppConfig() {
        appDatabaseDir = getAppDefaultDataDirFQN();
        path = new File(appDatabaseDir);
        path.mkdir();
        configProps = new Properties();
        boolean success = false;
        try {
            File configPropsFile = new File(appDatabaseDir + SYSTEM_FILE_SEPARATOR + APP_CONFIG_FILE);
            if(configPropsFile.exists() && configPropsFile.canRead()) {
                try(FileInputStream fis = new FileInputStream(configPropsFile)) {
                    configProps.load(fis);
                }
            }

            if(!checkAllExpectedOptions()) {
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
        finally {
            isLoaded = success;
        }
    }
    
    private boolean checkAllExpectedOptions() {
        return true;
    }
    
    private static String getAppDefaultDataDirFQN() {
        if(null == SYSTEM_USER_HOME) {
            throw new RuntimeException("Cannot find user home. Bailing out...");
        }
        return SYSTEM_USER_HOME + SYSTEM_FILE_SEPARATOR + APP_DATA_DIR;
    }
    
    private File path = null;
    private Properties configProps = null;
    private String appDatabaseDir = null;
    private final boolean isLoaded;
    
    private static final String APP_DATA_DIR = ".pcm";
    private static final String APP_CONFIG_FILE = ".global_config";
    private static final String SYSTEM_USER_HOME = System.getProperty("user.home");
    private static final String SYSTEM_FILE_SEPARATOR = System.getProperty("file.separator");
}
