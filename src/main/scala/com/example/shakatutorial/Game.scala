package com.example.shakatutorial

enum SquareValue(val display: String):
  case X extends SquareValue("X")
  case O extends SquareValue("O")
  case Empty extends SquareValue("")

import SquareValue.*

case class Game(xIsNext: Boolean, boardState: IArray[SquareValue])

val InitialGameState: Game = Game(true, IArray.fill(9)(Empty))
