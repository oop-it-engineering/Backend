package org.example;

import org.example.controller.UserController;
import org.example.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener {
    private Main win;
    private JButton loginBtn, signupBtn;
    private JTextField idField;
    private UserController userController;
    private User user;

    public LoginPanel(Main win) {
        this.win = win;
        this.userController = new UserController();
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 중앙 패널
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Color customColor = new Color(0, 48, 135);

        // 제목 라벨
        JLabel titleLabel = new JLabel("IT공학과 기기 대여 시스템");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        SetupUI.setupGBC(gbc, 0, 0, 2, GridBagConstraints.CENTER);
        centerPanel.add(titleLabel, gbc);

        // 눈송이 이미지
        ImageIcon snowImageIcon = new ImageIcon(getClass().getResource("/images/snow_login.png"));
        JLabel snowImageLabel = new JLabel(snowImageIcon);
        SetupUI.setupGBC(gbc, 0, 1, 2, GridBagConstraints.CENTER);
        centerPanel.add(snowImageLabel, gbc);

        // 학번 라벨
        JLabel idFieldLabel = new JLabel("학번");
        idFieldLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        SetupUI.setupGBC(gbc, 0, 2, 1, GridBagConstraints.EAST);
        centerPanel.add(idFieldLabel, gbc);

        // 학번 필드
        idField = new JTextField();
        idField.setPreferredSize(new Dimension(490, 55));
        SetupUI.setupGBC(gbc, 1, 2, 1, GridBagConstraints.WEST);
        centerPanel.add(idField, gbc);

        // 로그인 버튼
        loginBtn = SetupUI.createButton("로그인", customColor, 20, 550, 70, this);
        SetupUI.setupGBC(gbc, 0, 3, 2, GridBagConstraints.CENTER);
        centerPanel.add(loginBtn, gbc);

        // 회원가입 버튼
        signupBtn = SetupUI.createButton("회원가입", customColor, 20, 550, 70, this);
        SetupUI.setupGBC(gbc, 0, 4, 2, GridBagConstraints.CENTER);
        centerPanel.add(signupBtn, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String userId = idField.getText();
            userController.userLogin(userId);
            User user = userController.getUser(userId);
            win.currentUser = user;
            System.out.println(win.currentUser.getUserName());
            win.change("대여/문의 선택 화면으로");
        } else if (e.getSource() == signupBtn) {
            win.change("회원가입 화면으로");
        }
    }
}
