import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cabeza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cabeza extends ParteSerpiente
{
    
    public Cabeza(ParteSerpiente parteSiguiente) {
        super(parteSiguiente);
    }
    
    public void mover() {
        capturarEstado();
        move(1);
        if(parteSiguiente != null){
            parteSiguiente.moverAPosicionYRotar(xAnterior, yAnterior, rotacionAnterior);
        }
    }
    
    public boolean sePuedeMover(int rotacion) {
        Actor objeto = null;
        if(rotacion == 0) {
            objeto = getOneObjectAtOffset(1, 0, ParteSerpiente.class);
        }
        if(rotacion == 180) {
            objeto = getOneObjectAtOffset(-1, 0, ParteSerpiente.class);
        }
        if(rotacion == 270) {
            objeto = getOneObjectAtOffset(0, -1, ParteSerpiente.class);
        }
        if(rotacion == 90) {
            objeto = getOneObjectAtOffset(0, 1, ParteSerpiente.class);
        }
        
        return objeto == null;
    }
    
    public boolean encontroItem() {
        Item item = (Item)getOneObjectAtOffset(0, 0, Item.class);
        return item != null;
    }
    
    public void comerItem() {
        Item item = (Item)getOneObjectAtOffset(0, 0, Item.class);
        getWorld().removeObject(item);
    }
    
    /**
     * Act - do whatever the Cabeza wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
