package views.swing;

import Util.MessageType;
import controllers.LoginController;
import model.Model;
import org.jetbrains.annotations.NotNull;
import views.LoginView;

import javax.swing.*;

public class LoginSwing implements LoginView {
    private JPanel root;
    private JButton clearBtn;
    private JButton loginBtn;
    private JTextField usernameTf;
    private JPasswordField passwordTf;
    private JPanel fields;
    private JLabel usernameLb;
    private JLabel passwordLb;
    private Model model;


    @Override
    public void start() {
        JFrame frame = Frame.getInstance().getFrame();
        frame.setContentPane(this.root);
        frame.pack();
        clearBtn.addActionListener(actionEvent -> {
            usernameTf.setText("");
            passwordTf.setText("");
        });
    }

    @Override
    public void setController(@NotNull LoginController controller) {
        loginBtn.addActionListener(actionEvent -> controller.authenticate(
                usernameTf.getText(),
                passwordTf.getText()
        ));
    }

    @Override
    public void setModel(@NotNull Model model) {
        this.model = model;
    }

    @Override
    public void showMessage(@NotNull String message, @NotNull MessageType type) {
        if (type.equals(MessageType.ERROR))
            System.err.println(message);
        else
            System.out.println(message);
    }
}
