package com.company;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args)  throws FileNotFoundException {



        long u1Cost;
        long u2Cost;

        Simulation simulation = new Simulation();

        simulation.loadU1(simulation.loadItems(1));

        simulation.loadU2(simulation.loadItems(2));

        u1Cost = totalCost(1);
        System.out.println("\nTotal budget needed for U1 rockets is: " + u1Cost);

        u2Cost = totalCost(2);
        System.out.println("Total budget needed for U2 rockets is: " + u2Cost);


    }



    public static long totalCost(int i) {
        return (i == 1) ? U1.getTotalCost() : U2.getTotalCost();
    }
}
