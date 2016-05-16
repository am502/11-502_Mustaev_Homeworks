package ru.itis.inform;

public class TokenizeObserver {
    public void handleDigits(String digits){
        System.out.println("Digits: " + digits);
    }
    public void handleLetters(String letters){
        System.out.println("Letters: " + letters);
    }
    public void handleSign(char sign){
        System.out.println("Sign: " + sign);
    }
}
