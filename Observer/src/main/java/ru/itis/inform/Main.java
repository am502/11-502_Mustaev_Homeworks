package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        TokenizerObserver tr = new TokenizerObserver();
        Tokenizer t = new Tokenizer(tr);
        t.process("Hello! 1234 and 15. /90");
    }
}
