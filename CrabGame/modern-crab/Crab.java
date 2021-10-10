import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
public class Crab extends Actor
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int numOfWorms = 0;
    public void act() 
    {
      List<lobster> langustus=getWorld().getObjects(lobster.class);
      lobster lang=null;
      if (!langustus.isEmpty()) {
            lang = langustus.get(0);
      }
      lobster lob = (lobster)getOneObjectAtOffset(0, 0, lobster.class);
      worm Worm = (worm)getOneObjectAtOffset(0, 0, worm.class);
      getWorld().showText(null, getX(), getY());
      move(4);
      if (Greenfoot.isKeyDown("left")) turn(-6);
      if (Greenfoot.isKeyDown("right")) turn(6);
      if (Worm != null){
            getWorld().showText("", Worm.getX(), Worm.getY());
            numOfWorms = numOfWorms + Worm.cont;
            Greenfoot.playSound("eating.wav"); 
            getWorld().removeObject(Worm);
            worm w = new worm();
            getWorld().addObject(w, Greenfoot.getRandomNumber(560), Greenfoot.getRandomNumber(560));
        }
      if (lob != null && this.numOfWorms > lang.numOfWorms){
            getWorld().showText("Ha ganado el cangrejo", 256, 256);
            Greenfoot.stop();
      }
      getWorld().showText("" + numOfWorms, getX(), getY()); 
    }    
}
