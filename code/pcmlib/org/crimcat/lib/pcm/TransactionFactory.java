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
public class TransactionFactory {
    
    private static TransactionFactory tf = null;
    public static TransactionFactory instance() {
        return (null == tf) ? (tf = new TransactionFactory()) : tf;
    }
    
    public ITransaction createTransaction(IAccount src,
                                          IAccount dst,
                                          int amount,
                                          String description) throws IncorrectTransactionException {
        // TODO: insert validation here
        validateAccount(src, "source", description);
        validateAccount(dst, "destination", description);
        return MainFactoryImpl.createTransaction(src, dst, amount, description);
    }
    
    private void validateAccount(IAccount acc, String hint, String descr) throws IncorrectTransactionException {
        if(null == acc) {
            hint = ((hint == null) || (hint.length() == 0)) ? "" : "(" + hint + ")";
            throw new IncorrectTransactionException("Account is not set or found for " + descr + hint);
        }
        if(!acc.isValid()) {
            hint = ((hint == null) || (hint.length() == 0)) ? "" : "(" + hint + ")";
            throw new IncorrectTransactionException("Account " + acc.name() + " is not valid for " + descr + hint);
        }
    }
}
