import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Serpiente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Serpiente extends Actor
{
    private Cabeza cabeza;
    private Cola cola;
    private ArrayList<Cuerpo1> partesCuerpo;
    
    public static final int LONGITUD_INICIAL_CUERPO =2;
    
    public Serpiente() {
        cola = new Cola();
        partesCuerpo = new ArrayList<Cuerpo1>();
        partesCuerpo.add(new Cuerpo1(1, cola));
        for(int i = 1; i<LONGITUD_INICIAL_CUERPO; i++) {
            partesCuerpo.add(new Cuerpo1(i % 2 + 1, partesCuerpo.get(i-1)));
        }
        cabeza = new Cabeza(partesCuerpo.get(partesCuerpo.size() -1));
        getImage().clear();
    }
    
    public void mover() {
        cabeza.mover();
    }
    
    public void verificarTeclayRotar() {
        if(Greenfoot.isKeyDown("up") && cabeza.getRotation() != 90) {
            cabeza.setRotation(270);
        }
        
        if(Greenfoot.isKeyDown("down") && cabeza.getRotation() != 270) {
            cabeza.setRotation(90);
        }
        
        if(Greenfoot.isKeyDown("left") && cabeza.getRotation() != 0) {
            cabeza.setRotation(180);
        }
        
        if(Greenfoot.isKeyDown("right") && cabeza.getRotation() != 180) {
            cabeza.setRotation(0);
        }
    }
    
    public void intentarComerItem() {
        if(cabeza.encontroItem()) {
            cabeza.comerItem();
            ((Mundo)getWorld()).agregarNuevoItem();
        }
    }
    
    
    @Override
    protected void addedToWorld(World world) {
        world.addObject(cabeza, getX(), getY());
    }
    
    public boolean hayColision() {
        boolean colision = false;
        if (cabeza.isAtEdge()) {
            if(cabeza.getRotation() == 0 && cabeza.getX() >= getWorld().getWidth() -1){
                colision = true;
            }
            if(cabeza.getRotation() == 180 && cabeza.getX() <= 0){
                colision = true;
            }
            if(cabeza.getRotation() == 270 && cabeza.getY() <= 0){
                colision = true;
            }
            if(cabeza.getRotation() == 90 && cabeza.getY() >= getWorld().getWidth() -1){
                colision = true;
            }
        } else {
            colision = !cabeza.sePuedeMover(cabeza.getRotation());
        }
        return colision;
    }
    
    /**
     * Act - do whatever the Serpiente wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        verificarTeclayRotar();
        if(!hayColision()) {
            mover();
            intentarComerItem();
        } else {
        Greenfoot.stop();
        }
    }
}
