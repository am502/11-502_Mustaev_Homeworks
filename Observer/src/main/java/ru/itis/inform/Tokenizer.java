package ru.itis.inform;

public class Tokenizer {
    private TokenizerObserver t;
    public Tokenizer(TokenizerObserver t){
        this.t = t;
    }

    public void process(String text){
        String l = "";
        String d = "";
        for (int i = 0; i < text.length(); i++) {
            if(isLetter(text.charAt(i))){
                l += text.charAt(i);
                if(! d.isEmpty())
                    t.handleDigits(d);
                d = "";
            }
            else if(isDigit(text.charAt(i))){
                d += text.charAt(i);
                if(! l.isEmpty())
                    t.handleLetters(l);
                l = "";
            }
            else if(isSign(text.charAt(i))){
                if(! l.isEmpty())
                    t.handleLetters(l);
                if(! d.isEmpty())
                    t.handleDigits(d);
                l = "";
                d = "";
                t.handleSign(text.charAt(i));
            }
            else{
                if(! l.isEmpty())
                    t.handleLetters(l);
                if(! d.isEmpty())
                    t.handleDigits(d);
                l = "";
                d = "";
            }
        }
        if(! l.isEmpty())
            t.handleLetters(l);
        if(! d.isEmpty())
            t.handleDigits(d);
    }

    public boolean isLetter(char a){
        boolean b = false;
        if(a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z'){
            b = true;
        }
        return b;
    }

    public boolean isDigit(char a){
        boolean b = false;
        if((int) a >= 48 && (int) a <= 57){
            b = true;
        }
        return b;
    }

    public boolean isSign(char a){
        boolean b = true;
        if((int) a >= 48 && (int) a <= 57 || a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z' || a == ' '){
            b = false;
        }
        return b;
    }
}
