package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectEquipPanel extends JPanel implements ActionListener {
    private Main win;
    private JButton laptopBtn, padBtn, mobileBtn, otherBtn, backBtn;

    public SelectEquipPanel(Main win) {
        this.win = win;
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
        backBtn.setMargin(new Insets(10, 10, 0, 0));
        buttonPanel.add(backBtn);
        topPanel.add(buttonPanel, BorderLayout.WEST);

        // 눈송이님, 환영합니다!
        if (win.currentUser != null) {
            JLabel welcomeLabel = new JLabel(win.currentUser.getUserName() + "님, 환영합니다!", SwingConstants.RIGHT);
            welcomeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
            welcomeLabel.setBorder(new EmptyBorder(-6, 0, 0, 15));
            topPanel.add(welcomeLabel, BorderLayout.EAST);
            add(topPanel, BorderLayout.NORTH);
        } else {
            JLabel welcomeLabel = new JLabel("님, 환영합니다!", SwingConstants.RIGHT);
            welcomeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
            welcomeLabel.setBorder(new EmptyBorder(-6, 0, 0, 15));
            topPanel.add(welcomeLabel, BorderLayout.EAST);
            add(topPanel, BorderLayout.NORTH);
        }


        // 중앙 패널
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        Color customColor = new Color(0, 48, 135);

        // 제목 라벨
        JLabel title = new JLabel("기기 선택");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        SetupUI.setupGBC(gbc, 0, 0, 2, GridBagConstraints.CENTER);
        gbc.insets = new Insets(0, 0, 40, 0);
        centerPanel.add(title, gbc);

        // 랩탑 버튼
        laptopBtn = SetupUI.createButton("랩탑", customColor, 25, 250, 150, this);
        SetupUI.setupGBC(gbc, 0, 1, 1, GridBagConstraints.HORIZONTAL);
        centerPanel.add(laptopBtn, gbc);

        // 패드 버튼
        padBtn = SetupUI.createButton("패드", customColor, 25, 250, 150, this);
        SetupUI.setupGBC(gbc, 1, 1, 1, GridBagConstraints.HORIZONTAL);
        centerPanel.add(padBtn, gbc);

        // 모바일 기기 버튼
        mobileBtn = SetupUI.createButton("모바일 기기", customColor, 25, 250, 150, this);
        SetupUI.setupGBC(gbc, 0, 2, 1, GridBagConstraints.HORIZONTAL);
        centerPanel.add(mobileBtn, gbc);

        // 기타 기기 버튼
        otherBtn = SetupUI.createButton("<html>기타 기기<br/>(아두이노)</html>", customColor, 25, 250, 150, this);
        SetupUI.setupGBC(gbc, 1, 2, 1, GridBagConstraints.HORIZONTAL);
        centerPanel.add(otherBtn, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("대여/문의 선택 화면으로");
        }
        else if (e.getSource() == laptopBtn) {
            win.change("랩탑 선택 화면으로");
        }
        else if (e.getSource() == padBtn) {
            win.change("패드 선택 화면으로");
        }
        else if (e.getSource() == mobileBtn) {
            win.change("모바일 기기 선택 화면으로");
        }
        else if (e.getSource() == otherBtn) {
            win.change("기타 기기 선택 화면으로");
        }
    }
}