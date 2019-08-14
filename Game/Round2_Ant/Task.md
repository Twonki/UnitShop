# Round 2: (r)Ant

For the second round, we want to program a little Ant.

## Requirements "Ant"

An ant must:

- Have a Position (x,y)
- Have an id (int)
- Have a hunger value (integer)
- CAN Have a food it is carrying (Optional\<Food>)

The Ant must have the following methods:

- a constructor with an id and a point (Hunger should be set to 0)
- *pickupFood(food)* which picks up a piece of food and is set as Ants value
- *dropFood* which removes the food from the ant and sets it´s position to the ants position
- *eatFood* which *nibbles* on the carried piece of food and reduces hunger by the returned amount
- *move(Point)* which moves the ant to a new position
- *hungrier* which increases the hunger by 1
- (Setters and Getters as required)

There are following constraints on Ant:

- the id cannot be null or empty
- the hunger can not be negative
- the position cannot be null or negative (neither x nor y)
- if the ant has no food, dropfood does nothing
- if the ant has no food, eatfood does nothing
- if the ant has food, and eat reduces the nutritionvalue to 0, it gets dropped
- if the ant has food, and pickupFood is called, the new food is picked up and the old one is dropped

## Example Ant

### Eat Food

Ant{NoFood,Hunger=10}.eatFood-> Ant{NoFood,Hunger=10}

Ant{Food{Val=100},Hunger=10}.eatFood-> Ant{Food{Val=90},Hunger=0}

Ant{Food{Val=10},Hunger=10}.eatFood->Ant{NoFood,Hunger=0}

### Pickup Food

Ant{NoFood}.pickUp(newFood)-> Ant{newFood}

Ant{OldFood}.pickUp(newFood) -> Ant{newFood}

### Move

Ant{(0,0)}.move((1,1)) -> Ant{(1,1)}

Ant{(0,0)}.move(-1,-5) -> InvalidArgumentException

## Helper FakeFood

The MockUp Object *FakeFood* implements the *Food* Interface.

That means it must have the following methods:

- Point getPosition
- setPosition(Point)
- int nibble(int)
- String getName

For every value you need, and every behaviour you want, add simple public parameters you can easily use in your tests.

Leave the constructor empty and set only values you need directly in the test. Most of the methods only return or alter the public parameters and can be used in assert.

## ToDo

1. Given the Interface "Food" implement a mockup food called FakeFood
2. write your tests using your Mockup-Fakefood
3. before the time is over, check your tests in
4. check the tests of the enemy team out
5. write code to solve the tests. For the implementations, stick to the interface methods. 
6. cheer, if you win

## Goals

- write more complex tests
- work and develop a simple fake object from an interface
- enjoy Optional\<T> as it´s very nice for Java
