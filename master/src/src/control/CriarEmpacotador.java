package src.control;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import src.view.MainViewer;

public class CriarEmpacotador implements ActionListener {
	private MainViewer context;
	
	private String te;
	public int Empacotadores=0, j=0;
	
	public static ArrayList<Integer> TempoEmpacotadores = new ArrayList<>();
	
	
	
	public CriarEmpacotador() {
			
		}
	
	public CriarEmpacotador(MainViewer context) {
		if(this.context == null) {
			this.context = context;
			
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Empacotadores = Integer.parseInt(context.getQtd_empac_textField().getText());
		
		context.DesabilitaCampos();
		context.DesativaCampo_qtd_empac_textField();
		
		te = context.getTempo_empac_textField().getText();
		
		if(j<(Empacotadores)) {
			TempoEmpacotadores.add(Integer.parseInt(te));
			//RetornaTempos();
			System.out.println("tempo Empac"+j+" = "+te);
			context.getLog_textPane().setText("Empacotador "+(j+1)+"\ntempo = "+te);
			context.LimparTempoEmpac();
			System.out.println("Teste: "+TempoEmpacotadores.get(j));
		}
		j++;
		
		if(j==Empacotadores) {
			context.DesativaAdd();
			context.DesativaIniciar(true);
			context.DesabilitaCampo_tempo_empac_textField();
			System.out.println(TempoEmpacotadores);
		}	
	}
	
	public ArrayList<Integer> RetornaTempos() {
		return  TempoEmpacotadores;
	}

	public int getEmpacotadores() {
		return Empacotadores;
	}

	public ArrayList<Integer> getTempoEmpacotadores() {
		return TempoEmpacotadores;
	}

		
	
}
