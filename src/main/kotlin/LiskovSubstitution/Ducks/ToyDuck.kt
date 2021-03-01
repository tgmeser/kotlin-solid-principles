package LiskovSubstitution.Ducks

class ToyDuck: Duck(), Quack {
    override fun quacking() {
        println("Toyduck is quacking by batteries...")
    }

    override fun swimming() {
        println("Toyduck is swimming...")
    }
}