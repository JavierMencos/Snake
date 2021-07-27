import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cuerpo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cuerpo1 extends ParteSerpiente
{
    private String archivoImagen;
    
    public Cuerpo1(int parte, ParteSerpiente parteSiguiente) {
        super(parteSiguiente);
        archivoImagen = "body_" + parte + ".png";
        setImage(new GreenfootImage(archivoImagen));
    }
    /**
     * Act - do whatever the Cuerpo1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
