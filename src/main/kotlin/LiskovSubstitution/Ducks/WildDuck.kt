package LiskovSubstitution.Ducks

class WildDuck : Duck(),Fly,Eat,Quack{
    override fun flying() {
        println("Wildduck is flying...")
    }

    override fun eating() {
        println("Wildduck is eating...")
    }

    override fun quacking() {
        println("Wildduck is quacking...")
    }

    override fun swimming() {
        println("Wildduck is swimming...")
    }
}