package es.eternalshadow.entites;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_mago")
public class Mago extends Criatura{
	
	public Mago() {
		super();
	}
	

}
