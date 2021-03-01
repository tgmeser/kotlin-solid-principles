package DependencyInversion

class Eposta : Mesaj{
    override fun mesajGonder() {
        epostaGonder()
    }
    private fun epostaGonder(){
        println("E-Posta Gonderildi")
    }
}