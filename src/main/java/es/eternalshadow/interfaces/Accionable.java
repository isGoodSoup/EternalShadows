package es.eternalshadow.interfaces;

import es.eternalshadow.entities.Criatura;

public interface Accionable {
    void atacar(Criatura objetivo);
    void defender();
    boolean isVivo();
    void recibirDanio(int danio);
}