package InterfaceSegration.Birds

class Eagle : Flyable,Huntable {
    override fun fly() {
        println("Eagle is flying...")
    }

    override fun hunt() {
        println("Eagle is hunting...")
    }
}