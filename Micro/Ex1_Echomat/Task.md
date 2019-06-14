# Exercise 1: Echomat
In this first Task, we will make a simple object which greets persons and repeats strings. 

## Requirements Echomat
The Echomat should ... 
- have a method "hello()" which gives a short welcome to anybody
- have a method "greet(name)" which gives a short welcome to a certain somebody, the name should be contained 
- have a method "echo(text)" which takes a text, and gives a list of strings, which acts like an echo (example below)
- Have a constructor, which makes a new Echomat (so the methods should be non-static)

In Addition, the Echomat should have some corner cases:
- echo(text) should be limited to texts with length between 5 and 30, otherwise it should throw an error
- greet(name) should check if the name is a single word, otherwise it should throw an error

## Examples Echomat
hello() -> "I am the Echomat! Welcome!"

greet("Leonhard") -> "Hello Leonhard!"

echo("Echooo") -> ["Echooo","Echoo","Echo","Ech","Ec","E"]

echo("E") -> InvalidArgumentException

greet("Leonhard Applis") -> Invalid Argument Exception

## ToDo - Step by Step
1. Check for the UnitTests in the class "EchomatTests", there are two tests for basic cases of the Echomat
2. Run the tests - they should fail 
3. Write Code that fulfills the tests (only the tests, not the special cases)
4. Write one or two tests for the special "InvalidArgumentException"
5. Write Code that fulfills your tests
6. Organize yourself a simple ToDo List what tests you need to have "echo" working as intended
7. Write the Tests
8. Run the Tests - they should be red
9. Write the Code 
10. Run your Tests - if green, cheer!

## Goals
- Understand a simple Unit test
- Write Simple Unit Tests
- Write Code that fulfills the tests
- Test of a single, stateless component
