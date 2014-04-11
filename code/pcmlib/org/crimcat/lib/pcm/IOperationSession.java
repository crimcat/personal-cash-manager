/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crimcat.lib.pcm;

/**
 *
 * @author mgx647
 */
public interface IOperationSession {
    ITransaction createTransaction(IAccount dst,
                                   int amount,
                                   String description) throws IncorrectTransactionException;
    
    void enqueueTransaction(ITransaction t) throws IncorrectTransactionException;
}
