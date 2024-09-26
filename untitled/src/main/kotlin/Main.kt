import read.readCotizaciones
import write.writeCotizadores
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.exists

fun main() {
    // Añade la ruta correcta del fichero
    val raiz = Path.of("src");
    val rutaFichero = raiz.resolve("main").resolve("resources").resolve("cotizacion.csv");

    // Verificar que el fichero existe
    if (!rutaFichero.exists()) {
        println("El fichero no existe: $rutaFichero")
        return
    }
    val fichero: BufferedReader = Files.newBufferedReader(rutaFichero);


    // Leer y procesar el fichero
    val cotizaciones = readCotizaciones(rutaFichero.toString())
    writeCotizadores(cotizaciones)
}