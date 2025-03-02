from __future__ import annotations
from abc import ABC, abstractmethod



class Character:

    def __init__(self, weapon):
        self._weapon = weapon

    @property
    def weapon(self) -> Weapon:
        return self.weapon

    @weapon.setter
    def weapon(self, weapon: Weapon) -> None:
        self._weapon = weapon

    def set_weapon(self) -> None:
        self._weapon.fight()

class Priest(Character):
    def __init__(self, weapon):
        super().__init__(weapon)

class Weapon(ABC):
    @abstractmethod
    def fight(self):
        pass

class Knife(Weapon):
    def fight(self)-> None:
        print('schwing')

class Bow(Weapon):
    def fight(self)-> None:
        print('pew pew')

if __name__ == '__main__':
    Knight = Character(Knife())
    Knight.set_weapon()

    Knight.weapon = Bow()
    Knight.set_weapon()

    Revy = Priest(Bow())
    Revy.set_weapon()

    Revy.weapon = Knife()
    Revy.set_weapon()