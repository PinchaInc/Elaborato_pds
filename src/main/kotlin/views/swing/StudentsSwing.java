package views.swing;

import Util.MessageType;
import controllers.StudentsController;
import model.Model;
import org.jetbrains.annotations.NotNull;
import views.StudentsView;

import javax.swing.*;
import java.awt.*;

public class StudentsSwing implements StudentsView {
    private Model model;
    private StudentsController controller;

    private JPanel root;
    private JButton groupsBtn;
    private JButton agendaBtn;
    private JList studentsList;
    private JButton newStudentBtn;
    private JButton nextBtn;

    @Override
    public void start() {
        JFrame frame = Frame.getInstance().getFrame();
        frame.setContentPane(this.root);
        frame.pack();
    }

    @Override
    public void setController(@NotNull StudentsController controller) {
        this.controller = controller;
        agendaBtn.addActionListener(actionEvent -> controller.startAgenda());
        groupsBtn.addActionListener(actionEvent -> controller.startGroups());
    }

    @Override
    public void setModel(@NotNull Model model) {
        this.model = model;
    }

    @Override
    public void showMessage(@NotNull String message, @NotNull MessageType type) {

    }

    @Override
    public void insertNewStudentData() {

    }

    @Override
    public void selectStudent() {

    }

    @Override
    public void insertName() {

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        root = new JPanel();
        root.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Studneti");
        root.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        agendaBtn = new JButton();
        agendaBtn.setText("Agenda");
        root.add(agendaBtn, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return root;
    }
}
