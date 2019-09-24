package browser;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkListener;

import net.miginfocom.swing.MigLayout;

public class Start extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[427.00px,grow][269.00px]", "[][251px,grow]"));

		textField = new JTextField();
		textField.setColumns(10);
		contentPane.add(textField, "cell 0 0,growx,aligny top");

		JButton btnNewButton = new JButton("検索");
		contentPane.add(btnNewButton, "cell 1 0,alignx right,aligny top");
		btnNewButton.addActionListener(new ActionListener() {
			int push=0;
			public void actionPerformed(ActionEvent e) {
				if(push==1)contentPane.remove(scrollPane);
				JEditorPane editorPane = null;
				try {
					editorPane = new JEditorPane(textField.getText());
				} catch (IOException ex) {
					ex.printStackTrace();
					return;
				}
				editorPane.setEditable(false);
				HyperlinkListener hyperlinkListener = new Hyperlink(editorPane);
				editorPane.addHyperlinkListener(hyperlinkListener);
				scrollPane = new JScrollPane(editorPane);
				contentPane.add(scrollPane, "flowx,cell 0 1 2 1,grow");
				push=1;
			}
		});
	}
}
