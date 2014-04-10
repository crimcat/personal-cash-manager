/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crimcat.lib.pcm;

/**
 *
 * @author crimcat
 */
public class IncorrectTransactionException extends Exception {
    IncorrectTransactionException() {
        super();
    }
    IncorrectTransactionException(String descr) {
        super(descr);
    }
}
