/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crimcat.lib.pcm;

import java.util.List;

/**
 *
 * @author mgx647
 */
public interface IAccount {

    String name();
    int balance();
    
    boolean isValid();
    
    List<ITransaction> paymentsHistory();
}
