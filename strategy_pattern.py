from __future__ import annotations
from abc import ABC, abstractmethod


class MakeDuck:

    def __init__(self, behavior):
        self._behavior = behavior

    @property
    def behavior(self) -> Behavior:
        return self.behavior

    @behavior.setter
    def behavior(self, behavior: Behavior) -> None:
        self._behavior = behavior

    def set_ability(self) -> None:
        self._behavior.execute_ability()

class Behavior(ABC):
    @abstractmethod
    def execute_ability(self):
        pass

class AbilityA(Behavior):
    def execute_ability(self) -> None:
        print('can fly')

class AbilityB(Behavior):
    def execute_ability(self) -> None:
        print('can quack')


if __name__ == '__main__':
    duck = MakeDuck(AbilityA())
    duck.set_ability()

    duck2 = MakeDuck(AbilityB())
    duck2.set_ability()

    duck.behavior = AbilityB()
    duck.set_ability()