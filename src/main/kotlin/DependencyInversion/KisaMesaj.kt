package DependencyInversion

class KisaMesaj: Mesaj {
    override fun mesajGonder() {
        kisaMesajGonder()
    }
    private fun kisaMesajGonder(){
        println("Kisa Mesaj gonderildi")
    }
}