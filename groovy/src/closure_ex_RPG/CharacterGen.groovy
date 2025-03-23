package closure_ex_RPG

import groovy.transform.ToString
import strategy_pattern_RPG.Iweapon

@ToString
class CharacterGen implements IObjGen {
    int HP
    int MP
    int ATK
    int DEF
    int EXP
    String name
    def private weapon = IWeapon
    List skills = []

    def set_weapon(weapon){
        this.weapon = weapon
    }

    def give_weapon(){
        println "equipped $name $weapon.name sword"
        return weapon.give_weapon()
    }

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
                this.setProperty(key, new_value)
            }
        }
    }

    def show_skills(){
        println skills
    }
    def use_skill(Object skill){
        this.skills.find {element ->
            if (element.name == skill.name){
                skill.owner = getThisObject()
                println "$name used $skill.name"
                skill.use()

            }
        }

    }
}