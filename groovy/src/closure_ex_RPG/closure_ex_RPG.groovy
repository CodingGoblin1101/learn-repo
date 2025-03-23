package closure_ex_RPG

import strategy_pattern_RPG.Mace

// TODO: skills (optional: skills only usable with weapon X)
// TODO: SPD & round system
// TODO: enemy attacks (maybe a check with Random() to decide if auto attack or skill is used)
// TODO: job system (maybe weapon determines job (job change --> change status values & skills?)

"""set Status with User input"""
CharacterGen CharA = new CharacterGen()
CharA.setName("Revy")
//CharA.set_status()
CharA.ATK = 50
println CharA

CharacterGen CharB = new CharacterGen()
//CharB.set_status_with_closure()
println CharB

Sword Sword = new Sword()
Sword.setName("Mythril")
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
    def RNG_factor = new Random().nextFloat(0.3)

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
CharA.set_weapon(Sword)
CharA.give_weapon()

println ""
println ""
println "~~~Fight starts~~~"
CharA.ATK = ATK_buff()
Attack_Enemy(ATK_buff, Sword, EnemyA)
println EnemyA.HP


Attack_Enemy(CharA, Sword, EnemyA)
println EnemyA.HP

ATK_buff_end.delegate = CharA
CharA.ATK = ATK_buff_end()

Attack_Enemy(CharA, Sword, EnemyA)
println EnemyA.HP

Attack_Enemy(CharA, Sword, EnemyA)
println CharA

Courage courage = new Courage()
CharA.skills.add(courage)
CharA.show_skills()
println CharA.ATK
CharA.use_skill(courage)
println CharA.ATK

