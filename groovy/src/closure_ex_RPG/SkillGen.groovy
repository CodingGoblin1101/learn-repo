package closure_ex_RPG

class Courage implements ISkill{
    String name = "courage"
    int MP_cost = 20
    Object owner


    @Override
    use(){
        def courage = { -> delegate.ATK * 2}
        courage.delegate = owner
        int new_atk = "$courage".toInteger()
        owner.ATK = new_atk
        println new_atk
    }
}
