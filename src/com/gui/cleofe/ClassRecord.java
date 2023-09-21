package com.gui.cleofe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClassRecord extends JFrame implements FocusListener, ActionListener {

	private JPanel wrapperPanel, computationPanel, headerPanel;
	private JTextField labTxt, projTtxt, quizTxt, examsTxt, totalTxt, gradeTxt;
	private JLabel headerLbl;
	private JButton computeBtn, resetBtn;
	private Color lightYellow = new Color(255, 222, 89);
	private Color black = new Color(0, 0, 0);
	private Color grey59 = new Color(150, 150, 150);

	public ClassRecord(String title) {
		super(title);

		wrapperPanel = new JPanel();
		computationPanel = new JPanel();
		headerPanel = new JPanel();

		labTxt = new JTextField("Laboratory Experiments");
		projTtxt = new JTextField("Project");
		quizTxt = new JTextField("Quizzes");
		examsTxt = new JTextField("Major Exams");
		totalTxt = new JTextField("TOTAL");
		headerLbl = new JLabel("Class Record");
		gradeTxt = new JTextField("0");
		computeBtn = new JButton("Compute");
		resetBtn = new JButton("Reset");

		// font style
		headerLbl.setFont(new Font("Open Sans Extrabold", Font.BOLD, 32));
		labTxt.setFont(new Font("Open Sans Extrabold", Font.BOLD, 16));
		projTtxt.setFont(new Font("Open Sans Extrabold", Font.BOLD, 16));
		quizTxt.setFont(new Font("Open Sans Extrabold", Font.BOLD, 16));
		examsTxt.setFont(new Font("Open Sans Extrabold", Font.BOLD, 16));
		totalTxt.setFont(new Font("Open Sans Extrabold", Font.BOLD, 16));
		gradeTxt.setFont(new Font("Open Sans Extrabold", Font.BOLD, 16));
		computeBtn.setFont(new Font("Open Sans Extrabold", Font.BOLD, 16));
		resetBtn.setFont(new Font("Open Sans Extrabold", Font.BOLD, 16));

		// color style
		labTxt.setForeground(grey59);
		projTtxt.setForeground(grey59);
		quizTxt.setForeground(grey59);
		examsTxt.setForeground(grey59);
		totalTxt.setForeground(lightYellow);
		gradeTxt.setForeground(lightYellow);

		headerPanel.setBackground(lightYellow);
		wrapperPanel.setBackground(black);
		totalTxt.setBackground(black);
		gradeTxt.setBackground(black);

		// button style
		computeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		computeBtn.setForeground(black);
		computeBtn.setBackground(lightYellow);
		resetBtn.setForeground(black);
		resetBtn.setBackground(lightYellow);

		wrapperPanel.setPreferredSize(new Dimension(340, 380));
		this.add(headerPanel, BorderLayout.NORTH);
		this.add(wrapperPanel, BorderLayout.CENTER);
		headerPanel.add(headerLbl, BorderLayout.NORTH);
		wrapperPanel.add(computationPanel, BorderLayout.CENTER);

		wrapperPanel.setLayout(null);
		labTxt.setBounds(50, 50, 240, 35);
		projTtxt.setBounds(50, 100, 240, 35);
		quizTxt.setBounds(50, 150, 240, 35);
		examsTxt.setBounds(50, 200, 240, 35);
		totalTxt.setBounds(50, 250, 120, 35);
		gradeTxt.setBounds(170, 250, 120, 35);
		computeBtn.setBounds(50, 300, 110, 35);
		resetBtn.setBounds(180, 300, 110, 35);

		labTxt.setBorder(null);
		projTtxt.setBorder(null);
		quizTxt.setBorder(null);
		examsTxt.setBorder(null);
		totalTxt.setBorder(null);
		gradeTxt.setBorder(null);

		totalTxt.setFocusable(false);
		totalTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		gradeTxt.setFocusable(false);
		gradeTxt.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

		labTxt.setHorizontalAlignment(JTextField.CENTER);
		projTtxt.setHorizontalAlignment(JTextField.CENTER);
		quizTxt.setHorizontalAlignment(JTextField.CENTER);
		examsTxt.setHorizontalAlignment(JTextField.CENTER);
		totalTxt.setHorizontalAlignment(JTextField.LEFT);
		gradeTxt.setHorizontalAlignment(JTextField.RIGHT);

		wrapperPanel.add(labTxt);
		wrapperPanel.add(projTtxt);
		wrapperPanel.add(quizTxt);
		wrapperPanel.add(examsTxt);
		wrapperPanel.add(totalTxt);
		wrapperPanel.add(gradeTxt);
		wrapperPanel.add(computeBtn);
		wrapperPanel.add(resetBtn);

		labTxt.addFocusListener(this);
		projTtxt.addFocusListener(this);
		quizTxt.addFocusListener(this);
		examsTxt.addFocusListener(this);
		computeBtn.addActionListener(this);
		resetBtn.addActionListener(this);

	}

	public static void main(String[] args) {
		ClassRecord frame = new ClassRecord("Class Record");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void focusGained(FocusEvent e) {
		JTextField srcLabTxt = (JTextField) e.getSource();
		JTextField srcProjTtxt = (JTextField) e.getSource();
		JTextField srcQuizTxt = (JTextField) e.getSource();
		JTextField srcExamsTxt = (JTextField) e.getSource();

		if (srcLabTxt.getText().equals("Laboratory Experiments")) {
			labTxt.setText("");
			labTxt.setForeground(black);
		}

		if (srcProjTtxt.getText().equals("Project")) {
			projTtxt.setText("");
			projTtxt.setForeground(black);
		}

		if (srcQuizTxt.getText().equals("Quizzes")) {
			quizTxt.setText("");
			quizTxt.setForeground(black);
		}

		if (srcExamsTxt.getText().equals("Major Exams")) {
			examsTxt.setText("");
			examsTxt.setForeground(black);
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		if (labTxt.getText().equals("")) {
			labTxt.setText("Laboratory Experiments");
			labTxt.setForeground(grey59);
		}

		if (projTtxt.getText().equals("")) {
			projTtxt.setText("Project");
			projTtxt.setForeground(grey59);
		}

		if (quizTxt.getText().equals("")) {
			quizTxt.setText("Quizzes");
			quizTxt.setForeground(grey59);
		}

		if (examsTxt.getText().equals("")) {
			examsTxt.setText("Major Exams");
			examsTxt.setForeground(grey59);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton srcComputeBtn = (JButton) e.getSource();
		JButton srcResetBtn = (JButton) e.getSource();

		if (srcComputeBtn.getText().equals("Compute")) {
			try {
				int input1 = Integer.parseInt(labTxt.getText());
				int input2 = Integer.parseInt(projTtxt.getText());
				int input3 = Integer.parseInt(quizTxt.getText());
				int input4 = Integer.parseInt(examsTxt.getText());
				int output = (int) (((input1 * 0.2) + (input2 * 0.1) + (input3 * 0.2) + (input4 * 0.5)));
				if (output > 60) {
					gradeTxt.setText(String.format("%d", output) + " " + "(PASSED)");
				} else {
					gradeTxt.setText(String.format("%d", output) + " " + "(FAILED)");
				}
			} catch (NumberFormatException err) {

			}
		}

		if (srcResetBtn.getText().equals("Reset")) {
			labTxt.setText("Laboratory Experiments");
			projTtxt.setText("Project");
			quizTxt.setText("Quizzes");
			examsTxt.setText("Major Exams");
			gradeTxt.setText("0");
			labTxt.setForeground(grey59);
			projTtxt.setForeground(grey59);
			quizTxt.setForeground(grey59);
			examsTxt.setForeground(grey59);
		}
	}
}