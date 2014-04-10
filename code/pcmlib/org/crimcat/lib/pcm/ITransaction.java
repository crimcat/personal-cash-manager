/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crimcat.lib.pcm;

import java.util.Date;

/**
 *
 * @author mgx647
 */
public interface ITransaction {
    
    IAccount source();
    IAccount destination();
    
    boolean isCompleted();
    
    Date date();
    int amount();
    String description();
}
