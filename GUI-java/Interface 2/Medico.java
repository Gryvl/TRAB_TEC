import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


class Medico extends JFrame {
	public static void main (String args[]) {
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
		//Instaciando Frame(Janela), principal
		JFrame janela = new JFrame("Clinica GRYVL");
		janela.setIconImage(new ImageIcon("icone.jpg").getImage());
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Iniciando Painel principal
		JPanel painel = new JPanel();
		janela.setContentPane(painel);
		painel.setLayout(new GridBagLayout());
		GridBagConstraints restricoes_Grid = new GridBagConstraints();


		/*Instanciado o painel painel_Oeste 
		 Setado o gerenciador de layout vertical  */
		JPanel painel_Oeste = new JPanel();
		painel_Oeste.setBorder(BorderFactory.createLineBorder(Color.gray));	
		painel_Oeste.setLayout(new GridBagLayout());
		painel_Oeste.setBackground(Color.white);
		//restricoes_Grid.weightx = 1;
		restricoes_Grid.fill = GridBagConstraints.HORIZONTAL;
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 0;
		restricoes_Grid.ipadx = 10;
		restricoes_Grid.ipady = 20;
		painel.add(painel_Oeste,restricoes_Grid);
		
		/*Criando um label para se introduzir a imagem e introduzir
		no Painel painel_Oeste*/
		ImageIcon imagem_Logo = new ImageIcon("logo.jpg"); //Somente esta linha foi alterada  
		imagem_Logo.setImage(imagem_Logo.getImage().getScaledInstance(230, 250, 100));
		JLabel logo = new JLabel(imagem_Logo);
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 0;
		restricoes_Grid.ipadx = 0;
		restricoes_Grid.ipady = 0;
		restricoes_Grid.insets = new Insets(10,0,0,0);
		painel_Oeste.add(logo,restricoes_Grid);
		
		/*Criando o Painel de perfil e colocalndo ele no centro 
		 do nosso Painel painel_Oeste*/		 
		Container perfil = new Container();
		perfil.setLayout(new GridBagLayout());
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 1;
		restricoes_Grid.insets = new Insets(0,0,0,0);
		painel_Oeste.add(perfil,restricoes_Grid);
		
		/*Criando o Label para conter o titulo e introduzindo ele
		 ao Norte do Painel perfil*/
		JLabel titulo_Perfil = new JLabel("Perfil",SwingConstants.CENTER);
		restricoes_Grid.insets = new Insets(10,0,0,0);
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 0;
		perfil.add(titulo_Perfil,restricoes_Grid);
		
		/*Criando um novo Painel quer sera introduzido no Painel
		perfil para conter os Campos de texto (Usuario), (Senha)
		e o botao de (Entrar)
		*/
		JPanel foto_Perfil = new JPanel();
		foto_Perfil.setLayout(new GridBagLayout());
		foto_Perfil.setBorder(BorderFactory.createLineBorder(Color.gray));
		ImageIcon foto = new ImageIcon("medico.jpg"); //Somente esta linha foi alterada  
		foto.setImage(foto.getImage().getScaledInstance(130, 150, 100));
		JLabel imagem_Perfil = new JLabel(foto);
		foto_Perfil.add(imagem_Perfil);
		
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 1;
		// restricoes_Grid.ipadx = 270;
		// restricoes_Grid.ipady = 300;
		restricoes_Grid.insets = new Insets(0,0,0,0);
		perfil.add(foto_Perfil,restricoes_Grid);
    
		
		/*Criando  Painel que sera introduzido no Painel painel_Oeste e contera 
		 o calendario*/

		Calendario_Login calendario = new Calendario_Login();
		calendario.setBackground(Color.white);
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 2;
		restricoes_Grid.ipadx = 270;
		restricoes_Grid.ipady = 300;
		restricoes_Grid.insets = new Insets(0,0,0,0);
		painel_Oeste.add(calendario.container_Calendario,restricoes_Grid);
		
		Lista_Consultas listaConsultas = new Lista_Consultas();
		restricoes_Grid.weightx = 1;
		restricoes_Grid.fill = GridBagConstraints.BOTH;
		restricoes_Grid.gridx = 1;
		restricoes_Grid.gridy = 0;
		restricoes_Grid.ipadx = 600;
		restricoes_Grid.ipady = 800;
		restricoes_Grid.gridwidth = GridBagConstraints.REMAINDER;
		restricoes_Grid.insets = new Insets(0,0,0,0);
		painel.add(listaConsultas.container_Consultas,restricoes_Grid);

		janela.setExtendedState(MAXIMIZED_BOTH); 
		janela.pack();
		janela.setVisible(true);		
        janela.setResizable(false);
	}
}