class Atendente extends Paciente{

	/*void incluir(Collection<?> bc, String p, String m, int[3] dh){
		Consulta novaConsulta = new Consulta(p,m,dh);
		bc.add(novaConsulta);
	}
	void modificar(Collection<?> bc, String p, String m, int[3] dh, String pnovo, String mnovo, int[3] dhnovo){
		Consulta novaConsulta = new Consulta(p,m,dh);
		this.excluir(bc, p, m, dh);
		this.incluir(bc, pnovo, mnovo, dhnovo);
	}
	void excluir(Collection<?> bc, String p, String m, int[3] dh){
		Consulta novaConsulta = new Consulta(p,m,dh);
		bc.remove(novaConsulta);
	}
	void buscar(Collection<?> bc, Medico m){
		for(Ierator it = bc.iterator(); it.hasNext(); )
			if (m.nome = (it.Next().medico)
				System.out.println(m.nome);
	}
	void buscar(Collection<?> bc, int[3] dh){
		for(Ierator it = bc.iterator(); it.hasNext(); )
			if (dh[0] = (it.Next().hatahora[0])
				System.out.println(m.nome);
	}*/
	//mes/dia/hora

	Atendente(Dados d){
		super(d);
	}

	void listarOpcoes(){
		System.out.println(" 1 - Agendar Consulta");
		System.out.println(" 2 - Buscar Consulta");
		System.out.println(" 3 - Incluir Paciente");
		System.out.println(" 4 - Excluir Paciente");
		System.out.println(" 5 - Modificar Paciente");
	}

	void pesquisar(String pequisa){
		setChanged();
		notifyObservers(1);
	}

	void visualizarHorario(int dia, int mes, int ano){
		setChanged();
		notifyObservers(dados.consultasDoDia(dia,mes,ano));
    }
}