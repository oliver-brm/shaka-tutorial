package com.example.shakatutorial

import org.getshaka.shaka.*
import org.scalajs.dom.window

class Square(position: Int) extends Component:

  override val template: Frag = Frag {
    import builders.{position as _, *}
    
    button {
      className("square")
      onclick(_ => GameState.setSquare(position))
      GameState.bind(_.boardState(position).display.t)
    }
  }
