import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ParteSerpiente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ParteSerpiente extends Actor
{
    protected ParteSerpiente parteSiguiente;
    protected ParteSerpiente parteAnterior;
    
    protected int xAnterior;
    protected int yAnterior;
    protected int rotacionAnterior;
    
    public ParteSerpiente (ParteSerpiente parteSiguiente) {
        this.parteSiguiente = parteSiguiente;
        if(parteSiguiente != null) {
            parteSiguiente.setParteAnterior(this);
        }
    }
    
    public void setParteAnterior(ParteSerpiente parteAnterior) {
        this.parteAnterior = parteAnterior;
    }
    
    @Override
    public void addedToWorld (World world) {
        if (parteSiguiente != null && parteSiguiente.getWorld() == null) {
            world.addObject(parteSiguiente, getX() -1, getY());
        }
    }
    
    public void moverAPosicionYRotar(int x, int y, int rotacion) {
        capturarEstado();
        setLocation(x, y);
        setRotation(rotacion);
        if(parteSiguiente != null){
            parteSiguiente.moverAPosicionYRotar(xAnterior, yAnterior, rotacionAnterior);
        }
    }
    
    protected void capturarEstado() {
        xAnterior = getX();
        yAnterior = getY();
        rotacionAnterior = getRotation();
    }
    
    /**
     * Act - do whatever the ParteSerpiente wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
