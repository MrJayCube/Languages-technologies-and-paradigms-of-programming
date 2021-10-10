import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lobster extends Actor
{
    /**
     * Act - do whatever the lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int numOfWorms = 0;
    public void act() 
    {   
        worm Worm = (worm)getOneObjectAtOffset(0, 0, worm.class);
        Crab crab = (Crab)getOneObjectAtOffset(0, 0, Crab.class);
        List<Crab> cangrajus=getWorld().getObjects(Crab.class);
        Crab cang=null;
        if (!cangrajus.isEmpty()) {
           cang = cangrajus.get(0);
        }
        getWorld().showText(null, getX(), getY());
        move(4);
        if (Greenfoot.isKeyDown("a")) turn(-6);
        if (Greenfoot.isKeyDown("d")) turn(6);
        if (Worm != null){
            getWorld().showText("", Worm.getX(), Worm.getY());
            numOfWorms = numOfWorms + Worm.cont;
            Greenfoot.playSound("eating.wav"); 
            getWorld().removeObject(Worm);
            worm w = new worm();
            getWorld().addObject(w, Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        }
        if (crab != null && this.numOfWorms > cang.numOfWorms){
            getWorld().showText("Ha ganado la langosta", 256, 256);
            Greenfoot.stop();
        }
        getWorld().showText("" + numOfWorms, getX(), getY()); 

    }    
}
