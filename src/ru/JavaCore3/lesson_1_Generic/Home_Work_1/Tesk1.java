package ru.JavaCore3.lesson_1_Generic.Home_Work_1;

import java.util.Arrays;

public class Tesk1 {
    private static Integer[] intMass;
    public static void main(String[] args) {
        intMass = new Integer[]{1, 2,3,3,4,7};
        ChangeMass<Integer> intArgs = new ChangeMass<>(intMass);
        intArgs.changer(intMass);
    }
}
class ChangeMass<T>{
    private T[] mass;
    ChangeMass(T[] mass) {
        this.mass = mass;
    }
    public void changer(Integer[] abs){
        System.out.println(Arrays.toString(abs));

        int n = abs.length;
        for(int i = 0; i<n/2; i++){
            int q = abs[n-i-1];
            abs[n-i-1] = abs[i];
            abs[i] = q;
        }
        System.out.println(Arrays.toString(abs));
    }
}
