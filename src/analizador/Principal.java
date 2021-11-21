/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author lenovo
 */
public class Principal {
    
    public static void main(String[] args) throws Exception {
        String ruta1 = "C:/Users/lenovo/Documents/Projects/CUL/AnalizadoCUL/src/analizador/Lexer.flex";
        String ruta2 = "C:/Users/lenovo/Documents/Projects/CUL/AnalizadoCUL/src/analizador/LexerCup.flex";
        String[] rutaSintax = {
            "-parser", "Sintax", "C:/Users/lenovo/Documents/Projects/CUL/AnalizadoCUL/src/analizador/Sintax.cup"
        };
        
        generar(ruta1, ruta2, rutaSintax);
    }
    
    public static void generar(String ruta1, String ruta2, String[] rutaSintax) throws IOException, Exception {
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutaSintax);
        
        Path rutaSym = Paths.get("C:/Users/lenovo/Documents/Projects/CUL/AnalizadoCUL/src/analizador/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        
        Files.move(
                Paths.get("C:/Users/lenovo/Documents/Projects/CUL/AnalizadoCUL/sym.java"),
                Paths.get("C:/Users/lenovo/Documents/Projects/CUL/AnalizadoCUL/src/analizador/sym.java")
        );
        
        Path rutaSint = Paths.get("C:/Users/lenovo/Documents/Projects/CUL/AnalizadoCUL/src/analizador/Sintax.java");
        if (Files.exists(rutaSint)) {
            Files.delete(rutaSint);
        }
        
        Files.move(
                Paths.get("C:/Users/lenovo/Documents/Projects/CUL/AnalizadoCUL/Sintax.java"),
                Paths.get("C:/Users/lenovo/Documents/Projects/CUL/AnalizadoCUL/src/analizador/Sintax.java")
        );
    }

}
