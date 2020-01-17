# BidimensionalEngine

This project is meant to be a simple, easy to use 2D game engine.
Still got a lot to do, lot of ideas to implement.

In order to use, after the package is loaded into your project, instantiate a new instance of **bidimensionalengine.core.Window**.

In order to pass in functions, Java uses double colon notation. 
For example:

class Example 
{
    public static void **foo**() { ... }
}

The reference to this method would be **Example::foo**.
Similarly, for a non-static method:

class Example
{
    public void **foo**() { ... }
}

Example e = new Example();

The reference would be **e::foo**.
