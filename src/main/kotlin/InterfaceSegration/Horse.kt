package InterfaceSegration

class Horse: Animal {
    override fun run() {
        println("Horse is running")
    }

    override fun jump() {
        println("Horse is jumping")
    }

    override fun hunt() {
        println("Horse cant hunt")
    }
}