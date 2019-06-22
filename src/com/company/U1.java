package com.company;

import java.util.Random;

public class U1 extends Rocket{

    private static final int cost = 100000000;
    private int  weight = 10000;
    private int  maxweight = 18000 ;
    private double explosionChance ;
    private double landingCrash ;
    private static int rocketU1Counter;


    public static int getRocketU1Counter() {
        return rocketU1Counter;
    }


    public static void setRocketU1Counter(int rocketU1Counter) {
        U1.rocketU1Counter = rocketU1Counter;
    }



    @Override
    public boolean land() {
        System.out.println("\nLANDING...");
        Random randomNumber = new Random();
        double rand = randomNumber.nextDouble();
        landingCrash = 0.01 * getTotalWeight() / getMaxCargo();

        if (landingCrash >= rand) {
            System.out.println("U1 CRASHED!!!");
            System.out.println("...Sending another rocket because it crashed...");
            return false;
        } else {
            System.out.println("U1 landed successfully!");
            return true;
        }
    }



    @Override
   public boolean launch()
   {
       System.out.println("\nLaunching rocket ...");
       Random randomNumber = new Random();
       double rand = randomNumber.nextDouble();
       explosionChance = 0.05 * getTotalWeight() / getMaxCargo();

       System.out.println("Cargo: " + getCurrentWeight());
       if (explosionChance >= rand) {
           System.out.println("U1 EXPLODED!!!");
           System.out.println("...Sending another rocket because it exploded...");
           return false;
       } else {
           System.out.println("U1 launched successfully!");
           return true;
       }
   }

    public static long getTotalCost() {
        return (long) getRocketU1Counter() * cost;
    }


}
