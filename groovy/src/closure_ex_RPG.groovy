import groovy.transform.ToString


@ToString
class CharacterGen {
    int HP
    int ATK
    int DEF
    String name

    def set_status() {

        println "set HP"
        def new_HP = System.in.newReader().readLine()
        this.HP = new_HP.toInteger()

        println "set ATK"
        def new_ATK = System.in.newReader().readLine()
        this.ATK = new_ATK.toInteger()

        println "set DEF"
        def new_DEF = System.in.newReader().readLine()
        this.DEF = new_DEF.toInteger()

        println "set name"
        def new_name = System.in.newReader().readLine()
        this.name = new_name
    }


    def set_status_with_closure(){
        def propMap = this.getProperties()

        propMap.collect { key, value ->
            key = key.toString()
            if(key == "class"){
                return
            }

            println "set $key"
            def new_value = System.in.newReader().readLine()
            try{
                this.setProperty(key, new_value.toInteger())
            }
            catch(Exception e){
                owner.setProperty(key, new_value)
            }
        }
    }


}

@ToString
class WeaponGen{
    int ATK
    int id
    String name
    String type

}

CharacterGen CharA = new CharacterGen()
CharA.setName("revy")
//CharA.set_status()
CharA.ATK = 50
println CharA

CharacterGen CharB = new CharacterGen()
//CharB.set_status_with_closure()
println CharB

WeaponGen Sword = new WeaponGen()
Sword.ATK = 100

//delegate in closure
def ATK_buff = { -> delegate.ATK * 1.5}
ATK_buff.delegate = Sword
println "ATK Sword with buff: $ATK_buff"
println "flat Sword ATK: $Sword.ATK"
ATK_buff.delegate = CharA
println "ATK Char with buff: $ATK_buff"
println "flat Char ATK: $CharA.ATK"