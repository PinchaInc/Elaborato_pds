package views.swing

import Util.MessageType
import controllers.GroupsController
import model.Model
import java.awt.GridLayout
import java.util.Observable
import javax.swing.JButton
import javax.swing.JPanel

class GroupsView: views.GroupsView {
    private lateinit var model: Model
    private val root = JPanel()
    private val agenda = JButton("Agenda")
    private val students = JButton("Students")

    init {
        root {
            val navigationJPanel = JPanel()
            navigationJPanel {

                layout = GridLayout(1, 2)
                add(students)
                add(agenda)
            }

            layout = GridLayout(2,1)
            add(navigationJPanel)
        }
    }

    override fun start() {
        val frame = Frame.getInstance().frame
        frame.contentPane = this.root
        frame.pack()
    }

    override fun setController(controller: GroupsController) {
        agenda.addActionListener { controller.startAgenda() }
        students.addActionListener { controller.startStudents() }
    }

    override fun setModel(model: Model) {
        this.model = model
        (model as Observable).addObserver(this)
    }

    override fun showMessage(message: String, type: MessageType) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(p0: Observable?, p1: Any?) {
    }
}