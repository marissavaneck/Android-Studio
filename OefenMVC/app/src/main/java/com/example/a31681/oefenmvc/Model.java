package com.example.a31681.oefenmvc;

import java.util.ArrayList;

public class Model {
    ArrayList<Integer>cijferList = new ArrayList<>();

    public Model(){
    }


    public void addToLijst(int newNumber){
        cijferList.add(newNumber);
    }

    //opvragen lijst
    public ArrayList getLijst(){
        return cijferList;
    }
    public double getGemiddelde(){
        double gemidDouble = calcGemiddelde(cijferList);
        return gemidDouble;
    }

    //berekenen van het gemiddelde in de lijst
    private double calcGemiddelde(ArrayList<Integer> numberList){
        Integer sum = 0;
        if (!numberList.isEmpty()){
            for (Integer numList : numberList){
                sum = sum + numList;
            }
            return sum.doubleValue() / numberList.size();
        }
        return sum.doubleValue();
    }





}

