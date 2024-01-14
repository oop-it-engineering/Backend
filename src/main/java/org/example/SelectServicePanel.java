package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectServicePanel extends JPanel implements ActionListener {
    private Main win;
    private JButton rentBtn, inquiryBtn, backBtn, myPageBtn;

    public SelectServicePanel(Main win) {
        this.win = win;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 상단 패널
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        // 버튼 패널: 뒤로 가기 및 마이페이지 버튼
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

        // 마이페이지 버튼
        ImageIcon myPageIcon = new ImageIcon(getClass().getResource("/images/mypage.png"));
        Image myPageIconScaled = myPageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        myPageBtn = new JButton(new ImageIcon(myPageIconScaled));
        myPageBtn.addActionListener(this);
        myPageBtn.setBorderPainted(false);
        myPageBtn.setContentAreaFilled(false);
        myPageBtn.setMargin(new Insets(5, 5, 0, 0));
        buttonPanel.add(myPageBtn);
        topPanel.add(buttonPanel, BorderLayout.WEST);

        // 눈송이님, 환영합니다!
        if (win.currentUser != null) {
            JLabel welcomeLabel = new JLabel(win.currentUser.getUserName() + "님, 환영합니다!", SwingConstants.RIGHT);
            welcomeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
            welcomeLabel.setBorder(new EmptyBorder(-13, 0, 0, 15));
            topPanel.add(welcomeLabel, BorderLayout.EAST);
            add(topPanel, BorderLayout.NORTH);
        }else {
            JLabel welcomeLabel = new JLabel("눈송이" + "님, 환영합니다!", SwingConstants.RIGHT);
            welcomeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
            welcomeLabel.setBorder(new EmptyBorder(-13, 0, 0, 15));
            topPanel.add(welcomeLabel, BorderLayout.EAST);
            add(topPanel, BorderLayout.NORTH);
        }


        // 중앙 패널
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Color customColor = new Color(0, 48, 135);

        // 홈 이미지
        ImageIcon homeIcon = new ImageIcon(getClass().getResource("/images/home.png"));
        Image scaledHomeImage = homeIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        homeIcon = new ImageIcon(scaledHomeImage);
        JLabel homeLabel = new JLabel(homeIcon);
        SetupUI.setupGBC(gbc, 0, 0, 3, GridBagConstraints.CENTER);
        gbc.insets = new Insets(0, 0, 30, 0);
        centerPanel.add(homeLabel, gbc);

        // 대여하기 버튼
        rentBtn = SetupUI.createButton("대여하기", customColor, 25, 550, 100, this);
        SetupUI.setupGBC(gbc, 0, 1, 3, GridBagConstraints.CENTER);
        centerPanel.add(rentBtn, gbc);

        // 문의하기 버튼
        inquiryBtn = SetupUI.createButton("문의하기", customColor, 25,550, 100, this);
        SetupUI.setupGBC(gbc, 0, 2, 3, GridBagConstraints.CENTER);
        centerPanel.add(inquiryBtn, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("로그인 화면으로");
        } else if (e.getSource() == rentBtn) {
            win.change("기기 선택 화면으로");
        } else if (e.getSource() == myPageBtn) {
            this.win.change("마이페이지 수령 대기 화면으로");
        } else if (e.getSource() == inquiryBtn) {
            JDialog dialog = new JDialog(win, "문의하기");
            dialog.setLayout(new BorderLayout());
            dialog.setSize(330, 360);
            dialog.getContentPane().setBackground(Color.WHITE);

            // QR 코드 이미지
            ImageIcon qrCode = new ImageIcon(getClass().getResource("/images/qrcode.png"));
            JLabel qrCodeLabel = new JLabel(qrCode);
            qrCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // 타이머 라벨
            JLabel timerLabel = new JLabel("15초 후에 자동으로 닫힙니다.", SwingConstants.CENTER);
            timerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));

            dialog.add(qrCodeLabel, BorderLayout.CENTER);
            dialog.add(timerLabel, BorderLayout.SOUTH);

            // 타이머 쓰레드 시작
            Thread thread = new Thread(new Runnable() {
                private int count = 15;

                @Override
                public void run() {
                    while (count >= 0) {
                        try {
                            SwingUtilities.invokeLater(() -> timerLabel.setText(count + "초 후에 자동으로 닫힙니다."));
                            Thread.sleep(1000); // 1초 대기
                            count--;
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    dialog.dispose(); // 다이얼로그 닫기
                }
            });

            thread.start(); // 쓰레드 시작
            dialog.setVisible(true); // 다이얼로그 보여주기
        }
    }
}
