class Administrador extends Atendente{
	
	Administrador(Dados d){
		super(d);
	}

	void listarOpcoes(){
		System.out.println(" 1 - Agendar Consulta");
		System.out.println(" 2 - Buscar Consulta");
		System.out.println(" 3 - Incluir Paciente");
		System.out.println(" 4 - Excluir Paciente");
		System.out.println(" 5 - Modificar Paciente");
		System.out.println(" 6 - Incluir Medico");
		System.out.println(" 7 - Excluir Medico");
		System.out.println(" 8 - Modificar Medico");
		System.out.println(" 9 - Incluir Atendente");
		System.out.println("10 - Excluir Atendente");
		System.out.println("11 - Modificar Atendente");
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