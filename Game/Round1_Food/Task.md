# Round 1: Starting Small - with Hunger

In this first round, we will make a class to represent food.

## Requirements "Food"

Food must

- Have a name
- Have a Point (x,y)  
- Have a nutrition value (a simple integer, whether the food is big or small)

The food must have the following methods:

- a constructor with name, point and nutrition value
- *equals*, which should return true for food with the same name on the same position, otherwhise false
- *nibble(int nib)* which reduces the nutrition value by nib, and returns the nibbled value (see example) 

There are following constraints on food:

- the name cannot be null or empty
- the position cannot be null or negative (neither x nor y)
- the nutrition value can never fall under 0

## Example Food

(example values: sugar={"Sugar",(0,0),100}, apple={"Apple",(1,0),50})

### Equals

apple.equals(sugar) -> false

sugar.equals(sugar) -> true

sugar.equals(new List<Int>()) -> false

### Nibble

apple.nibble(10) -> 10 ==> apple has now 40 nutrition value

apple.nibble(60) -> 50 ==> apple has now 0 nutrition value

### Constructor

new Food("bad",(0,0),-1) -> InvalidArgumentException

new Food("bad",(0,-1),10) -> InvalidArgumentException

new Food("bad",(-1,0),10) -> InvalidArgumentException

new Food("",(1,1),10) -> InvalidArgumentException

new Food(null,(1,1),10) -> InvalidArgumentException

new Food("Salad",(1,1),10) -> {"Salad",(1,1),10}

## ToDo

1. discuss the task with your team (Programming means thinking first!)
2. write your tests
3. after the time is over, check your tests in
4. check the tests of the enemy team out
5. write code to solve the tests
6. cheer, if you win

## Git-Helpers

To push your tests:

- into your repository: make a new branch with `git status teamX_taskY` (Add X and Y regarding your team!)
- go into your repository and check your changes with `git status`
- add your changes to the index by `git add` and commit them with `git commit -m "tests done"`(If you are familiar with git, you can do more commits)
- push your changes and ring the bell

to pull enemy tests:

- in your repository `git checkout master`
- `git fetch`
- `git checkout teamZ_taskY` with z and y depending on the context
- `git pull`

You should see your enemies tests, hurry and solve them!

## Goals

- learn simple testing
- learn to test exceptions
- learn to test equality
- have some fun!

## Addition: Interface Food
If you got some spare time, implement a food-interface which has the good food already implemented. 
We later need bad food.
