package views.swing

import Util.MessageType
import controllers.GroupsController
import model.Group
import model.Model
import model.WorkTrack
import java.awt.BorderLayout
import java.awt.GridLayout
import java.awt.TextArea
import java.awt.TextField
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Observable
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JScrollBar
import javax.swing.JScrollPane
import javax.swing.JTable
import javax.swing.JTextField
import javax.swing.table.DefaultTableModel

class GroupsView : views.GroupsView {
    private lateinit var model: Model
    private val root = JPanel()
    private val agenda = JButton("Agenda")
    private val students = JButton("Students")
    private val groupsJTable = JTable()
    private val tableModelGroups = groupsJTable.model as DefaultTableModel
    private val tracksJTable = JTable()
    private val tableModelTracks = tracksJTable.model as DefaultTableModel
    private val titleField = TextField()
    private val bodyField = TextArea()
    private val addTrack = JButton("Add Work Track")
    private val setTrack = JButton("Set Work Track")
    private val dateFiled = JTextField()
    private val addMeeting = JButton("Add Meeting")

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

                val tablesJPanel = JPanel()
                tablesJPanel {

                    val groupsTableTitleJPanel = JPanel()
                    groupsTableTitleJPanel {

                        val groupsTableJPanel = JPanel()
                        groupsTableJPanel {

                            val columbNameJPanel = JPanel()
                            columbNameJPanel {

                                layout = GridLayout(1, 2)
                                add(JLabel("Group Name"))
                                add(JLabel("Work Track"))
                            }

                            layout = BorderLayout()
                            add(columbNameJPanel, BorderLayout.NORTH)
                            add(JScrollPane(groupsJTable), BorderLayout.CENTER)
                        }

                        layout = BorderLayout()
                        add(JLabel("Tabbella studenti"), BorderLayout.NORTH)
                        add(groupsTableJPanel)
                    }


                    val trackTableTitleJPanel = JPanel()
                    trackTableTitleJPanel {

                        val trackTableJPanel = JPanel()
                        trackTableJPanel {

                            val columNameJPanel = JPanel()
                            columNameJPanel {

                                layout = GridLayout(1, 2)
                                add(JLabel("Title"))
                                add(JLabel("Body"))
                            }

                            layout = BorderLayout()
                            add(columNameJPanel, BorderLayout.NORTH)
                            add(JScrollPane(tracksJTable), BorderLayout.CENTER)
                        }

                        layout = BorderLayout()
                        add(JLabel("Tabbella work track"), BorderLayout.NORTH)
                        add(trackTableJPanel, BorderLayout.CENTER)
                    }


                    layout = GridLayout(2, 1)
                    add(groupsTableTitleJPanel)
                    add(trackTableTitleJPanel)
                }


                val controllJPanel = JPanel()
                controllJPanel {

                    val addTrackJPanel = JPanel()
                    addTrackJPanel {

                        val fieldJPanel = JPanel()
                        fieldJPanel {

                            val titleJPanel = JPanel()
                            titleJPanel {

                                layout = BorderLayout()
                                add(JLabel("Title"), BorderLayout.NORTH)
                                add(titleField, BorderLayout.CENTER)
                            }

                            val trackBodyJPanel = JPanel()
                            trackBodyJPanel {

                                layout = BorderLayout()
                                add(JLabel("Body"), BorderLayout.NORTH)
                                add(bodyField, BorderLayout.CENTER)
                            }

                            layout = BorderLayout()
                            add(titleJPanel, BorderLayout.NORTH)
                            add(trackBodyJPanel, BorderLayout.SOUTH)
                        }


                        layout = BorderLayout()
                        add(fieldJPanel, BorderLayout.CENTER)
                        add(addTrack, BorderLayout.SOUTH)
                    }

                    val meetingAndTrackeJPanel = JLabel()
                    meetingAndTrackeJPanel {

                        val meetingJPanel = JPanel()
                        meetingJPanel {

                            val dateJPanel = JPanel()
                            dateJPanel {

                                layout = BorderLayout()
                                add(JLabel("Date(dd-mm-yyyy)"), BorderLayout.NORTH)
                                add(dateFiled, BorderLayout.CENTER)
                            }

                            layout = BorderLayout()
                            add(dateJPanel, BorderLayout.NORTH)
                            add(addMeeting, BorderLayout.SOUTH)
                        }

                        layout = BorderLayout()
                        add(meetingJPanel, BorderLayout.CENTER)
                        add(setTrack, BorderLayout.SOUTH)
                    }


                    layout = GridLayout(2, 1)
                    add(meetingAndTrackeJPanel)
                    add(addTrackJPanel)
                }

                layout = BorderLayout()
                add(tablesJPanel, BorderLayout.CENTER)
                add(controllJPanel, BorderLayout.EAST)
            }

            layout = BorderLayout()
            add(bodyJPanel, BorderLayout.CENTER)
            add(navigationJPanel, BorderLayout.SOUTH)
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

        addTrack.addActionListener {
            controller.addWorkTrack(titleField.text, bodyField.text)
        }

        setTrack.addActionListener {
            val selectedGroups = groupsJTable.selectedRows
            val selectedTracks = tracksJTable.selectedRows
            if (selectedTracks.size != 1)
                showMessage("Selezionare una e una sola traccia", MessageType.ERROR)
            else if (selectedGroups.size != 1)
                showMessage("Selezionare uno e un solo gruppo", MessageType.ERROR)
            else
                controller.assignWork(selectedGroups[0], selectedTracks[0])
        }

        addMeeting.addActionListener {
            val selectedGroups = groupsJTable.selectedRows
            if (selectedGroups.size != 1 || dateFiled.text.isBlank())
                showMessage("error", MessageType.ERROR)
            else {
                val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
                try {
                    val date = simpleDateFormat.parse(dateFiled.text)
                    controller.addMeeting(selectedGroups[0], date, date)
                } catch (e: Exception) {
                    showMessage("Inserire la data nel formato corretto", MessageType.ERROR)
                }
            }
        }
    }

    override fun setModel(model: Model) {
        this.model = model
        (model as Observable).addObserver(this)

        arrayOf("name", "workTrack").forEach { tableModelGroups.addColumn(it) }
        populateGroupsTable(*model.getGroups())

        arrayOf("Title", "Body").forEach { tableModelTracks.addColumn(it) }
        populateTracksTable(*model.getWorkTracks())
    }

    override fun showMessage(message: String, type: MessageType) {
        Frame.getInstance().showMessage(message, type)
    }

    override fun update(p0: Observable?, p1: Any?) {
        when (p1) {
            is Group -> populateGroupsTable(p1)

            is WorkTrack -> populateTracksTable(p1)

            is Array<*> -> {
                tableModelGroups.rowCount = 0
                populateGroupsTable(*(p0 as Model).getGroups())
            }
        }
    }

    private fun populateGroupsTable(vararg groups: Group) {
        groups
            .map {
                arrayOf(
                    it.name,
                    if (it.work == null) "" else it.work!!.workTrack.title
                )
            }
            .toTypedArray()
            .forEach { tableModelGroups.addRow(it) }
    }

    private fun populateTracksTable(vararg tracks: WorkTrack) {
        tracks
            .map {
                arrayOf(
                    it.title,
                    it.body
                )
            }
            .toTypedArray()
            .forEach { tableModelTracks.addRow(it) }
    }
}