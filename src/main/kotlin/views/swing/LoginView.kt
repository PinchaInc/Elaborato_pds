package views.swing

import Util.MessageType
import controllers.LoginController
import model.Model
import views.LoginView
import java.awt.Dimension
import java.awt.GridLayout
import java.lang.Exception
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JPasswordField
import javax.swing.JTextField

class LoginView : LoginView {

    private lateinit var model: Model
    private val root = JPanel()
    private val clear = JButton("clear")
    private val login = JButton("login")
    private val username = JTextField()
    private val password = JPasswordField()

    init {
        root {
            val usernameJPanel = JPanel()
            usernameJPanel {
                layout = GridLayout(2, 1)
                add(JLabel("Username"))
                add(username)
            }

            val passwordJPanel = JPanel()
            passwordJPanel {
                layout = GridLayout(2, 1)
                add(JLabel("Password"))
                add(password)
            }

            val buttonJPanel = JPanel()
            buttonJPanel {
                clear {
                    preferredSize = Dimension(250, 50)
                }

                login {
                    preferredSize = Dimension(250, 50)
                }

                layout = GridLayout(1, 2)
                add(clear)
                add(login)
            }

            layout = GridLayout(3, 1)
            add(usernameJPanel)
            add(passwordJPanel)
            add(buttonJPanel)
        }
    }

    override fun start() {
        val frame = Frame.getInstance().frame
        frame.contentPane = this.root
        frame.pack()
    }

    override fun setController(controller: LoginController) {
        clear.addActionListener {
            username.text = ""
            password.text = ""
        }

        login.addActionListener {
            try {
                controller.authenticate(username.text.toInt(), password.text)
            } catch (e: Exception) {
                showMessage("error", MessageType.ERROR)
            }
        }
    }

    override fun setModel(model: Model) {
        this.model = model
    }

    override fun showMessage(message: String, type: MessageType) {
        Frame.getInstance().showMessage(message, type)
    }
}