package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlertDialog extends JDialog {
    public AlertDialog(JFrame parent, String title, String message) {
        super(parent, title, true);

        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);
        setSize(400, 200);
        setLocationRelativeTo(parent);

        // 메시지 라벨
        JLabel messageLabel = new JLabel(message, SwingConstants.CENTER);
        messageLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        add(messageLabel, BorderLayout.CENTER);

        // 버튼
        JButton okButton = new JButton("OK");
        okButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        okButton.setForeground(Color.WHITE);
        okButton.setBackground(new Color(0, 48, 135));
        okButton.setOpaque(true);
        okButton.setContentAreaFilled(true); // 여기를 true로 변경!!
        okButton.setBorderPainted(false);
        okButton.setPreferredSize(new Dimension(100, 50));
        okButton.setFocusPainted(false);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // 다이얼로그 닫기
            }
        });
        add(okButton, BorderLayout.SOUTH);
    }

    public static void showDialog(JFrame parent, String title, String message) {
        AlertDialog alertDialog = new AlertDialog(parent, title, message);
        alertDialog.setVisible(true);
    }
}
