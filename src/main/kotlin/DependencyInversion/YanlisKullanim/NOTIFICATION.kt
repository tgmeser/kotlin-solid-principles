package DependencyInversion.YanlisKullanim

class NOTIFICATION {
    private val sms: SMS= SMS()
    private val emaıl: EMAIL= EMAIL()
    fun sendNotification(){
        sms.sendSms()
        emaıl.sendEmail()
    }
}