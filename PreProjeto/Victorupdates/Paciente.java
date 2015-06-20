class Paciente extends Usuario{

	/*void agendar(String p, String m, int[3] dh){
		Consulta novaConsulta = new Consulta(p,m,dh);
	}

	void buscar(Collection<?> bc, Paciente p){
		for(Ierator it = bc.iterator(); it.hasNext(); )
			if (p.nome = (it.Next().paciente)
				System.out.println(p.nome);
	}*/
	Paciente(Dados d){
		super(d);
	}

	void listarOpcoes(){
		System.out.println(" 1 - Agendar Consulta");
		System.out.println(" 2 - Visualizar Consultas");
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