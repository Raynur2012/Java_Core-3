package ru.JavaCore3.lesson_1_Generic;

import java.util.Arrays;
import java.util.List;

public class Stat<T extends Number> {//задаем верхнюю границу. То есть параметризовать этот класс теперь можно
                                    //только наследниками Number

//    public class Stat<T extends Number & Cloneable> - в качестве параметра можем использовать только те классы,
    //которые реализуют класс Number и имплементят интерфейс Cloneable


    private List<T> nums;//при стирании типов вместо Т теперь будет подставляться не Object, a Number
    public Stat(T... nums){
        this.nums = Arrays.asList(nums);
    }
    public double avg(){
        double sum = 0;
        for(T num:nums){
//            sum+=num;//если не задать верхнюю границу, то опреатор + нельзя применять к Т
        sum+=num.doubleValue();
        }
        return sum/nums.size();
    }

//    public boolean sameAvg(Stat<T> anotherStat){              после стирания типов мы не сможем работать
//        return Math.abs(avg() - anotherStat.avg()) < 0.0001;  с разными типами.
//    }
    public boolean sameAvg(Stat<? extends Number> anotherStat){
        return Math.abs(avg() - anotherStat.avg()) < 0.0001;
    }

}
