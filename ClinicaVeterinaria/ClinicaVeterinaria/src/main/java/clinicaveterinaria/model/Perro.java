package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Caminador;

public class Perro extends Animal implements Caminador {

    public Perro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PERRO);
    }

    @Override
    public void caminar() {
        System.out.println(getNombre() + " esta caminando.");
    }
}