import java.awt.event.*;

class Controller extends MouseAdapter implements ActionListener{

	Usuario model;
	Tela view;
	Dados dados;

	public void actionPerformed(java.awt.event.ActionEvent e){
		System.out.println("oi");
		if(e.getActionCommand().equals("pesquisar")){			
			model.pesquisar("view.pesquisa.getText()");
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