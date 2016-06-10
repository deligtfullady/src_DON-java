package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by aavdeev on 07.06.2016.
 */
public class Hippodrome
{
    public static Hippodrome game;

    public static void main(String[] args)throws InterruptedException
    {
        game = new Hippodrome();
        game.horses.add(new Horse("One", 3, 0));
        game.horses.add(new Horse("Two", 3, 0));
        game.horses.add(new Horse("Three", 3, 0));

        game.run();
        //printWinner();

    }



    static ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {

        for (int i = 0; i < 100; i++)
        {

            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move()
    {
        for (Horse horse :
                getHorses())
        {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse :
                getHorses())
        {
            horse.print();
            System.out.println();
            System.out.println();
        }
    }

    public Horse getWinner()
    {
        double max = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > max) {
                max = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner()
    {
        Horse winner = getWinner();
        System.out.println("Winner is " + winner.getName()+"!");
    }

}
