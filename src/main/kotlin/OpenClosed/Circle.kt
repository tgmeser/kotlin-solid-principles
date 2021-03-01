package OpenClosed

class Circle(val radius: Double): Shape() {
    override fun area(): Double {
        return  radius * radius * 3.14
    }
}