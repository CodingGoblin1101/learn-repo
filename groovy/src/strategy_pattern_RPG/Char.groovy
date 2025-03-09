package strategy_pattern_RPG

import groovy.transform.ToString

@ToString
class Character {

    String name
    int hp
    int atk
    int shield

    def private weapon = Iweapon

    def show_stats(){
        println "weapon: $weapon"

    }

    def set_weapon(weapon){
        this.weapon = weapon
    }

    def give_weapon(){
        return weapon.give_weapon()
    }
}


class Bow implements Iweapon {
    String weapon

    @Override
    def give_weapon() {
        weapon = 'bow'
    }

}


@ToString
class Mace implements Iweapon {
    String weapon

    @Override
    def give_weapon() {
        weapon = 'mace'
    }

}