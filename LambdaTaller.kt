fun main() {

    // Ejercicio 1
    println("--Ejercicio 1--")
    println(factorial(4))
    println(factorial(5))
    println(factorial(6))

    // Ejercicio 2
    println("--Ejercicio 2--")
    var numlist = mutableListOf<Int>()
    val promedio: (MutableList<Int>) -> Float = {lista -> (lista.sum().toFloat() / lista.size) }

    numlist = anexarelemento(numlist, 5)

    println("El promedio de los numeros es: " + promedio(numlist))

    //Ejercicio 3
    println("--Ejercicio 3--")
    fibonacci(20)

    //Ejercicio 4.
    println("--Ejercicio 4--")
    val persona_obj = Persona("Juan", "Rodriguez", 20)
    persona_obj.mostrarInfo()

    //Ejercicio 5
    println("--Ejercicio 5--")
    var estudiante_obj = Estudiante("Jean", "Rojas", 23, 4.5F)
    estudiante_obj.mostrarInfo()
    estudiante_obj.cambiarcalificacion(5F)
    estudiante_obj.mostrarInfo()

    //Ejercicio 7
    println("--Ejercicio 7--")
    val pares = numlist.filter {it % 2 == 0 }
    println(pares)
}

//Ejercicio 1 - Funcion
fun factorial(n: Int): String {
    val multiplicacion: (Int, Int) -> Int = {a, b -> a*b}

    var resultado: Int = 1
    for (i in 1..n)  {
        resultado = multiplicacion(resultado, i)
    }

    return ("El factorial de $n es: $resultado")
}

// Ejercicio 2 - funcion
fun anexarelemento (lista: MutableList<Int>, iteraciones: Int): MutableList<Int> {
    var elemento: Int?

    for (i in 1..iteraciones) {
        println("$i. Ingrese un numero")
        elemento = readLine()!!.toIntOrNull()

        if (elemento === null) {
            elemento = 0
        }

        lista.add(elemento)
    }

    return lista
}

//Ejercicio 3 - Funcion
fun fibonacci (elementos: Int) {
    val susesion: (Int, Int) -> Int = {a, b -> a+b}

    println("Imprimiendo secuencia de fibonacci")
    var elementoant: Int = 0
    var elementosig: Int = 1

        for (i in 1..(elementos-1)) {
            var temp: Int = 0

            if (i == 1) {
                println(elementoant)

            }

            println(elementosig)

            temp = susesion(elementoant, elementosig)
            elementoant = elementosig
            elementosig = temp

    }
}

//Ejercicio 4 - Clase
open class Persona(val nombre: String, val apellido: String, val edad: Int) {

    open fun mostrarInfo() {
        println("--INFORMACION DEL ESTUDIANTE--")
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("Edad: $edad")
    }
}

//Ejercicio 5 - Clase
class Estudiante(nombre: String, apellido: String, edad: Int, var calificacion: Float) : Persona(nombre, apellido, edad) {

    override fun mostrarInfo() {
        super.mostrarInfo()
        println("Edad: $calificacion")
    }

    fun cambiarcalificacion(valor: Float) {
        calificacion = valor
    }
}

//Ejercicio 6 - Interfaz
interface Operaciones {
    fun sumar(a: Int, b: Int): Int
    fun restar(a: Int, b: Int): Int
}

//Ejercicio 6 - Clase
class Calculadora : Operaciones {

    override fun sumar(a: Int, b: Int): Int {
        return a + b
    }

    override fun restar(a: Int, b: Int): Int {
        return a - b
    }
}

