val phrases = List(("",0),
  ("Aquí viene lo bueno", 1),
  ("habría que ver",2),
  ("no tengo idea",3),
  ("Cúbreme",4),
  ("Oh, buena idea jefe!",5),
  ("Asi era cuando llegué",6))

def pf: PartialFunction[(String, Int), Int] = {
  case (word, number) if (word.contains("é")) => number
}

phrases.collect(pf)

