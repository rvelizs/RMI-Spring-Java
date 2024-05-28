package com.example.practica;

// Clase Cliente que se conecta al servidor RMI y llama a los métodos remotos
// considera que el servidor RMI está corriendo en localhost y en el puerto 1099

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        CalculatorService calculatorService = (CalculatorService) registry.lookup("CalculatorService");

        // Preguntar al usuario para que agregue dos números
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Ingresa el primer número: ");
        int a = scanner.nextInt();
        System.out.println("Ingresa el segundo número: ");
        int b = scanner.nextInt();

        // Llamar a los métodos remotos
        System.out.println("Suma: " + calculatorService.add(a, b));
        System.out.println("Diferencia: " + calculatorService.subtract(a, b));

        scanner.close();
    }
}