package closure_ex_RPG

"""set Status with User input"""
CharacterGen CharA = new CharacterGen()
CharA.setName("Revy")
//CharA.set_status()
CharA.ATK = 50
println CharA

CharacterGen CharB = new CharacterGen()
//CharB.set_status_with_closure()
println CharB

WeaponGen Sword = new WeaponGen()
Sword.ATK = 100

"""ATK buff usable with both character & weapon"""
//delegate in closure
def ATK_buff = { -> delegate.ATK * 2}
ATK_buff.delegate = Sword
println "ATK Sword with buff: $ATK_buff"
println "flat Sword ATK: $Sword.ATK"
ATK_buff.delegate = CharA
println "ATK Char with buff: $ATK_buff"
println "flat Char ATK: $CharA.ATK"

def ATK_buff_end = { -> delegate.ATK / 2}

CharacterGen EnemyA = new CharacterGen()
EnemyA.DEF = 50
EnemyA.HP = 500
EnemyA.name = "Goblin"
EnemyA.EXP = 60


"""damage calculation:
((Char.ATK * 1.5 + Wpn.ATK * 0.5) - Enemy.DEF) * (1 + RNG_factor)
"""
def Attack_Enemy(Object Char, Object Wpn, Object Enemy){
    RNG_factor = new Random().nextFloat(0.3)

    Double DMG = ((Char.ATK * 1.5 + Wpn.ATK * 0.5) - Enemy.DEF) * (1 + RNG_factor)
    DMG = DMG.round(0)
    Enemy.HP -= DMG
    println "$Char.name did $DMG DMG to $Enemy.name"

    if(Enemy.HP <= 0){
        println "$Enemy.name was slain. You WON! $char.name gained $Enemy.EXP exp"
        Char.EXP += Enemy.EXP

    }
}


println ""
println ""
println "~~~Fight starts~~~"
CharA.ATK = ATK_buff()
Attack_Enemy(CharA, Sword, EnemyA)
println EnemyA.HP


Attack_Enemy(CharA, Sword, EnemyA)
println EnemyA.HP

ATK_buff_end.delegate = CharA
CharA.ATK = ATK_buff_end()

Attack_Enemy(CharA, Sword, EnemyA)
println EnemyA.HP

Attack_Enemy(CharA, Sword, EnemyA)
println CharA