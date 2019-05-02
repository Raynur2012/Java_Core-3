package ru.JavaCore3.lesson_1_Generic;

import ru.JavaCore3.lesson_1_Generic.ccc.ChildOfChildOfRoot;
import ru.JavaCore3.lesson_1_Generic.ccc.ChildOfRoot;
import ru.JavaCore3.lesson_1_Generic.ccc.Root;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
            //параметризованный метод
    public static <T> T prntType(T val){//можно применять границы, как и с классом Stat
        System.out.println(val.getClass().getName());//каждый потомок Object может получить инфу, к какому типу
        //данных принадлежит этот класс
        return val;
    }
    public static void main(String[] args) {
        ContainerObj ob1 = new ContainerObj(10);
        ContainerObj ob2 = new ContainerObj("string");
        ContainerObj ob3 = new ContainerObj(0.5);
        ContainerObj ob4 = new ContainerObj(new Object());

        Container<String> strCon = new Container<>("esdf");
        Container<Integer> intCon = new Container<>(10);
        Container<Object> objCon = new Container<>(new Object());
        Container con = new Container(100);//так не рекомендуется делать. Параметризованный класс без параметров

        Pair<String, Integer> strIntPair = new Pair<>("Key", 100);

        System.out.println(strCon.getObj());
        System.out.println(intCon.getObj());
        System.out.println(objCon.getObj());
        System.out.println(con.getObj());

        Stat<Integer> intStat = new Stat<>(1,10,25,500);
//        Stat<Object> так уже нельзя, потому что ограничили типизацию класса Stat до Number
        System.out.println("Avg = " + intStat.avg());

        prntType(new Object());
        prntType(10);
        prntType("wqw");
    Stat<Integer> intStat1 = new Stat<>(10,20,30,40);
    Stat<Double> doubStat = new Stat<>(10.1,19.9,30.1,39.9);

    intStat.sameAvg(intStat1);//сравнивается, типы данных совпадают
    intStat.sameAvg(doubStat);//разные типы данных, можно сравнить только если задавалось <?>, а не <T>

         List<? extends ChildOfRoot> extChildOfRoot = new ArrayList<>();//такой массив используется только для
        //записи в него какой то уже содержащейся информации. В него ничего не добавить. Итерация по нему гарантирует
        //что в нем только объекты ChildOfRoot
        extChildOfRoot = Arrays.asList(new ChildOfRoot(), new ChildOfChildOfRoot() );//можно использовать так

         List<? super ChildOfRoot> superChildOfRoot = new ArrayList<>();//сюда можно добавлять, но по нему не проитерироваться

//         extChildOfRoot.add(new ChildOfRoot());           в такой массив нельзя ничего
//         extChildOfRoot.add(new Root());                  добавить, кроме null. Вызовет
//         extChildOfRoot.add(new ChildOfChildOfRoot());    ошибку.
         extChildOfRoot.add(null);

        superChildOfRoot.add(new ChildOfRoot());
        superChildOfRoot.add(new ChildOfChildOfRoot());
//         superChildOfRoot.add(new Root()); нельзя добавить, так как не удовлетворяет границе

//        for(ChildOfRoot item: superChildOfRoot){}     нельзя проитерироваться

        methodExtend(new ArrayList<ChildOfRoot>());         //для Extends только сам и потомки
        methodExtend(new ArrayList<ChildOfChildOfRoot>());

        methodSuper(new ArrayList<Object>());               //для Super только сам и вышестоящие
        methodSuper(new ArrayList<Root>());
        methodSuper(new ArrayList<ChildOfRoot>());
    }

    public static void methodExtend(List<? extends ChildOfRoot> list){
    }
    public static void methodSuper(List<? super ChildOfRoot> list){
    }
}
