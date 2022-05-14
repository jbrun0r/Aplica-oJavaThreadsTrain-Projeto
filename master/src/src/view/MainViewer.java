package src.view;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import src.control.Control;
import src.control.CriarEmpacotador;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;

public class MainViewer {

	public JFrame frmAppThread;
	private JTextField deposito_textField;
	private JTextField trem_capacidade_textField;
	private JTextField viagem_tempo_textField;
	private JTextField qtd_empac_textField;
	private JTextField tempo_empac_textField;
	private JTextPane log_textPane;
	private JButton criar_new_empac_Button;
	private JButton iniciar_Button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainViewer window = new MainViewer();
					window.frmAppThread.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainViewer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppThread = new JFrame();
		frmAppThread.setAlwaysOnTop(true);
		frmAppThread.getContentPane().setBackground(SystemColor.controlHighlight);
		frmAppThread.setBackground(SystemColor.desktop);
		frmAppThread.setTitle("App Thread");
		frmAppThread.setBounds(100, 100, 700, 535);
		frmAppThread.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppThread.getContentPane().setLayout(null);
		
		JLabel qtd_empac_Label = new JLabel("N\u00B0 de Empacotadores:");
		qtd_empac_Label.setForeground(new Color(0, 0, 0));
		qtd_empac_Label.setFont(new Font("Arial", Font.PLAIN, 14));
		qtd_empac_Label.setBounds(52, 269, 151, 14);
		frmAppThread.getContentPane().add(qtd_empac_Label);
		
		JLabel deposito_Label = new JLabel("Capacidade do Dep\u00F3sito:");
		deposito_Label.setFont(new Font("Arial", Font.PLAIN, 14));
		deposito_Label.setBounds(52, 178, 172, 14);
		frmAppThread.getContentPane().add(deposito_Label);
		
		deposito_textField = new JTextField();
		deposito_textField.setBackground(new Color(245, 245, 220));
		deposito_textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		deposito_textField.setFont(new Font("Arial", Font.PLAIN, 14));
		deposito_textField.setHorizontalAlignment(SwingConstants.RIGHT);
		deposito_textField.setColumns(10);
		deposito_textField.setBounds(220, 172, 30, 20);
		frmAppThread.getContentPane().add(deposito_textField);
		
		JLabel trem_capacidade_Label = new JLabel("Capacidade do Trem:");
		trem_capacidade_Label.setFont(new Font("Arial", Font.PLAIN, 14));
		trem_capacidade_Label.setBounds(52, 207, 151, 14);
		frmAppThread.getContentPane().add(trem_capacidade_Label);
		
		trem_capacidade_textField = new JTextField();
		trem_capacidade_textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		trem_capacidade_textField.setBackground(new Color(245, 245, 220));
		trem_capacidade_textField.setFont(new Font("Arial", Font.PLAIN, 14));
		trem_capacidade_textField.setHorizontalAlignment(SwingConstants.RIGHT);
		trem_capacidade_textField.setColumns(10);
		trem_capacidade_textField.setBounds(220, 201, 30, 20);
		frmAppThread.getContentPane().add(trem_capacidade_textField);
		
		JLabel viagem_tempo_Label = new JLabel("Tempo de Viagem:");
		viagem_tempo_Label.setFont(new Font("Arial", Font.PLAIN, 14));
		viagem_tempo_Label.setBounds(52, 238, 136, 14);
		frmAppThread.getContentPane().add(viagem_tempo_Label);
		
		viagem_tempo_textField = new JTextField();
		viagem_tempo_textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		viagem_tempo_textField.setBackground(new Color(245, 245, 220));
		viagem_tempo_textField.setFont(new Font("Arial", Font.PLAIN, 14));
		viagem_tempo_textField.setHorizontalAlignment(SwingConstants.RIGHT);
		viagem_tempo_textField.setColumns(10);
		viagem_tempo_textField.setBounds(220, 232, 30, 20);
		frmAppThread.getContentPane().add(viagem_tempo_textField);
		
		iniciar_Button = new JButton("");
		iniciar_Button.setIcon(new ImageIcon(MainViewer.class.getResource("/imagens/inicia_icon.png")));
		iniciar_Button.setBackground(new Color(245, 245, 220));
		iniciar_Button.setBorder(null);
		iniciar_Button.setFont(new Font("Arial", Font.PLAIN, 14));
		iniciar_Button.setBounds(52, 404, 95, 46);
		iniciar_Button.addActionListener(new Control(this));
		frmAppThread.getContentPane().add(iniciar_Button);
		DesativaIniciar(false);
		
		criar_new_empac_Button = new JButton("");
		criar_new_empac_Button.setBackground(new Color(245, 245, 220));
		criar_new_empac_Button.setForeground(new Color(0, 0, 0));
		criar_new_empac_Button.setIcon(new ImageIcon(MainViewer.class.getResource("/imagens/add_icon.png")));
		criar_new_empac_Button.setBorder(null);
		criar_new_empac_Button.setFont(new Font("Arial", Font.PLAIN, 14));
		criar_new_empac_Button.setBounds(152, 326, 30, 29);
		criar_new_empac_Button.addActionListener(new CriarEmpacotador(this));
		frmAppThread.getContentPane().add(criar_new_empac_Button);
		
