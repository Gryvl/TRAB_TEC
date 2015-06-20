public class CriadorTela{

	Tela telaPrinicipal = new Tela();

	public Tela criar(Usuario a){
		telaPrinicipal.addComponenteBasico(a.getNome());
		switch(a.getAcesso()){
			case 1:
				telaPrinicipal.addAbaConsultas();
				telaPrinicipal.addAbaPacientes();
				telaPrinicipal.addAbaAtendentes();
				telaPrinicipal.addAbaMedicos();
				break;
			case 2:
				telaPrinicipal.addAbaConsultas();
				telaPrinicipal.addAbaPacientes();
				break;
			case 3:
				telaPrinicipal.addAbaConsultas();
				break;
			case 4:
				telaPrinicipal.addAbaConsultas();
				break;
		}
		telaPrinicipal.tornarVisivel();

		return telaPrinicipal;
	}
}