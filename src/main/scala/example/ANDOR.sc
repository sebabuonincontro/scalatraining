def and(x: => Boolean, y: => Boolean) = if (x) y else false

def or(x: Boolean, y: Boolean) = if(!x) y else true

def loop: Boolean = loop

and(false, loop)

or(false, true)