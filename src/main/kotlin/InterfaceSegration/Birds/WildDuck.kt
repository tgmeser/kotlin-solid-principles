package InterfaceSegration.Birds

class WildDuck: Flyable,Swimmable {
    override fun fly() {
        println("Wildduck is flying...")
    }


    override fun swim() {
        println("Wildduck is swimming...")
    }
}