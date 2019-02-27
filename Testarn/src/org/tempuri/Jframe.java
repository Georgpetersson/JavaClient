package org.tempuri;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class Jframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe frame = new Jframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Jframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 94, 434, 167);
		contentPane.add(textArea);
		
		TextField textField = new TextField();
		textField.setBounds(10, 34, 141, 22);
		contentPane.add(textField);
		
		Button button = new Button("Visa text");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WebService1SoapProxy proxy = new WebService1SoapProxy();
				String text = textField.getText();
				String fulltext = "C:\\Users\\Administrator\\Documents\\" +text+".txt";
				try {
					String hej = proxy.byeWorld(fulltext);
					textArea.setText(hej);
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(44, 62, 70, 22);
		contentPane.add(button);
	}
}
