package OpenClosed

class AreaCalculator {
    fun notifyCalculatedArea(shape: Shape){
        println("Area is calculated: + ${shape.area()}")
    }
}

//Burdaki fonksiyona hangi tip parametre geleceğini bilemediğimiz için Polymorphsym kullandık
//Henüz ihtiyaç duymadığımız beşgen, sekizgen gibi class'lar ilerde oluşturulursa bu fonk. içinde asla sorun olmayacak