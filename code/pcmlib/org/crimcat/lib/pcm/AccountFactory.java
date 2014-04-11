/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crimcat.lib.pcm;

import java.util.List;
import org.crimcat.lib.pcm.impl.MainFactoryImpl;

/**
 *
 * @author mgx647
 */
public class AccountFactory {
    
    private static AccountFactory af = null;
    public static AccountFactory instance() {
        return (null == af) ? (af = new AccountFactory()) : af;
    }
    
    public IAccount createAccount(String name, int initialBalance) throws IncorrectAccountException {
        validateBalance(initialBalance);
        return MainFactoryImpl.createAccount(name, initialBalance);
    }
    
    public IAccount openAccount(String name) {
        if((null != name) && (name.length() > 0)) {
            for(IAccount a : accounts()) {
                if(name.equals(a.name())) return a;
            }
        }
        return null;
    }
    
    public List<IAccount> accounts() {
        return MainFactoryImpl.allAccounts();
    }
    
    private void validateBalance(int balance) throws IncorrectAccountException {
        if(balance < 0) {
            throw new IncorrectAccountException("Account balance cannot be negative: " + balance);
        }
    }
}
