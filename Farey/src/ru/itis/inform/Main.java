package ru.itis.inform;
public class Main {
    public static void main(String[] args) {
        FareySequenceGeneratorArrayImpl F = new FareySequenceGeneratorArrayImpl();
        F.Generate(5);
        F.ShowSequence();
    }
}