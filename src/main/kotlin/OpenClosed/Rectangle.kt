package OpenClosed

class Rectangle(val shorSide: Double,val longSide: Double): Shape() {
    override fun area(): Double {
        return shorSide*longSide
    }

}