package com.aptech.LoanProcessingSystem.database;

import java.awt.Component;

import javax.swing.JOptionPane;

public class MessageDialog {

	public static void showMessageDialog(Component parent, String content, String title) {
        JOptionPane.showMessageDialog(parent, title, content, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showErrorMessage(Component parent, String content, String title) {
        JOptionPane.showMessageDialog(parent, title, content, JOptionPane.ERROR_MESSAGE);
    }

    public static int showConfirmMessage(Component parent, String content, String title) {
        int choose = JOptionPane.showConfirmDialog(parent, title, content,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose;
    }


}
