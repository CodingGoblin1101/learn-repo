package closure_ex_RPG

import groovy.transform.ToString

@ToString
class Bow implements IWeapon{
    int ATK
    int id
    String type
    String name

    @Override
    def give_weapon(){
        this.name = Bow.toString()
        println "equipped $name bow"
    }

}

@ToString
class Sword implements IWeapon{
    int ATK
    int id
    String type
    String name

    @Override
    def give_weapon(){
    }

}