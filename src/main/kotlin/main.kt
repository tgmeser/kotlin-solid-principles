import DependencyInversion.Bildirim
import DependencyInversion.Eposta
import DependencyInversion.KisaMesaj
import DependencyInversion.YanlisKullanim.NOTIFICATION
import InterfaceSegration.Birds.Eagle
import InterfaceSegration.Horse
import InterfaceSegration.Snake
import InterfaceSegration.Tiger
import LiskovSubstitution.Army.Airplane
import LiskovSubstitution.Army.Submarine
import LiskovSubstitution.Army.Tank
import LiskovSubstitution.Ducks.ToyDuck
import LiskovSubstitution.Ducks.WildDuck
import OpenClosed.AreaCalculator
import OpenClosed.Circle
import OpenClosed.Rectangle
import SingleResponsibility.BestRobot
import SingleResponsibility.RobotPrinter

fun main(args: Array<String>) {
    println("Hello Solid Principles!")

    //Kod üzerinde flexible-maintable-scalable yetilerini max seviyeye çıkaran OOP yaklaşımıdır
    //S - Single Responsibilty Principle
    //O - Open-Closed Principle
    //L - Liskov substitution Principle
    //I - Interface segregation Principle
    //D - Dependancy Inversion Principle

    println("------Single Responsibilty Principle------")
    singleResponsibilityPrinciple()

    println("------Open-Closed Principle------")
    openClosedPrinciple()

    println("------Liskov substitution Principle------")
    liskovSubstitutionPrinciple()

    println("------Interface segregation Principle------")
    interfaceSegrationPrinciple()

    println("------Dependancy Inversion Principle------")
    dependencyInversionPrinciple()

    //SOLID' i aile fotoğrafı gibi düşün
    //Hepsi birbirine benziyor ancak hem hepsinin ayrı işler yaptığı hem beraber çalıştığı resme bakınca anlaşılıyor


}

fun singleResponsibilityPrinciple() {
    //Bir class veya modül sadece bir işten sorumlu olmalı
    //Veya programın sadece bir yönüyle ilgilenmeli
    //Bir class veya modül ne kadar çok şeyden sorumluysa değişitirilince o kadar çok şey değiştirilmek zorunda kalınıyor.
    //Kısaca herkesin ne yapacağı belli olmalı-herkes sadece kendi işine odaklanmalı

    val babur: BestRobot = BestRobot("Babur", "Home")
    val roboPrinter: RobotPrinter = RobotPrinter()
    roboPrinter.greet(babur)
}

fun openClosedPrinciple() {
    //Classlar, moduller ve metodlar extension(genişleme) olmaya açık, modify(değişim) etmeye kapalı olmalı
    //Bu durum da abstraction yapıları kullanarak sağlanır. İhtiyaç halinde interface ile implement edilir
    //Bu yaklaşım ile programda ilerki zamanlarda istenecek güncellemeler için  kolaylık sağlanır
    //Bu yaklaşımda polymorphsy-abstractions(abstract class ve interfaceler) iç içe kullanılır
    //Şu an sadece daire ve dikdörtgen sınıfları var ilerde başka sınıfların ihtiyac duyulup oluşturulması sorun olmaz
    //Cünkü sistem değişiklikten bağımsız genişlemeye açık, Abstraction ve Polymorphysm ile korunuyor
    //Sistemi böyle kurmasaydık her nesnenin tipini kontrol etmek zorunda kalacaktık
    //Henüz tanımlanmamış bir Shape gerektiğinde sistem işlevsiz kalacaktı

    val areaCalculator: AreaCalculator = AreaCalculator()

    val daire: Circle = Circle(10.0)
    areaCalculator.notifyCalculatedArea(daire)

    val dikdortgen: Rectangle = Rectangle(10.0, 20.0)
    areaCalculator.notifyCalculatedArea(dikdortgen)

}

fun liskovSubstitutionPrinciple() {

    //X , Y nin bir alt tipi ise Y nin tipleri X tiplerinin yerine koyulabilir olmalı- IS A ilişkisi
    //Yani alt üyeleri üst sınıf diğer alt üyeleri ile hiçbirşey bozulmadan değiştirebiliyor olmalı
    val airplane: Airplane = Airplane()
    val tank: Tank = Tank()
    val submarine: Submarine = Submarine()

    airplane.torpedoAttack()
    airplane.tankFire()
    airplane.airBombing()
    //Görüldüğü gibi uçaktan torpido veya tank ateşi beklenemez
    //Bunun yerine bu saldırı tiplerini davranış olarak oluşturup ona göre kullanmalıyız
    //Hava bombardımanı veya toprido saldırısı tanklar için işlevsiz kaldı yani sahte kod durumu oluştu

    val toyDuck: ToyDuck = ToyDuck()
    val wildDuck: WildDuck = WildDuck()

    //Ana sınıfın özelliği alt sınıflarda kullanımı uygun olmayacaksa bu prensibe aykırı durumdur.
    //Oyuncak ördekten uçması ve yemek yemesi beklenemeyeceği için bu yetiler interface halinde oluşturuldu
    //Alt ördek tipleri sahip olabileceği yetileri implement etti
    //İki ördek türü de suya düşünce yüzebiliyor yani ortak özellik
    //İki ördek türü de quack sesi çıkarabiliyor
    //Ancak yaban ördeği hem uçup hem yemek yiyebiliyor
    //Kısaca altsınıfa ait nesneler üstsınıfa ait nesnelere ait davranışları sergileyebilmesidir
    //Ortak davranış yani beklenen davranış üst sınıf olan Duck sınıfından gelen swimming metodudur
    //Fly-Eat-Quack yetileri interface olarak ek özellik halindedir
    //Yani ; Liskov prensibi de Open-Closed gibi genişlemeye açık yapılar söz konusudur
    //Eğer eat,fly,quack metodları Duck içinde olsaydı oyuncak ördek bunları kullanmak zorunda kalacaktı
    //Bu da sahte kod durumuna yol açar, işlevsiz halde o boş fonksiyonlar kullanılmış olurdu
    //Yani görüntüden ibaret, hiçbir işlevleri olmazdı

    toyDuck.quacking()
    toyDuck.swimming()

    wildDuck.quacking()
    wildDuck.swimming()
    wildDuck.flying()
    wildDuck.eating()


}

