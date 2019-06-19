# Round 3: Kids and Garden

We reached our finally: The bad kid who kills the ants appears.

Additional to the kid, a new (simple) element is given as the Garden. The garden is a simple container object for many places of food and Ants. Every Garden has a single ant-hill.

This Task is only about the Kid.

## Requirements Kid

The kid

- has a name
- has a funlevel
- has a point in the garden

The kid can:

- Burn ants around him (up to two fields away from him), which increases the funlevel
- Place sugar around him (up to two fields away from him)
- move to a different point, which decreases the funlevel
- eat sugar - increase funlevel
- regular update:
  - reduce funlevel
  - if i can kill ants, kill ants
  - if i can reach ants in one step, i go the step
  - if i have no funlevel, i eat sugar
  - if i cannot reach ants, i drop sugar

There are the following restrictions:

- the name cannot be null or empty
- the position cannot be null or negative (neither x nor y)

## Goals

- intensive use of mocks and stubs
- a full idea of how to use tests, mocks and stubs