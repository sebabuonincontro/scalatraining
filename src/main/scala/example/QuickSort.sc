def sort(xs: List[Int]): List[Int] = {
  if (xs.length <= 1) xs
  else {
    val pivot = xs(xs.length / 2)
    List.concat(
      sort(xs filter (current => pivot > current)),
      xs filter (current => pivot == current),
      sort(xs filter (current => pivot < current)))
  }
}

val l = List(6, 9, 0, 2, 15, 63, 14, 76, 9, 45)

sort (l)



