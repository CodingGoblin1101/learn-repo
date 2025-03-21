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
def set_status_with_owner = {

}

CharacterGen CharA = new CharacterGen()
CharA.setName("Revy")
//CharA.set_status()
println CharA

CharacterGen CharB = new CharacterGen()
//CharB.set_status_with_closure()
println CharB

