package DependencyInversion

class Bildirim(val mesajlar: List<Mesaj>): Mesaj {
    override fun mesajGonder() {
        for(m in mesajlar){
            m.mesajGonder()
        }
    }
}