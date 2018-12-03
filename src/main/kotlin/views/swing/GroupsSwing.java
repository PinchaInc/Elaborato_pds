package views.swing;

import Util.MessageType;
import controllers.GroupsController;
import model.Model;
import org.jetbrains.annotations.NotNull;
import views.GroupsView;

import javax.swing.*;

public class GroupsSwing implements GroupsView {
    private JPanel root;
    private JButton studentsBtn;
    private JButton agendaBtn;

    @Override
    public void start() {
        JFrame frame = Frame.getInstance().getFrame();
        frame.setContentPane(this.root);
        frame.pack();
    }

    @Override
    public void setController(@NotNull GroupsController controller) {
        studentsBtn.addActionListener(actionEvent -> controller.startStudents());
        agendaBtn.addActionListener(actionEvent -> controller.startAgenda());
    }

    @Override
    public void setModel(@NotNull Model model) {

    }

    @Override
    public void showMessage(@NotNull String message, @NotNull MessageType type) {

    }
}
