import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class worm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class worm extends Actor
{
    /**
     * Act - do whatever the worm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int cont = Greenfoot.getRandomNumber(1000);
    public void act() 
    {
        if(cont > 1){
            cont --;
            getWorld().showText("" + cont, getX(), getY());
        }
    }    
}
