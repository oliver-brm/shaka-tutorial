package com.example.shakatutorial

import org.getshaka.shaka.State
import SquareValue.*

object GameState extends State(InitialGameState) {

  def setSquare(position: Int): Unit =
    if value.boardState(position) != Empty then return

    val newBoardState: IArray[SquareValue] =
      value.boardState.updated(position, if value.xIsNext then X else O)
    setValue(Game(!value.xIsNext, newBoardState))
}
