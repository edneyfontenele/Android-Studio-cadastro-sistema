package com.example.cadastro;
import java.util.ArrayList;

public class RegistrosManager {
    private static ArrayList<Registro> aRegistros = null;

    public static ArrayList<Registro> getRegistros() {
        if (aRegistros == null) {
            aRegistros = new ArrayList<Registro>();
        }
        return aRegistros;
    }
}