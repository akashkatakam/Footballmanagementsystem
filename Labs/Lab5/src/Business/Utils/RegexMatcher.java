/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nikitagawde
 */
public class RegexMatcher {
    final String EMAIL_PATTERN = "^[A-Za-z0-9]+_?[A-Za-z0-9@]+.[a-zA-Z0-9]+$";
    final String PASSWORD_PATTERN = "[A-Za-z0-9+_$]+";
    
    public boolean validateUsername(String username){
        Pattern p = Pattern.compile(EMAIL_PATTERN);
        Matcher m = p.matcher(username);
        boolean b = m.matches();
        return b;
    }
    
    public boolean validatePassword(String password) {
        Pattern p = Pattern.compile(PASSWORD_PATTERN);
        Matcher m = p.matcher(password);
        boolean b = m.matches();
        return b;
    }
    public static void main(String [] args){
    int i = 010;
    int j = 07;
        System.out.println(i);
        System.out.println(j);
    }
}
