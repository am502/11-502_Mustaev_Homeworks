package ru.itis.inform;

public class Pair {
    private String k;
    private String v;

    public Pair(String k, String v){
        this.k = k;
        this.v = v;
    }

    public String getK(){
        return k;
    }

    public String getV(){
        return v;
    }

    @Override
    public String toString(){
        return k + " " + v;
    }
}
