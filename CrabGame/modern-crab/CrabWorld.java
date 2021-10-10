import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1);
        Crab c = new Crab();
        lobster l = new lobster();
        whale b = new whale();
        addObject(c,Greenfoot.getRandomNumber(560),Greenfoot.getRandomNumber(560));
        addObject(l,Greenfoot.getRandomNumber(560),Greenfoot.getRandomNumber(560));
        addObject(b,Greenfoot.getRandomNumber(560),Greenfoot.getRandomNumber(560));
        for(int i = 0;i < 10; i++){
            worm w = new worm();
            addObject(w,Greenfoot.getRandomNumber(560),Greenfoot.getRandomNumber(560));
        }
    }
}
