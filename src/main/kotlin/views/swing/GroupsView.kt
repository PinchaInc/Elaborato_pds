package views.swing

import Util.MessageType
import controllers.GroupsController
import model.Group
import model.Model
import java.awt.GridLayout
import java.util.Observable
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

class GroupsView: views.GroupsView {
    private lateinit var model: Model
    private val root = JPanel()
    private val agenda = JButton("Agenda")
    private val students = JButton("Students")
    private val groupsJTable = JTable()
    private val tableModel = groupsJTable.model as DefaultTableModel

    init {
        root {
            val navigationJPanel = JPanel()
            navigationJPanel {

                layout = GridLayout(1, 2)
                add(students)
                add(agenda)
            }

            val bodyJPanel = JPanel()
            bodyJPanel {

                add(groupsJTable)
            }

            layout = GridLayout(2,1)
            add(navigationJPanel)
            add(bodyJPanel)
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
        arrayOf("name", "workTrack").forEach { tableModel.addColumn(it) }
        populateTable(*model.getGroups())
    }

    override fun showMessage(message: String, type: MessageType) {
        Frame.getInstance().showMessage(message, type)
    }

    override fun update(p0: Observable?, p1: Any?) {
        when (p1) {
            is Group -> populateTable(p1)
        }
    }

    private fun populateTable(vararg groups: Group) {
        groups
            .map {
                arrayOf(
                    it.name,
                    if (it.work == null) "" else it.work!!.workTrack
                )
            }
            .toTypedArray()
            .forEach { tableModel.addRow(it) }
    }
}