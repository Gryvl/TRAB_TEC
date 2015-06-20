import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


class TelaConfiguracao/* extends WindowAdapter */implements ActionListener{
	static Dados bancoDados;
	static JTextField entrada_usuario;
	static JTextField entrada_senha;
	static JLabel aviso;
	static JFrame janela;
	static JButton entrar;
	
	TelaLogin(Dados d) {
		bancoDados = d;
		//this.mvc = mvc;
	}

	public JFrame componentes(){
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}

		/*Instaciando Frame(Janela) principal*/
		janela = new JFrame("Clinica - Login");
		janela.setIconImage(new ImageIcon("icone.jpg").getImage());
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(234,485/*523*/);
		
		/*Iniciando Painel principal*/
		JPanel painel = new JPanel();
		painel.setLayout(new GridBagLayout());
		painel.setBackground(Color.white);
		janela.setContentPane(painel);

		/*Criando um label para se introduzir a imagem e introduzir no Painel painel*/
		JLabel logo = new JLabel(new ImageIcon("logo.jpg"));
		painel.add(logo,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(0,0,0,0),0,0));

		/*Criando o Label para conter o titulo e introduzindo ele
		 ao Norte do Painel Login*/
		//JLabel titulo_login = new JLabel("LOGIN",SwingConstants.CENTER);
		//painel.add(titulo_login,new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(10,0,10,0),0,0));
		
		/*Introduzindo Caixa de entrada de Usuario*/
		JLabel usuario = new JLabel("Usuario");
		entrada_usuario = new JTextField(25);
		painel.add(usuario,new GridBagConstraints(0,2,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(0,5,0,0),0,0));
		painel.add(entrada_usuario,new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,5,5),0,0));
		
		/*Introduzindo Caixa de entrada de Senha*/
	 	JLabel senha = new JLabel("Senha");
		entrada_senha = new JPasswordField(25);
		painel.add(senha,new GridBagConstraints(0,4,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,0,0),0,0));
		painel.add(entrada_senha,new GridBagConstraints(0,5,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,5,5),0,0));
		
		/*Introduzindo Label de avisos*/
		aviso = new JLabel(" ");
        aviso.setForeground(new Color(255, 100, 100));
        painel.add(aviso,new GridBagConstraints(0,6,2,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(0,5,5,5),0,0));

        /*Introduzindo Botao Entrar*/
		entrar = new JButton ("Entrar");
		entrar.addActionListener(this);
		painel.add(entrar,new GridBagConstraints(0,7,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0));

		/*Centralizando a janela*/
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
    	janela.setLocation((tela.width-janela.getSize().width)/2,(tela.height-janela.getSize().height)/2); 

		janela.setVisible(true);
        janela.setResizable(false);
        
        return janela;
	}
    /*public void actionPerformed (ActionEvent e){
    	try{
    		valido = bancoDados.comparar(entrada_usuario.getText(),sha1(entrada_senha.getText()));
    		entrarTelaPrincipal();
    	}catch(Exception a){
    		a.printStackTrace();
    	}
	}*/
	static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }

    public Usuario verificar(String nome,String senha){
		int i;
		for(i=0;i<4;i++){
			Iterator it = bancoDados.perfis[i].iterator();
			while (it.hasNext()){
				Usuario u = (Usuario)it.next();
				if(nome.equals(u.nome)&&senha.equals(u.senha))
					return u;
			}
		}
		return null;
	} 
    
  	public void actionPerformed(java.awt.event.ActionEvent e){
		try{
			Usuario myModel	= verificar(entrada_usuario.getText(),sha1(entrada_senha.getText()));
    		//valido = bancoDados.comparar(entrada_usuario.getText(),sha1(entrada_senha.getText()));
    		if (myModel != null){
			
				
				Tela myView = new Tela(myModel);

				//tell Model about View. 
				myModel.addObserver(myView);

				Controller myController = new Controller();
				myController.addModel(myModel);
				myController.addView(myView);
				myController.addDados(bancoDados);

				//tell View about Controller 
				myView.addController(myController);

				


				janela.setVisible(false);
            	janela.dispose();
			}else {
				aviso.setText("Usuario ou senha invalidos");
			}
		}catch(Exception a){
				a.printStackTrace();
		}
	}
}
