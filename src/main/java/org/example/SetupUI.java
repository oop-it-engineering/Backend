package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SetupUI {
    // GridBagConstraints 설정 메서드
    public static void setupGBC(GridBagConstraints gbc, int x, int y, int width, int fill) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.fill = fill;
        gbc.insets = new Insets(12, 10, 12, 10);
    }

    public static JButton createButton(String text, Color color, int fontSize, int width, int height, ActionListener listener) {
        JButton button = new JButton(text);
        button.setFont(new Font("맑은 고딕", Font.BOLD, fontSize));
        button.setPreferredSize(new Dimension(width, height));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setOpaque(true);
        button.setContentAreaFilled(true); // 여기를 true로 변경!!
        button.setBorderPainted(false);
        button.addActionListener(listener);
        return button;
    }
}
