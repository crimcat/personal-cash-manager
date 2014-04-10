/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crimcat.lib.pcm;

import org.crimcat.lib.pcm.impl.MainFactoryImpl;

/**
 *
 * @author mgx647
 */
public class AccountFactory {
    
    public static IAccount createAccount(String name, int initialBalance) {
        // TODO: insert validation here
        return MainFactoryImpl.createAccount(name, initialBalance);
    }
}
