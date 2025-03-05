import groovy.transform.ToString
import groovy.transform.NullCheck

@ToString
@NullCheck
class Char {

    String name
    String weapon
    int hp
    int atk
    int shield

    def give_weapon(){
        weapon = 'sword'
    }

    def set_stats(int defense){
        hp = 20
        atk = 15
        shield = defense
    }

}
