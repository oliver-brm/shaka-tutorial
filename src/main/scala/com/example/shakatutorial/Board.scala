package com.example.shakatutorial

import org.getshaka.shaka.*
import SquareValue.*

class Board extends Component :
  override val template: Frag = Frag {
    import builders.*

    val nextPlayer = Frag {
      GameState.bind(s => if s.xIsNext then t"X" else t"O")
    }

    div {
      div {
        className("status")
        t"Next player: $nextPlayer"
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
