import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class whale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class whale extends Actor
{
    /**
     * Act - do whatever the whale wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        List<Crab> cangrajus=getWorld().getObjects(Crab.class);
        List<lobster> langustus=getWorld().getObjects(lobster.class);
        Crab cang=null;
        lobster lang=null;
        if (!cangrajus.isEmpty()) {
           cang = cangrajus.get(0);
        }
        if (!langustus.isEmpty()) {
           lang = langustus.get(0);
        }
        if(!cangrajus.isEmpty()&&! langustus.isEmpty()){
            moverse(cang,lang);
        }
        Crab crab = (Crab)getOneObjectAtOffset(0, 0, Crab.class);
        lobster lob = (lobster)getOneObjectAtOffset(0, 0, lobster.class);
        worm Worm = (worm)getOneObjectAtOffset(0, 0, worm.class);
        if (crab != null){
            getWorld().showText("", crab.getX(), crab.getY());
            getWorld().removeObject(crab);
            ganar("la langosta");
        }
        if (lob != null){
            getWorld().showText("", lob.getX(), lob.getY());
            getWorld().removeObject(lob);
            ganar("el cangrejo");
        }
        if (Worm != null){
            getWorld().showText("", Worm.getX(), Worm.getY());
            Greenfoot.playSound("eating.wav"); 
            getWorld().removeObject(Worm);
            worm w = new worm();
            getWorld().addObject(w, Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        }
        
    }
    public void ganar(String g){ 
        Greenfoot.playSound("eating.wav"); 
        getWorld().showText("Ha ganado " + g,256,256);
        Greenfoot.stop();
    }
    public void moverse(Crab cang,lobster lang){
        if(cang.numOfWorms > lang.numOfWorms){
            turnTowards(cang.getX(),cang.getY());
        }else if(cang.numOfWorms < lang.numOfWorms){
            turnTowards(lang.getX(),lang.getY());
        }else{
            if (Greenfoot.getRandomNumber(100) < 10){
                turn(Greenfoot.getRandomNumber(90)-45);
            } 
            if (getX() <= 5 || getX() >= getWorld().getWidth() - 5){
                turn(180);
            }           
            if (getY() <= 5 || getY() >= getWorld().getHeight() -5){
                turn(180);
            }       
        }
    }
}
