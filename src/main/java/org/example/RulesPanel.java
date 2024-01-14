package org.example;

import org.example.controller.ReservationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class RulesPanel extends JDialog {
    private JTextArea rulesTextArea;
    private JButton agreeButton;
    private JLabel timerLabel;
    private int timeLeft = 15; // 타이머 시간 15초 설정
    private Timer timer;
    private ReservationController reservationController;
    private int deviceId;
    private String userId;
    private String resConfTime;



    public RulesPanel(Frame parent,
                      ReservationController reservationController, int deviceId, String userId, String resConfTime) {
        super(parent, "규정 확인", true);
        this.reservationController = reservationController;
        this.deviceId = deviceId;
        this.userId = userId;
        this.resConfTime = resConfTime;
        components();
        rulesLayout();
        rulesListeners();
        startTimer(); // 타이머 시작
    }

    private void components() {
        rulesTextArea = new JTextArea(20, 40);
        String rulesText = "1. 기기는 예약한 날짜로부터 3일 이내에 학과 사무실에서 수령해야만 합니다.\n\n" +
                "2. 대여 기간은 총 7일입니다.\n\n" +
                "3. 같은 종류의 기기를 이미 대여/예약한 경우 새로운 예약이 불가능합니다.\n\n" +
                "4. 장기 휴학하는 경우(3학기 이상) 기기를 반납해야 합니다.\n\n" +
                "5. 물품 번호가 적혀 있는 라벨지는 보존이 필수적이며, 라벨이 떨어질 경우 학과에 연락을 취해야 합니다.\n\n" +
                "6. 기기 손상 및 분실 시 마이페이지의 내 기기 항목에서 신고를 한 후 학과사무실에 방문해야 합니다.\n\n" +
                "7. 기기 반납 시 검사용 설문조사에 참여해야 합니다.";
        rulesTextArea.setText(rulesText);
        rulesTextArea.setEditable(false);
        rulesTextArea.setWrapStyleWord(true);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rulesTextArea.setFont(new Font("맑은 고딕", Font.PLAIN, 13));

        agreeButton = new JButton("동의");
        agreeButton.setBackground(new Color(0, 48, 135));
        agreeButton.setOpaque(true);
        agreeButton.setBorderPainted(false);
        agreeButton.setForeground(Color.WHITE);
        agreeButton.setFont(new Font("맑은 고딕", Font.BOLD, 13));

    }

    private void rulesLayout() {
        setLayout(new BorderLayout());
        add(new JScrollPane(rulesTextArea), BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(agreeButton);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getParent());
    }

    private void rulesListeners() {
        agreeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 예약을 진행합니다.
                int result = reservationController.reservation(deviceId, userId, resConfTime);
                if (result == 1) {
                    JOptionPane.showMessageDialog(RulesPanel.this,
                            "예약/대여되었습니다.",
                            "확인",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(RulesPanel.this,
                            "예약에 실패했습니다.",
                            "오류",
                            JOptionPane.ERROR_MESSAGE);
                }
                stopTimer(); // 동의 버튼을 클릭 시 타이머 중지.
                dispose(); // 다이얼로그 닫기
            }
        });
    }



    private void startTimer() {
        timerLabel = new JLabel("남은 시간: " + timeLeft);
        timerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        timerLabel.setForeground(Color.BLUE);
        add(timerLabel, BorderLayout.NORTH);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            timerLabel.setText("남은 시간: " + timeLeft);
                        }
                    });
                } else {
                    timer.stop(); // 타이머 종료 시
                    dispose(); // 다이얼로그 닫기
                }
            }
        });

        timer.start(); // 타이머 시작
    }

    private void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }

}
