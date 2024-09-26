package read

import model.Cotizador;
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.nio.file.Files

// Función que recibe la ruta del fichero y devuelve un Map con los objetos Cotizador
    fun readCotizaciones(rutaFichero: String): Map<String, Cotizador> {
    val cotizaciones = mutableMapOf<String, Cotizador>()
    // Leer el archivo línea por línea
    val lineas = File(rutaFichero).readLines()

    // Saltar la primera línea que contiene los encabezados
    for (linea in lineas.drop(1)) {
        // Dividir la línea por ";"
        val datos = linea.split(";")

        // Convertir cada valor a su tipo correspondiente y tener en cuenta los decimales con coma
        val nombre = datos[0]
        val final = datos[1].replace(".", "").replace(",",".").toFloat()
        val maximo = datos[2].replace(".", "").replace(",",".").toFloat()
        val minimo = datos[3].replace(".", "").replace(",",".").toFloat()
        val volumen = datos[4].replace(".", "").replace(",",".").toFloat()
        val efectivo = datos[5].replace(".", "").replace(",",".").toFloat()

        // Crear el objeto Cotizador
        val cotizador = Cotizador(nombre, final, maximo, minimo, volumen, efectivo)

        // Añadirlo al diccionario usando el nombre como clave
        cotizaciones[nombre] = cotizador
    }

    return cotizaciones
}