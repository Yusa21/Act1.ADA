package write

import model.Cotizador;
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

fun writeCotizadores(cotizaciones: Map<String, Cotizador>) {


    val raiz = Path.of("src");
    val rutaFichero = raiz.resolve("main").resolve("resources").resolve("resumen.csv")
    val output = Files.newBufferedWriter(rutaFichero)

    output.appendLine("Nombre;Maximo;Minimo;Media")

    output.use{
        cotizaciones.forEach { entry ->
            println("${entry.value.nombre};${entry.value.maximo};${entry.value.minimo};${(entry.value.maximo + entry.value.minimo) / 2}")
            output.appendLine("${entry.value.nombre};${entry.value.maximo};${entry.value.minimo};${(entry.value.maximo + entry.value.minimo) / 2}")
        }
    }
}