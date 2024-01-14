package org.example;


import org.example.entity.User;

import javax.swing.*;

public class Main extends JFrame {
    public LoginPanel loginPanel = null;
    public SignupPanel signupPanel = null;
    public SelectServicePanel selectServicePanel = null;
    public SelectEquipPanel selectEquipPanel = null;
    public ListLaptopPanel listLaptopPanel = null;
    public ListPadPanel listPadPanel = null;
    public ListMobilePanel listMobilePanel = null;
    public ListOtherPanel listOtherPanel = null;
    public MyPagePanel_1 myPagePanel1 = null;
    public MyPagePanel_2 myPagePanel2 = null;
    public ResLaptopPanel_1 resLaptopPanel1 = null;
    public ResLaptopPanel_2 resLaptopPanel2 = null;
    public ResMobilePanel_1 resMobilePanel1 = null;
    public ResMobilePanel_2 resMobilePanel2 = null;
    public ResOtherPanel resOtherPanel= null;
    public ResPadPanel_1 resPadPanel1= null;
    public ResPadPanel_2 resPadPanel2= null;

    public static User currentUser = null;


    public void change(String panelName) {

        if (panelName.equals("로그인 화면으로")) {
            getContentPane().removeAll();
            getContentPane().add(new LoginPanel(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("회원가입 화면으로")) {
            getContentPane().removeAll();
            getContentPane().add(new SignupPanel(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("대여/문의 선택 화면으로")) {
            getContentPane().removeAll();
            getContentPane().add(new SelectServicePanel(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("기기 선택 화면으로")) {
            getContentPane().removeAll();
            getContentPane().add(new SelectEquipPanel(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("랩탑 선택 화면으로")) {
            getContentPane().removeAll();
            getContentPane().add(new ListLaptopPanel(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("패드 선택 화면으로")) {
            getContentPane().removeAll();
            getContentPane().add(new ListPadPanel(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("모바일 기기 선택 화면으로")) {
            getContentPane().removeAll();
            getContentPane().add(new ListMobilePanel(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("기타 기기 선택 화면으로")) {
            getContentPane().removeAll();
            getContentPane().add(new ListOtherPanel(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("랩탑")) {
            getContentPane().removeAll();
            getContentPane().add(new ResLaptopPanel_1(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("랩탑2")) {
            getContentPane().removeAll();
            getContentPane().add(new ResLaptopPanel_2(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("모바일")) {
            getContentPane().removeAll();
            getContentPane().add(new ResMobilePanel_1(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("모바일2")) {
            getContentPane().removeAll();
            getContentPane().add(new ResMobilePanel_2(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("패드")) {
            getContentPane().removeAll();
            getContentPane().add(new ResPadPanel_1(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("패드2")) {
            getContentPane().removeAll();
            getContentPane().add(new ResPadPanel_2(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("기타 기기")) {
            getContentPane().removeAll();
            getContentPane().add(new ResOtherPanel(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("마이페이지 수령 대기 화면으로")) {
            getContentPane().removeAll();
            getContentPane().add(new MyPagePanel_1(this));
            revalidate();
            repaint();
        }
        else if (panelName.equals("마이페이지 대여중 화면으로")) {
            getContentPane().removeAll();
            getContentPane().add(new MyPagePanel_2(this));
            revalidate();
            repaint();
        }

    }


    public static void main(String[] args) {
        Main win = new Main();
        win.setTitle("IT공학과 기기 대여 시스템");
        win.loginPanel = new LoginPanel(win);
        win.signupPanel = new SignupPanel(win);
        win.selectServicePanel = new SelectServicePanel(win);
        win.selectEquipPanel = new SelectEquipPanel(win);
        win.listLaptopPanel = new ListLaptopPanel(win);
        win.listPadPanel = new ListPadPanel(win);
        win.listMobilePanel = new ListMobilePanel(win);
        win.listOtherPanel = new ListOtherPanel(win);
        win.resLaptopPanel1 = new ResLaptopPanel_1(win);
        win.resLaptopPanel2 = new ResLaptopPanel_2(win);
        win.resMobilePanel1 = new ResMobilePanel_1(win);
        win.resMobilePanel2 = new ResMobilePanel_2(win);
        win.resOtherPanel = new ResOtherPanel(win);
        win.resPadPanel1 = new ResPadPanel_1(win);
        win.resPadPanel2 = new ResPadPanel_2(win);
        win.myPagePanel1 = new MyPagePanel_1(win);
        win.myPagePanel2 = new MyPagePanel_2(win);

        win.add(win.loginPanel);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(860, 740); // 크기수정
        win.setVisible(true);
        win.setResizable(true); // 최대화 설정 여부
    }
}