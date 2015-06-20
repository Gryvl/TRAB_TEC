/*
Equipe 1:
Ramon Martins - 362960
Gabriel Costa - 362961
Yuri - 362992
Victor Vieira(Maromba) - 362990
Lucas Peres - 367095
*/


import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


class Inicio_Simples extends JFrame {
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
		janela.setSize(236,488);
		
		//Iniciando Painel principal
		JPanel painel = new JPanel();
		janela.setContentPane(painel);
		painel.setLayout(new GridBagLayout());
		painel.setBackground(Color.white);

		SetterConstraints c = new SetterConstraints();

		/*Criando um label para se introduzir a imagem e introduzir
		no Painel painel*/
		JLabel logo = new JLabel(new ImageIcon("logo.jpg"));
		painel.add(logo,c.setConstraints(0,0,0,0,1,1,0,0,2,10,0,0,0,0));
		
		/*Criando o Painel de login e colocalndo ele no centro 
		 do nosso Painel painel*/		 
		Container login = new Container();
		//login.setBorder(BorderFactory.createLineBorder(Color.gray));
		login.setLayout(new GridBagLayout());
		painel.add(login,c.setConstraints(0,1,0,0,1,1,0,0,2,10,0,0,0,0));
		
		/*Criando o Label para conter o titulo e introduzindo ele
		 ao Norte do Painel Login*/
		JLabel titulo_login = new JLabel("LOGIN",SwingConstants.CENTER);
		login.add(titulo_login,c.setConstraints(0,0,0,0,1,1,0,0,2,10,10,0,0,0));
		
		/*Criando um novo Painel quer sera introduzido no Painel
		login para conter os Campos de texto (Usuario), (Senha)
		e o botao de (Entrar)
		*/
		Container entradas = new Container();
		entradas.setLayout(new GridBagLayout());

		JLabel usu = new JLabel("Usuário");
		JTextField usuario = new JTextField(25);
		entradas.add(usu,c.setConstraints(0,0,0,0,1,1,0,0,GridBagConstraints.HORIZONTAL,10,5,0,5,5));
		entradas.add(usuario,c.setConstraints(1,0,0,0,1,1,0,0,GridBagConstraints.HORIZONTAL,10,5,0,5,0));

		JLabel sen = new JLabel("  Senha");
		JPasswordField senha = new JPasswordField(25);
		entradas.add(sen,c.setConstraints(0,1,0,0,1,1,0,0,GridBagConstraints.HORIZONTAL,10,5,0,5,5));
		entradas.add(senha,c.setConstraints(1,1,0,0,1,1,0,0,GridBagConstraints.HORIZONTAL,10,5,0,5,0));

		JLabel aviso = new JLabel("*Se usuario ou senha incorretos");
        aviso.setForeground(new Color(255, 100, 100));
        entradas.add(aviso,c.setConstraints(0,2,0,0,2,1,0,0,GridBagConstraints.HORIZONTAL,10,0,0,5,0));

        login.add(entradas,c.setConstraints(0,1,0,0,1,1,0,0,0,10,0,0,0,0));

		JButton entrar = new JButton ("Entrar");
		login.add(entrar,c.setConstraints(0,2,0,0,1,1,0,0,0,10,5,0,5,0));

		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
    	janela.setLocation((tela.width-janela.getSize().width)/2,(tela.height-janela.getSize().height)/2); 

    	//System.out.println(System.getProperty("os.name"));

		janela.setVisible(true);
        janela.setResizable(false);
        //janela.pack();
	}
}
