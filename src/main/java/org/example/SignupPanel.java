package org.example;

import org.example.entity.User;
import org.example.controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupPanel extends JPanel implements ActionListener {
    private Main win;
    private JButton signinBtn, backBtn;
    private JTextField nameField, idField;
    private UserController userController;

    public SignupPanel(Main win) {
        this.win = win;
        this.userController = new UserController();
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 상단 패널
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        // 버튼 패널
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setOpaque(false);

        // 뒤로 가기 버튼
        ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/back.png"));
        Image backIconScaled = backIcon.getImage().getScaledInstance(48, 38, Image.SCALE_SMOOTH);
        backBtn = new JButton(new ImageIcon(backIconScaled));
        backBtn.addActionListener(this);
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setMargin(new Insets(0, 10, 0, 0));
        buttonPanel.add(backBtn);
        topPanel.add(buttonPanel, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);

        // 중앙 패널
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Color customColor = new Color(0, 48, 135);

        // 제목 라벨
        JLabel title = new JLabel("회원가입");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        SetupUI.setupGBC(gbc, 0, 0, 3, GridBagConstraints.CENTER);
        centerPanel.add(title, gbc);

        // 눈송이 이미지
        ImageIcon snowIcon = new ImageIcon(getClass().getResource("/images/snow_signup.png"));
        JLabel snowLabel = new JLabel(snowIcon);
        SetupUI.setupGBC(gbc, 0, 1, 3, GridBagConstraints.CENTER);
        centerPanel.add(snowLabel, gbc);

        // 학번 라벨
        JLabel idLabel = new JLabel("학번");
        idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        SetupUI.setupGBC(gbc, 0, 2, 1, GridBagConstraints.CENTER);
        centerPanel.add(idLabel, gbc);

        // 학번 필드
        idField = new JTextField();
        idField.setPreferredSize(new Dimension(480, 55));
        SetupUI.setupGBC(gbc, 1, 2, 1, GridBagConstraints.BOTH);
        centerPanel.add(idField, gbc);

        // 이름 라벨
        JLabel nameLabel = new JLabel("이름");
        nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        SetupUI.setupGBC(gbc, 0, 3, 1, GridBagConstraints.CENTER);
        centerPanel.add(nameLabel, gbc);

        // 이름 필드
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(490, 55));
        SetupUI.setupGBC(gbc, 1, 3, 1, GridBagConstraints.BOTH);
        centerPanel.add(nameField, gbc);

        // 완료 버튼
        signinBtn = SetupUI.createButton("완료", customColor, 20, 550, 70, this);
        SetupUI.setupGBC(gbc, 0, 4, 3, GridBagConstraints.CENTER);
        centerPanel.add(signinBtn, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("로그인 화면으로");
        } else if (e.getSource() == signinBtn) {
            AlertDialog.showDialog(win, "알림", "회원가입이 완료되었습니다!");
            User newUser = new User(idField.getText(),nameField.getText());
            userController.userJoin(newUser);
            win.change("로그인 화면으로");
        }
    }
}
