package org.example;

import org.example.controller.ReservationController;
import org.example.entity.Device;
import org.example.entity.Reservation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyPagePanel_1 extends JPanel implements ActionListener {
    private Main win;
    private JButton confirmed, renting, backBtn;
    private ReservationController reservationController;

    private Device device;
    public MyPagePanel_1(Main win) {
        this.win = win;
        this.reservationController = new ReservationController();
        this.device = new Device();
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
            JLabel welcomeLabel = new JLabel(win.currentUser.getUserName()+ "님, 환영합니다!", SwingConstants.RIGHT);
            welcomeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
            welcomeLabel.setBorder(new EmptyBorder(-6, 0, 0, 15));
            topPanel.add(welcomeLabel, BorderLayout.EAST);
            add(topPanel, BorderLayout.NORTH);
        } else {
            JLabel welcomeLabel = new JLabel("눈송이"+ "님, 환영합니다!", SwingConstants.RIGHT);
            welcomeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
            welcomeLabel.setBorder(new EmptyBorder(-6, 0, 0, 15));
            topPanel.add(welcomeLabel, BorderLayout.EAST);
            add(topPanel, BorderLayout.NORTH);

        }

        // 중앙 패널
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        Color onColor = new Color(184, 207, 229);
        Color offColor = new Color(0, 48, 135);

        // 제목 라벨
        JLabel title = new JLabel("마이페이지");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        SetupUI.setupGBC(gbc, 0, 0, 2, GridBagConstraints.CENTER);
        gbc.insets = new Insets(0, 0, 40, 0);
        centerPanel.add(title, gbc);

        // 수령 대기 버튼
        confirmed = SetupUI.createButton("수령 대기", onColor, 20, 175, 40, this);
        SetupUI.setupGBC(gbc, 0, 1, 1, GridBagConstraints.CENTER);
        centerPanel.add(confirmed, gbc);

        // 대여중 버튼
        renting = SetupUI.createButton("대여중", offColor, 20, 175, 40, this);
        SetupUI.setupGBC(gbc, 1, 1, 1, GridBagConstraints.CENTER);
        centerPanel.add(renting, gbc);

        // 기기 목록 패널
        Font infoFont = new Font("맑은 고딕", Font.PLAIN, 16);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        List<Reservation> reservations = null;

        if (win.currentUser != null) {
            reservations = reservationController.getRes(win.currentUser.getUserId());
        } else {
            Device dummyDevice = new Device();
            dummyDevice.setdName("Dummy Device Name");
            dummyDevice.setdVersion("Dummy OS Version");
            dummyDevice.setdCpu("Dummy CPU");
            dummyDevice.setdRam("Dummy RAM");

            Reservation dummyReservation = new Reservation();
            dummyReservation.setDevice(dummyDevice);

            reservations = new ArrayList<>();
            reservations.add(dummyReservation);
        }

        for (int i = 0; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            Device device = reservation.getDevice();

            // 기기 정보 패널 설정
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setOpaque(false);

            JLabel nameLabel = new JLabel("Device Name: " + device.getdName());
            nameLabel.setFont(infoFont);
            infoPanel.add(nameLabel);

            JLabel osLabel = new JLabel("OS: " + device.getdVersion());
            osLabel.setFont(infoFont);
            infoPanel.add(osLabel);

            JLabel cpuLabel = new JLabel("CPU: " + device.getdCpu());
            cpuLabel.setFont(infoFont);
            infoPanel.add(cpuLabel);

            JLabel ramLabel = new JLabel("RAM: " + device.getdRam());
            ramLabel.setFont(infoFont);
            infoPanel.add(ramLabel);

            JLabel statusLabel = new JLabel("Status: " + "수령 대기");
            statusLabel.setFont(infoFont);
            infoPanel.add(statusLabel);

            // 각 기기를 새 행에 배치
            gbc.gridx = 0; // 첫 번째 열
            gbc.gridy = i + 2; // 행은 제목 및 버튼 아래 시작

            gbc.gridx = 1; // 두 번째 열
            centerPanel.add(infoPanel, gbc);

        }

        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("대여/문의 선택 화면으로");
        }
        else if (e.getSource() == renting) {
            win.change("마이페이지 대여중 화면으로");
        }
    }

}


