package views.swing

import Util.MessageType
import controllers.StudentsController
import model.Group
import model.Model
import model.Student
import views.StudentsView
import java.awt.Dimension
import java.awt.GridLayout
import java.lang.NumberFormatException
import java.util.Observable
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.JTextField
import javax.swing.table.DefaultTableModel

class StudentsView : StudentsView {
    private lateinit var model: Model
    private val root = JPanel()
    private val groups = JButton("Groups")
    private val agenda = JButton("Agenda")
    private val addStudent = JButton("Add Student")
    private val studentsJTable = JTable()
    private val tableModel = studentsJTable.model as DefaultTableModel
    private val matField = JTextField()
    private val nameField = JTextField()
    private val surnameField = JTextField()
    private val addGroup = JButton("Add Group")
    private val groupNameField = JTextField()

    init {
        root {
            val navigationJPanel = JPanel()
            navigationJPanel {
                groups {
                    preferredSize = Dimension(25, 25)
                }

                agenda {
                    preferredSize = Dimension(25, 25)
                }

                layout = GridLayout(1, 2)
                add(groups)
                add(agenda)
            }

            val bodyJPanel = JPanel()
            bodyJPanel {
                val controllJPanel = JPanel()
                controllJPanel {

                    val addStudentJPanel = JPanel()
                    addStudentJPanel {
                        val matJPanle = JPanel()
                        matJPanle {
                            layout = GridLayout(1, 2)
                            add(JLabel("mat."))
                            add(matField)
                        }

                        addStudent {
                            preferredSize = Dimension(200, 10)
                        }

                        layout = GridLayout(6, 1)
                        add(matJPanle)
                        add(JLabel("Name"))
                        add(nameField)
                        add(JLabel("surname"))
                        add(surnameField)
                        add(addStudent)
                    }

                    val addGroupJPanel = JPanel()
                    addGroupJPanel {

                        layout = GridLayout(3, 1)
                        add(JLabel("Group name"))
                        add(groupNameField)
                        add(addGroup)
                    }

                    layout = GridLayout(1, 2)
                    add(addStudentJPanel)
                    add(addGroupJPanel)
                }

                layout = GridLayout(1, 2)
                add(studentsJTable)
                add(controllJPanel)
            }

            layout = GridLayout(2, 1)
            add(navigationJPanel)
            add(bodyJPanel)
        }
    }

    override fun start() {
        val frame = Frame.getInstance().frame
        frame.contentPane = this.root
        frame.pack()
    }

    override fun setController(controller: StudentsController) {
        groups.addActionListener { controller.startGroups() }
        agenda.addActionListener { controller.startAgenda() }
        addStudent.addActionListener {
            try {
                val mat = matField.text.toInt()
                val name = nameField.text
                val surname = surnameField.text

                if (!name.isBlank() && !surname.isBlank())
                    controller.addStudent(name, surname, mat)
            } catch (e: NumberFormatException) {
                matField.text = ""
            }
        }
        addGroup.addActionListener {
            val students = studentsJTable.selectedRows
            if (students.isEmpty() || groupNameField.text.isBlank())
                showMessage("error", MessageType.ERROR)
            else
                controller.addGroup(groupNameField.text, *students)
        }
    }

    override fun setModel(model: Model) {
        this.model = model
        arrayOf("mat", "name", "surname", "group").forEach { tableModel.addColumn(it) }
        populateTable(*model.getStudents())
        (model as Observable).addObserver(this)
    }

    override fun showMessage(message: String, type: MessageType) {
        Frame.getInstance().showMessage(message, type)
    }

    override fun update(p0: Observable?, p1: Any?) {
        when (p1) {
            is Student -> populateTable(p1)
            is Group -> {
                tableModel.rowCount = 0
                populateTable(*(p0 as Model).getStudents())
            }
        }
    }

    private fun populateTable(vararg students: Student) {
        students
            .map {
                arrayOf(
                    it.id.toString(),
                    it.name,
                    it.surname,
                    if (it.group == null) "" else it.group!!.name
                )
            }
            .toTypedArray()
            .forEach { tableModel.addRow(it) }
    }
}