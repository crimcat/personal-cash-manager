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
public class IncorrectAccountException extends Exception {
    public IncorrectAccountException(String descr) {
        super(descr);
    }
}
