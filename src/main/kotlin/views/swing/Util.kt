package views.swing

import javax.swing.JComponent

operator fun JComponent.invoke(λ: JComponent.() -> Unit) = λ()
