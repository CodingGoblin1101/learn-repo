package RPG

import groovy.transform.ToString


revy = new Character()
revy.set_weapon(new Bow())
println revy.give_weapon()

revy.set_weapon(new Mace())
println revy.give_weapon()

revy.show_stats()