
interface Beep {
    fun beep()
}

interface Radio {
    fun radio()
}

abstract class Vehicles () : Beep, Comparable<Vehicles> {
    abstract var fuelTank : Int
    abstract val speed: Int
    abstract val name :String
    override fun compareTo (other: Vehicles): Int {
        val compareFuel = this.fuelTank.compareTo(other.fuelTank)

        if (compareFuel != 0) {
            return compareFuel
        }

        val compareSpeed = this.speed.compareTo(other.speed)

        if (compareSpeed != 0) {
            return compareSpeed
        }

        return this.name.compareTo(other.name)
    }
}

abstract class Car (override val name: String) : Radio, Vehicles() {

    override fun beep() {
        println("$name: beep beep!")
    }
    override fun radio() {
        println("$name: radio is on!")
    }

}

abstract class Bike (override val name: String) :  Vehicles() {

    override fun beep() {
        println("$name: beep beep!")
    }
}

class BMW (override val name: String,
           override var fuelTank: Int = 60,
           override val speed: Int = 200
) : Car(name)

class Toyota (override val name: String,
              override var fuelTank: Int = 50,
              override val speed: Int = 150
) : Car(name)

class SportBike (override val name: String,
                 override var fuelTank: Int = 30,
                 override val speed: Int,
) : Bike(name)

class CrossBike (override val name: String,
                 override var fuelTank: Int = 20,
                 override val speed: Int,
) : Bike(name)

fun main() {
    val camry = Toyota("Toyota Camry", fuelTank = 60, speed = 200)
    val camry2 = Toyota("Toyota Camry", fuelTank = 60, speed = 199)
    val corolla = Toyota("Toyota Corolla")
    val sportBike = SportBike("Honda CBR1000RR", fuelTank = 18, speed = 300)
    val crossBike = CrossBike("Honda Road King", speed = 160)

    val vehicles = listOf(camry, camry2, corolla, sportBike, crossBike)

    val sortedVehicles = vehicles.sorted()
    sortedVehicles.forEach {
        println("${it.name} , ${it.speed}, ${it.fuelTank}")
    }

}