package views.swing

import Util.MessageType
import controllers.StudentsController
import model.Model
import views.StudentsView
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

class Students : StudentsView {

    private lateinit var model: Model
    private val root = JPanel()
    private val groups = JButton("Groups")
    private val agenda = JButton("Agenda")
    private val addStudent = JButton("Add Student")
    private val studentsJTable = JTable()

    init {
        root {
            val navigationJPanel = JPanel()
            navigationJPanel {
                layout = GridLayout(1, 2)
                add(groups)
                add(agenda)
            }

            val bodyJPanel = JPanel()
            bodyJPanel {
                layout = GridLayout(1, 2)
                add(studentsJTable)
            }

            val buttonJPanel = JPanel()
            buttonJPanel {
                add(addStudent)
            }

            layout = GridLayout(2, 2)
            add(navigationJPanel)
            add(buttonJPanel)
            add(bodyJPanel)
        }
    }

    override fun start() {
        val frame = Frame.getInstance().frame
        frame.contentPane = this.root
        frame.pack()

        val tableModel = studentsJTable.model as DefaultTableModel
        arrayOf("mat", "name", "surname", "group").forEach { tableModel.addColumn(it) }
        model.getStudents()
            .map { arrayOf(it.id.toString(), it.name, it.surname, if (it.group == null) "" else it.group!!.name) }
            .toTypedArray()
            .forEach { tableModel.addRow(it) }
    }

    override fun setController(controller: StudentsController) {
        groups.addActionListener { controller.startGroups() }
        agenda.addActionListener { controller.startAgenda() }
    }

    override fun setModel(model: Model) {
        this.model = model
    }

    override fun showMessage(message: String, type: MessageType) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertNewStudentData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectStudent() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun insertName() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}