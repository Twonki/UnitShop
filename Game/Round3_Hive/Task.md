# Round 3: Ant hive

We reached our finale: The ant queen hatches new ants if she got enough food.

The hive is located on a map together with ants and food with differnt locations.
The legend told queen will produce new Ants if the hive collected enough food.

## Requirements Hive

The Hive:

- has a name
- has a position on the field
- has a foodamount
- has a updateMethod
- has a refference to the field
- has an antCounter
- has an absorbNearbyFood Method
- has a range for picking up food

Constraints:
- the id name can not be empty
- the position cannot be null or negative (neither x nor y)
- field can not be null

As soon as the updateMethod is called, the hive will consume all food which is located around it (in it's Range) and will produce a new ant if the foodamount is greater than 100.

## Helper MockField
The Helper MockField should give a Mock for the fieldfunctions and attributes.
They should be used to test the hive.

## Goals

- intensive use of mocks and stubs
- a full idea of how to use tests, mocks and stubs

## ToDo

1. Given the Interface "Field" implement a mockup field called MockField
2. write your tests using your Mockup-MockField
3. before the time is over, check your tests in
4. Implement the SimpleHive and its methods
5. check the tests of the enemy team out
6. write code to solve the tests. For the implementations, stick to the interface methods.
7. cheer, if you win
8. Enjoy playing around with your own ant-hive
