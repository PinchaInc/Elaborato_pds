package views.swing

import Util.MessageType
import controllers.AgendaController
import model.Model
import views.AgendaView
import java.awt.Dimension
import java.awt.GridLayout
import java.util.Observable
import javax.swing.JButton
import javax.swing.JPanel

class AgendaView: AgendaView {
    private lateinit var model: Model
    private val root = JPanel()
    private val groups = JButton("Groups")
    private val students = JButton("Students")

    init {
        root {
            val navigationJPanel = JPanel()
            navigationJPanel {

                layout = GridLayout(1, 2)
                add(groups)
                add(students)
            }

            layout = GridLayout(2, 1)
            add(navigationJPanel)
        }
    }

    override fun start() {
        val frame = Frame.getInstance().frame
        frame.contentPane = this.root
        frame.pack()
    }

    override fun selectGroup() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setController(controller: AgendaController) {
        students.addActionListener { controller.startStudents() }
        groups.addActionListener { controller.startGroups() }
    }

    override fun setModel(model: Model) {
        this.model = model
        (model as Observable).addObserver(this)
    }

    override fun showMessage(message: String, type: MessageType) {
        Frame.getInstance().showMessage(message, type)
    }

    override fun update(p0: Observable?, p1: Any?) {
    }
}