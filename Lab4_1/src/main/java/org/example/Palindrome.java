package org.example;

public class Palindrome {
    public Boolean isPalindrome(String string){
        String cleanString = string.toLowerCase().replaceAll("\\s", "");

        for(int i = 0; i < cleanString.length() / 2; i++){
            if(cleanString.charAt(i) != cleanString.charAt(cleanString.length() - i - 1)){
                return false;
            }
        }

        return true;
    }
}

