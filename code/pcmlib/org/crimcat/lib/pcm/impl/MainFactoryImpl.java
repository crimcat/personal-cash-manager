/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crimcat.lib.pcm.impl;

import org.crimcat.lib.pcm.IAccount;
import org.crimcat.lib.pcm.ITransaction;

/**
 *
 * @author mgx647
 */
public class MainFactoryImpl {
    public static ITransaction createTransaction(IAccount src,
                                                 IAccount dst,
                                                 int amount,
                                                 String description) {
        return null;
    }
    
    public static IAccount createAccount(String name, int initialBalance) {
        return null;
    }
}
