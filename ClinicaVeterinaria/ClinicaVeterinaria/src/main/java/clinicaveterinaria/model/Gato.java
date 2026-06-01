package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Caminador;

public class Gato extends Animal implements Caminador {

    public Gato(int id, String nombre) {
        super(id, nombre, TipoAnimal.GATO);
    }

    @Override
    public void caminar() {
        System.out.println(getNombre() + " esta caminando.");
    }
}