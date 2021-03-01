package LiskovSubstitution.Army

class Tank: ArmyVehicle() {
    override fun airBombing() {
        println("Airbombing is started")
    }

    override fun torpedoAttack() {
        println("Torpedo attack is started")    }

    override fun tankFire() {
        println("Tank fire is started")    }
}