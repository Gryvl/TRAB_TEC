import java.awt.event.*;

class Controller extends MouseAdapter implements ActionListener{

	Usuario model;
	Tela view;
	Dados dados;

	public void actionPerformed(java.awt.event.ActionEvent e){
		System.out.println("Entreiiiiiiiii");
		if(e.getActionCommand().equals("pesquisar_consulta")){			
			model.pesquisar(1);
		}
		if(e.getActionCommand().equals("pesquisar_paciente")){
			model.pesquisar(2);
		}
		if(e.getActionCommand().equals("pesquisar_medico"))	{
			model.pesquisar(3);
		}
		if(e.getActionCommand().equals("pesquisar_atendente")){
			model.pesquisar(4);
		}

	}
	public void mouseClicked(MouseEvent e) {
		model.visualizarHorario(view.calendario.atualDia,view.calendario.atualMes,view.calendario.atualAno);
	}

	public void addModel(Usuario m){
		this.model = m;
	}

	public void addView(Tela v){
		this.view = v;               
	} 

	public void addDados(Dados d){
		this.dados = d;
	}

} 