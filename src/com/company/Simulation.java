package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Simulation {

   private boolean hasLanded = true;


   public ArrayList<Item> loadItems(int path) throws FileNotFoundException
    {

       String itemWeight;



       File file = new File("/home/marcin/workspace/SpaceChallenge/src/com/company/phase-"+path+".txt");

       Scanner in = new Scanner(file);


       ArrayList<Item> items = new ArrayList<Item>();


        while (in.hasNextLine()) {


            itemWeight = in.nextLine();
            String[] tokens = itemWeight.split("\\=");


            Item item = new Item(tokens[0],Integer.parseInt(tokens[1]));

            items.add(item);

        }

        return items;

    }



  public ArrayList<Rocket> loadU1(ArrayList items)
   {

      ArrayList<Rocket> rocketsu1 = new ArrayList<Rocket>();
      Rocket rocket = new U1();

       Iterator iterator = items.iterator();

       while (iterator.hasNext()) {
           Item item = (Item) iterator.next();
           if (rocket.canCarry(item)) {
               rocket.carry(item);
           } else {
               rocketsu1.add(rocket);
               rocket = new U1();
               System.out.println("New U1 rocket created");
               rocket.carry(item);
           }
           if (!iterator.hasNext()) {
               rocketsu1.add(rocket);
           }
       }


      return  rocketsu1;



   }






    public ArrayList<Rocket> loadU2(ArrayList items)
    {

        ArrayList<Rocket> rocketsu2 = new ArrayList<Rocket>();
        Rocket rocket = new U2();

        Iterator iterator = items.iterator();

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketsu2.add(rocket);
                rocket = new U2();
                System.out.println("New U2 rocket created");
                rocket.carry(item);
            }
            if (!iterator.hasNext()) {
                rocketsu2.add(rocket);
            }
        }


        return  rocketsu2;



    }





    public void runSimulation(ArrayList<Rocket> rockets, int i) {

        for (Rocket rocket : rockets) {

            while (!rocket.launch()) {
                launchSimulation(i);
            }

            while (!rocket.land()) {
                while (!rocket.launch()) {
                    launchSimulation(i);
                }
                landSimulation(i);
            }

        }
    }





    public void launchSimulation(int i) {

        if (i == 1) {
            int counter1 = U1.getRocketU1Counter();
            counter1++;
            U1.setRocketU1Counter(counter1);

        } else {
            int counter1 = U2.getRocketU2Counter();
            counter1++;
            U2.setRocketU2Counter(counter1);

        }
    }


    public void landSimulation(int i) {
        if (i == 1) {
            int counter = U1.getRocketU1Counter();
            counter++;
            U1.setRocketU1Counter(counter);

        } else {
            int counter = U2.getRocketU2Counter();
            counter++;
            U2.setRocketU2Counter(counter);
        }
        hasLanded = false;
    }











}
