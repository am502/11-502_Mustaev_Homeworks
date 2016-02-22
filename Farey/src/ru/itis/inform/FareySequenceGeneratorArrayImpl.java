package ru.itis.inform;
public class FareySequenceGeneratorArrayImpl implements FareySequenceGeneratorArray {
    private RationalNumber[] Array = new RationalNumber[100];
    private int LENGTH = 0;
    public void initFareySequenceGeneratorArrayImpl(int LENGTH){
        this.LENGTH = LENGTH;
        this.Array[0] = new RationalNumber(0, 1);
        this.Array[1] = new RationalNumber(1, 1);
        this.LENGTH = 2;
    }
    public void Generate(int n){
        for(int i = 2; i < n; i++){
            int j = 0;
            while(j < LENGTH){
                if(Array[j].getB()+Array[j+1].getB() == i){
                    Shift(j+1);
                    Put(j+1, i);
                    j++;
                    this.LENGTH++;
                }
                j++;
            }
        }
    }
    public RationalNumber Put(int number, int i) {
        int a = Array[number].getA() + Array[number + 1].getB();
        int b = i;
        return new RationalNumber(a, b);
    }
    public void Shift(int element) {
        for(int i = element; i <= LENGTH; i++) {
            Array[i+1] = Array[i];
        }
    }
    public void ShowSequence(){
        for(int i = 0; i < LENGTH; i++){
            System.out.print(Array[i].getA()+"/"+Array[i].getB()+"  ");
        }
    }
}