		qtd_empac_textField = new JTextField();
		qtd_empac_textField.setFont(new Font("Arial", Font.PLAIN, 14));
		qtd_empac_textField.setBackground(new Color(245, 245, 220));
		qtd_empac_textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		qtd_empac_textField.setHorizontalAlignment(SwingConstants.RIGHT);
		qtd_empac_textField.setColumns(10);
		qtd_empac_textField.setBounds(220, 263, 30, 20);
		frmAppThread.getContentPane().add(qtd_empac_textField);
		
		JLabel ola = new JLabel("");
		ola.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ola.setBounds(101, 11, 24, 36);
		frmAppThread.getContentPane().add(ola);
		
		tempo_empac_textField = new JTextField();
		tempo_empac_textField.setFont(new Font("Arial", Font.PLAIN, 14));
		tempo_empac_textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.GRAY));
		tempo_empac_textField.setBackground(new Color(245, 245, 220));
		tempo_empac_textField.setHorizontalAlignment(SwingConstants.RIGHT);
		tempo_empac_textField.setColumns(10);
		tempo_empac_textField.setBounds(112, 335, 30, 20);
		frmAppThread.getContentPane().add(tempo_empac_textField);
		
		JLabel tempo_empac_Label = new JLabel("Tempos:");
		tempo_empac_Label.setForeground(new Color(0, 0, 0));
		tempo_empac_Label.setFont(new Font("Arial", Font.PLAIN, 14));
		tempo_empac_Label.setBounds(52, 337, 56, 14);
		frmAppThread.getContentPane().add(tempo_empac_Label);
		
		log_textPane = new JTextPane();
		log_textPane.setFont(new Font("Arial", Font.PLAIN, 14));
		log_textPane.setBackground(new Color(245, 245, 220));
		log_textPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		log_textPane.setText("Ol\u00E1, Insira as informa\u00E7\u00F5es da Esta\u00E7\u00E3o.           Adicione o tempo do respectivo Empactador e click em Add.");
		log_textPane.setBounds(329, 53, 136, 175);
		frmAppThread.getContentPane().add(log_textPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(245, 245, 220));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBorder(null);
		lblNewLabel.setMaximumSize(new Dimension(500, 4000));
		lblNewLabel.setIcon(new ImageIcon(MainViewer.class.getResource("/imagens/fundo_icon.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0, 700, 500);
		frmAppThread.getContentPane().add(lblNewLabel);
		
		
	}

//	public JFrame getFrmAppThread() {
//		return frmAppThread;
//	}
//
//	public void setFrmAppThread(JFrame frmAppThread) {
//		this.frmAppThread = frmAppThread;
//	}
	

	public JTextPane getLog_textPane() {
		return log_textPane;
	}

	public void setLog_textPane(JTextPane log_textPane) {
		this.log_textPane = log_textPane;
	}

	public JTextField getQtd_empac_textField() {
		return qtd_empac_textField;
	}

	public void setQtd_empac_textField(JTextField qtd_empac_textField) {
		this.qtd_empac_textField = qtd_empac_textField;
	}

	public JTextField getTempo_empac_textField() {
		return tempo_empac_textField;
	}

	public void setTempo_empac_textField(JTextField tempo_empac_textField) {
		this.tempo_empac_textField = tempo_empac_textField;
	}

	public JTextField getDeposito_textField() {
		return deposito_textField;
	}

	public void setDeposito_textField(JTextField deposito_textField) {
		this.deposito_textField = deposito_textField;
	}

	public JTextField getTrem_capacidade_textField() {
		return trem_capacidade_textField;
	}

	public void setTrem_capacidade_textField(JTextField trem_capacidade_textField) {
		this.trem_capacidade_textField = trem_capacidade_textField;
	}

	public JTextField getViagem_tempo_textField() {
		return viagem_tempo_textField;
	}

	public void setViagem_tempo_textField(JTextField viagem_tempo_textField) {
		this.viagem_tempo_textField = viagem_tempo_textField;
	}
	
	
	public void LimparTempoEmpac() {
		tempo_empac_textField.setText("");
	}
	
	public void DesativaAdd() {
		criar_new_empac_Button.setEnabled(false);
	}
	public void DesativaCampo_qtd_empac_textField() {
		qtd_empac_textField.setEnabled(false);
	}
	
	public void DesativaIniciar(boolean b) {
		iniciar_Button.setEnabled(b);
	}
	public void DesabilitaCampos() {
		viagem_tempo_textField.setEnabled(false);
		trem_capacidade_textField.setEnabled(false);
		deposito_textField.setEnabled(false);
	}
	public void DesabilitaCampo_tempo_empac_textField() {
		tempo_empac_textField.setEnabled(false);
	}
	protected Color getQtd_empac_textFieldBackground() {
		return qtd_empac_textField.getBackground();
	}
	protected void setQtd_empac_textFieldBackground(Color background) {
		qtd_empac_textField.setBackground(background);
	}
}
