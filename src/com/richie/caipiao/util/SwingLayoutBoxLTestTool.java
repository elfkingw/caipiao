package com.richie.caipiao.util;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ���ܣ�
 * 
 * @author wzj
 * 
 */
public class SwingLayoutBoxLTestTool extends JFrame implements ActionListener {

    // ���尴Ť���鲢��ʼ��
    private JButton[] jbArray = { new JButton("��Ť1"), new JButton("��Ť2"),
	    new JButton("��Ť3"), new JButton("��Ť4") };

    // ��������Box����
    private Box b1 = Box.createHorizontalBox();

    // ��������Box����
    private Box b2 = Box.createVerticalBox();

    public SwingLayoutBoxLTestTool() {
	// ��������Box��ӽ�����
	this.add(b1);
	// ������������Box����ӿؼ�=====================
	// ��Ӹ߶�Ϊ200�Ĵ�ֱ֧��
	b1.add(Box.createVerticalStrut(200));
	// ��Ӱ�ť1
	b1.add(jbArray[0]);
	// ��ӳ���Ϊ40��ˮƽ֧��
	b1.add(Box.createHorizontalStrut(40));
	// ��Ӱ�ť2
	b1.add(jbArray[1]);
	// ���ˮƽ��ˮ
	b1.add(Box.createHorizontalGlue());
	// ���Ƕ�׵�����Box����
	b1.add(b2);
	// �������ڲ�Ƕ������Box����ӿؼ�==================
	// ��ӿ��Ϊ100���߶�Ϊ20�Ĺ̶�����
	b2.add(Box.createRigidArea(new Dimension(100, 20)));
	// ��Ӱ�ť3
	b2.add(jbArray[2]);
	// ��Ӵ�ֱ��ˮ
	b2.add(Box.createVerticalGlue());
	// ��Ӱ�ť4
	b2.add(jbArray[3]);
	// ��ӳ���Ϊ40�Ĵ�ֱ֧��
	b2.add(Box.createVerticalStrut(40));
	// ���ô���Ĺرն��������⡢��Сλ���Լ��ɼ��Ե�
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("��ʽ����ʾ��");
	this.setBounds(100, 100, 400, 200);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
         * ���� Javadoc��
         * 
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
    public void actionPerformed(ActionEvent e) {
	// TODO �Զ����ɷ������

    }

    /**
         * 
         * @param args
         */
    public static void main(String[] args) {
	new SwingLayoutBoxLTestTool();

    }

}
