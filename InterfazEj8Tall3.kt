import java.time.LocalDate
import kotlin.collections.mutableMapOf
//
fun main() {

    var actividades = mutableMapOf<Int, actividad>()
    var opcion = 0

    while (opcion != 5) {
        println("\n-- MENU DE TAREAS --")
        println("1. Agregar tarea")
        println("2. Ver tareas")
        println("3. Cambiar estado de una tarea")
        println("4. Ver detalle de una tarea")
        println("5. Salir")
        print("Elige una opción: ")

        opcion = readLine()!!.toInt()

        when (opcion) {
            1 -> {
                actividades = crearactividad(actividades)
            }
            2 -> {
                mostrarActividades(actividades)
            }
            3 -> {
                print("Ingresa el ID de la tarea a marcar: ")
                val id = readLine()!!.toInt()
                marcarCompletada(actividades, id)
            }
            4 -> {
                print("Ingresa el ID de la tarea a consultar: ")
                val id = readLine()!!.toInt()
                mostrarActividadPorId(actividades, id)
            }
            5 -> {
                println("Saliendo del programa...")
            }
            else -> {
                println("Opción no válida, intenta de nuevo")
            }
        }
    }
}



class actividad(var titulo: String?, var desc: String?, var fecha: LocalDate?, var estado: Boolean = false) {

    fun cambiartitulo(valor: String) {
        titulo = valor
    }


    fun cambiardesc(valor: String) {
        desc = valor
    }


    fun mostrarInfo() {
        println("Titulo: $titulo")
        println("Descripcion: $desc")
        println("Fecha de creacion: $fecha")

        if (estado === false) {
            println("Estado: Pendiente")
        } else {
            println("Estado: Completada")
        }
    }

    fun cambiarestado() {
        if (estado === false) {
            estado = true
        } else {
            estado = false
        }
    }
}

fun crearactividad(actividades: MutableMap<Int, actividad>, ): MutableMap<Int, actividad> {
    var longitud: Int = actividades.size
    var fecha: LocalDate? = LocalDate.now()

    var actividad_obj = actividad(null, null, fecha=fecha, true )

    println("Ingrese el titulo de la actividad")
    var nuevotitulo = readLine()!!.toString()
    actividad_obj.cambiartitulo(nuevotitulo)

    println("Ingrese una descripcion para la actividad")
    var nuevadescripcion = readLine()!!.toString()
    actividad_obj.cambiardesc(nuevadescripcion)

    actividades.put(longitud, actividad_obj)

    return actividades
}

fun mostrarActividades(actividades: MutableMap<Int, actividad>) {
    for ((id, actividadObj) in actividades) {
        val estadoTexto = if (actividadObj.estado === true) "Completada" else "Pendiente"
        println("ID $id: ${actividadObj.titulo} - $estadoTexto")
    }
}

fun marcarCompletada(actividades: MutableMap<Int, actividad>, id: Int) {
    val actividadObj = actividades[id]

    if (actividadObj != null) {
        actividadObj.cambiarestado()
        println("La actividad '${actividadObj.titulo}' cambió su estado")
    } else {
        println("No existe ninguna actividad con el ID $id")
    }
}

fun mostrarActividadPorId(actividades: MutableMap<Int, actividad>, id: Int) {
    val actividadObj = actividades[id]

    if (actividadObj != null) {
        actividadObj.mostrarInfo()
    } else {
        println("No existe ninguna actividad con el ID $id")
    }
}