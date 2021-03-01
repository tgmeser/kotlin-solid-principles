package SingleResponsibility

class Robot(val name: String, val type: String) {

    fun greet() {
        println("Hello my name is $name, and I am a $type robot")
    }
}

//Bu sınıf sadece 2 iş yapıyor; hem robotun verilerini tutuyor hem greet() fonksiyonunu uyguluyor
//Amaçlanan bu 2 durum tek class içine sıkışmış durumdadır.
//Bu da ilerde yaşanacak değişim durumlarında sorunlara yol açar.
//Bunu önmelek için daha modüler bir durumda olmalı
//Verileri tutmak için bir data class' a , fonksiyonu yapması içinde ayrı bir class'a tanımlama yapılmalıdır.