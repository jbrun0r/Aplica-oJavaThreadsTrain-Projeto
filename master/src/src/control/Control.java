package src.control;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import src.logica.Executor;
import src.view.MainViewer;

public class Control implements ActionListener {
	private MainViewer context;
	private String QuantidadeEmpacotadores;
	private ArrayList<Integer> TempoEmpacotadores;
	private String TamanhoDeposito;
	private String CapacidadeTrem;
	private String TempoViagem;
	
	public Control() {
		
	}
	public Control(MainViewer context) {
		if(this.context == null) {
			this.context = context;
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		context.DesativaIniciar(false);
		//QuantidadeEmpacotadores =context.getQtd_empac_textField().getText();
		//TempoEmpacotamento = context.getTempo_empac_textField().getText();
		TamanhoDeposito = context.getDeposito_textField().getText();
		CapacidadeTrem = context.getTrem_capacidade_textField().getText();
		CriarEmpacotador n = new CriarEmpacotador();
		TempoViagem = context.getViagem_tempo_textField().getText();
		TempoEmpacotadores = (ArrayList<Integer>) n.RetornaTempos();
		QuantidadeEmpacotadores = context.getQtd_empac_textField().getText();
		
		//System.out.println("Qtd de EMPACOTADORES: "+QuantidadeEmpacotadores);
		//System.out.println("TEMPO de Empacotamento: "+TempoEmpacotamento);
		
//		System.out.println("TAMANHO DEPOSITO: "+TamanhoDeposito);
//		System.out.println("CAPACIDADE TREM: "+CapacidadeTrem);
//		System.out.println("TEMPO VIAGEM: "+TempoViagem);
//		System.out.println("QTD DE EMPACOTADORES: "+QuantidadeEmpacotadores);
//		System.out.println("Tempos de Empacotamento: "+TempoEmpacotadores);
		
		context.getLog_textPane().setText("Iniciado!");
		context.DesabilitaCampos();
		
		Executor New = new Executor();
		New.setNumProducers(Integer.parseInt(QuantidadeEmpacotadores));
		New.setNumConsumers(1);
		New.setBufferSize(Integer.parseInt(TamanhoDeposito));
		New.setTimeToTravel(Integer.parseInt(TempoViagem));
		New.setWagonCapacity(Integer.parseInt(CapacidadeTrem));
		New.setTimesToProduce(TempoEmpacotadores);
		context.frmAppThread.setVisible(false);
		try {
			New.main(null);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	


}
