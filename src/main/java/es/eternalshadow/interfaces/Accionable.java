package es.eternalshadow.interfaces;

import es.eternalshadow.entities.Criatura;

public interface Accionable {
    void atacar(Criatura criatura);
    void defender();
    boolean isVivo(Criatura criatura);
    int recibirDanio(int danio);
}