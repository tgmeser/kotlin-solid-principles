package InterfaceSegration

class Snake: Animal {
    override fun run() {
        println("Snake cant run")
    }

    override fun jump() {
        println("Snake cant jump")
    }

    override fun hunt() {
        println("Snake is hunting")
    }
}