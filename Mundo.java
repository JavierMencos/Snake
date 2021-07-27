import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mundo extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(24, 18,32); 
        agregarNuevoItem();
    }
    
    
    public void agregarNuevoItem() {
        int x = Greenfoot.getRandomNumber(24);
        int y = Greenfoot.getRandomNumber(18);
        Item item = new Item();
        addObject(item, x, y);
    }
}
