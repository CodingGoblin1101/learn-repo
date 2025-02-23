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

    def set_ability(self, fly, quack) -> None:
        self._behavior.set_behavior(fly, quack)

class Behavior(ABC):
    @abstractmethod
    def set_behavior(self, fly, quack):
        pass

class SetBehavior(Behavior):
    def set_behavior(self, fly, quack) -> None:
        if fly == 'fly':
            print('I can fly')
        else:
            print('I can not fly')

        if quack == 'quack':
            return print('I can quack')
        else:
            return print('I can not quack')


if __name__ == '__main__':
    duck = MakeDuck(SetBehavior())
    duck.set_ability('fly', 'no quack')