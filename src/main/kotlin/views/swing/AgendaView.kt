package views.swing

import Util.MessageType
import controllers.AgendaController
import model.Meeting
import model.Model
import views.AgendaView
import java.awt.BorderLayout
import java.awt.GridLayout
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar
import java.util.Observable
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.table.DefaultTableModel

class AgendaView : AgendaView {
    private lateinit var model: Model
    private val root = JPanel()
    private val groups = JButton("Groups")
    private val students = JButton("Students")
    private val meetingsJTable = JTable()
    private val meetingsModel = meetingsJTable.model as DefaultTableModel
    private var year = 0
    private var month = 0
    private val preYear = JButton("<")
    private val nextYear = JButton(">")
    private val preMonth = JButton("<")
    private val nextMouth = JButton(">")
    private val yearLabel = JLabel()
    private val monthLabel = JLabel()
    private val calendar = GregorianCalendar()

    init {
        calendar.time = Date()
        year = calendar.get(Calendar.YEAR)
        month = calendar.get(Calendar.MONTH)
        updateLabel()

        root {
            val navigationJPanel = JPanel()
            navigationJPanel {

                layout = GridLayout(1, 2)
                add(groups)
                add(students)
            }

            val bodyJPanel = JPanel()
            bodyJPanel {

                val calendarJPanel = JPanel()
                calendarJPanel {

                    val yearAndMonthJPanel = JPanel()
                    yearAndMonthJPanel {

                        val yearChooserJPanel = JPanel()
                        yearChooserJPanel {

                            preYear {
                                this as JButton
                                addActionListener {
                                    year--
                                    updateCalendar()
                                }
                            }

                            nextYear {
                                this as JButton
                                addActionListener {
                                    year++
                                    updateCalendar()
                                }
                            }

                            layout = GridLayout(1, 3)
                            add(preYear)
                            add(yearLabel)
                            add(nextYear)
                        }

                        val monthChooserJPanel = JPanel()
                        monthChooserJPanel {

                            preMonth {
                                this as JButton
                                addActionListener {
                                    month--
                                    updateCalendar()
                                }
                            }

                            nextMouth {
                                this as JButton
                                addActionListener {
                                    month++
                                    updateCalendar()
                                }
                            }

                            layout = GridLayout(1, 3)
                            add(preMonth)
                            add(monthLabel)
                            add(nextMouth)
                        }

                        layout = GridLayout(1, 2)
                        add(yearChooserJPanel)
                        add(monthChooserJPanel)
                    }

                    val tableJPanel = JPanel()
                    tableJPanel {

                        val columJPanel = JPanel()
                        columJPanel {

                            layout = GridLayout(1, 2)
                            add(JLabel("Day"))
                            add(JLabel("Group"))
                        }

                        layout = BorderLayout()
                        add(columJPanel, BorderLayout.NORTH)
                        add(meetingsJTable, BorderLayout.CENTER)
                    }

                    layout = BorderLayout()
                    add(yearAndMonthJPanel, BorderLayout.NORTH)
                    add(tableJPanel, BorderLayout.CENTER)
                }

                add(calendarJPanel)
            }

            layout = BorderLayout()
            add(navigationJPanel, BorderLayout.NORTH)
            add(bodyJPanel, BorderLayout.CENTER)
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
        arrayOf("Day", "Group").forEach { meetingsModel.addColumn(it) }
        populateTable(
            *filterMeetings(
                model.getMeetings()
            )
        )
    }

    override fun showMessage(message: String, type: MessageType) {
        Frame.getInstance().showMessage(message, type)
    }

    override fun update(p0: Observable?, p1: Any?) {
        when (p1) {
            is Meeting -> updateCalendar()
        }
    }

    private fun populateTable(vararg meetings: Meeting) {
        meetings
            .map {
                calendar.time = it.start
                arrayOf(
                    calendar.get(Calendar.DAY_OF_MONTH),
                    it.group.name
                )
            }
            .toTypedArray()
            .forEach { meetingsModel.addRow(it) }
    }

    private fun filterMeetings(meetings: Array<Meeting>): Array<Meeting> {
        return meetings
            .filter {
                calendar.time = it.start
                calendar.get(Calendar.MONTH) == month && calendar.get(Calendar.YEAR) == year }
            .toTypedArray()
    }

    private fun updateLabel() {
        if (month == 12) {
            month = 0
            year++
        }
        if (month == -1) {
            month = 11
            year--
        }
        yearLabel.text = year.toString()
        monthLabel.text = (month+1).toString()
    }

    private fun updateCalendar() {
        meetingsModel.rowCount = 0
        updateLabel()
        populateTable(
            *filterMeetings(
                model.getMeetings()
            )
        )
    }
}