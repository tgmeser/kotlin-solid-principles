package SingleResponsibility

class RobotPrinter {
    fun greet(robot: BestRobot) {
        val name = robot.name
        val type = robot.type
        println("Hello my name is $name and I am a $type robot")
    }
}
//RobotPrinter class' ına ait olan greet() fonksiyonu sadece bir tane BestRobot nesnesi alıyor
//Data class tipindeki BestRobot nesnesinin tuttuğu verilere greet() içinde erişilip  işleniyor
//Böylece greet() işlemi için sadece bir sınıf oluşturuldu