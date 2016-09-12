package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        TokenizerObserver tr = new TokenizerObserver();
        Tokenizer t = new Tokenizer(tr);
        t.process("fsdfs/d sgj 3y3 idi 34hsdiu 4$$ fkkgkj >>> fmjghdk 7757i jjvjvg");
    }
}
