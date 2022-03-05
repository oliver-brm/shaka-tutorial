package com.example.shakatutorial

import org.getshaka.shaka.*
import SquareValue.*

class Board extends Component :
  override val template: Frag = Frag {
    import builders.*

    val status = Frag {
      GameState.bind(s => calculateWinner(s.boardState) match
        case X     => t"Winner: X"
        case O     => t"Winner: O"
        case Empty => t"Next Player: ${if s.xIsNext then "X" else "O"}"
      )
    }

    div {
      div {
        className("status")
        status.render
      }
      for i <- 0 until 9 by 3 do
        div {
          className("board-row")
          Square(i).render
          Square(i + 1).render
          Square(i + 2).render
        }
    }
  }

  val lines: IArray[IArray[Int]] = IArray(
    IArray(0, 1, 2),
    IArray(3, 4, 5),
    IArray(6, 7, 8),
    IArray(0, 3, 6),
    IArray(1, 4, 7),
    IArray(2, 5, 8),
    IArray(0, 4, 8),
    IArray(2, 4, 6)
  )

  def calculateWinner(boardState: IArray[SquareValue]): SquareValue =
    lines.collectFirst {
      case IArray(a, b, c)
        if boardState(a) != Empty
          && boardState(a) == boardState(b)
          && boardState(a) == boardState(c)
      => boardState(a)
    }.getOrElse(Empty)