fun interfaceSegrationPrinciple() {
    //Programa ek özellik ihtiyacı olduğu sürece arayüz ayırma ihlalleri meydana gelebilir
    //Yetilerin,fonksiyonları bir arayüz içinde tutmak yerine özelleştirilmiş birçok arayüz kullanılmalı
    //Birçok fonk bulunduran arayüzdeki değişim bunu implement eden sınıfların hepsinde devasa değişim oluşturur
    //Yani her yetinin kendine ait bir arayüzü olmalı
    //Yani bir interface implement edince sadece o ihtiyacını gidermiş olmalı
    //Single Responsibility prensibine oldukça benziyor
    //Farkları ; SRP class ve modullerle ilgilenirken, ISP ise arayüzlerle ilgileniyor

    val piton: Snake = Snake()
    val bengalTiger: Tiger = Tiger()
    val arabicHorse: Horse = Horse()

    piton.run() //Yılan koşamaz
    piton.jump()//Yılan zıplayamaz
    piton.hunt()

    arabicHorse.hunt()//At avlanmaz
    arabicHorse.jump()
    arabicHorse.run()

    bengalTiger.hunt()
    bengalTiger.run()
    bengalTiger.jump()

    //Yani animal içindeki tüm yetiler var ama Animal' ı implement eden sınıflar hepsini kullanamıyor
    //Yani Animal Interface' ini içerdiği yetilere göre parçalara bölmeliyiz
    //Flyable,Swimable,Huntable Interfaceleri ile yetileri görevlerine göre ayırdık

    val blackEagle: Eagle = Eagle()
    val wildGreenDuck: InterfaceSegration.Birds.WildDuck = InterfaceSegration.Birds.WildDuck()

    blackEagle.hunt()
    blackEagle.fly()

    wildGreenDuck.swim()
    wildGreenDuck.fly()

    //Görüldüğü gibi kartal sadece ucup avlanır, ördek  ise ucup yüzer
    //Arayüzler ayrıldı sadeleşti hepsinin birer görevi oldu

}

fun dependencyInversionPrinciple() {
    //Sınıflar arası bağımlılığı min. seviyeye indirmek amaçlanır
    //Üst seviye sınıflar alt seviye sınıflara bağımlı olmamalı
    //Hem alt hem üst seviye sınıfların ikisi de abstractionlara bağımlı olmalı
    //Alt sınıfa yapılan değişiklik üst sınıfı etkilememeli
    //Üst ve alt seviye sınıflar arasına abstraction yardımıyla birnevi köprü kurarız
    //Biraz adapter design pattern i andırıyor
    //Böylece alt seviyelerdeki değişim üst seviyeyi değişikliğe zorlamaz

    val kisaMesaj: KisaMesaj = KisaMesaj()
    val kisaMesaj2: KisaMesaj = KisaMesaj()

    val eposta: Eposta = Eposta()
    val eposta2: Eposta = Eposta()

    val bildirimGonderici: Bildirim = Bildirim(listOf(kisaMesaj, kisaMesaj2, eposta, eposta2))
    bildirimGonderici.mesajGonder()

    //Bildirim,Eposta,Kisamesaj classlarının hepsi Mesaj arayüzünü implement eder
    //Böylece değişim olacaksa bunu arayüz üzerinde yapacağız,aralarında köprü gibi
    //Mesaj arayüzünün mesaj fonksiyonu hem eposta hem kisamesaj sınıfı için uygun
    //Bildirim class' ı da gelen mesajın sms veya mail olmasıyla ilgilenmez
    //Mesaj arayüzünü implement  sms veya mailler, bildirim objesinde liste içinde depolanır
    //List<Mesaj> içinde bakılarak sms ise KisaMesaj,mail ise Eposta Class'ının özelliklerine göre davranır

    val notification: NOTIFICATION = NOTIFICATION()
    notification.sendNotification()
    //Bu kullanımda ise notification(üst sınıf) alt sınıflara bağımlı(sms,email)
    //sadece sms gelse veya sadece email geldiği zaman illaki iki tane kullanmak istiyor


}