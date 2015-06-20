import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


class TelaLogin extends JFrame {
	public static void main (String args[]) {
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}

		/*Instaciando Frame(Janela) principal*/
		JFrame janela = new JFrame("Clinica GRYVL");
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
		JLabel usuario = new JLabel("Usuário");
		JTextField entrada_usuario = new JTextField(25);
		painel.add(usuario,new GridBagConstraints(0,2,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(0,5,0,0),0,0));
		painel.add(entrada_usuario,new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,5,5),0,0));
		
		/*Introduzindo Caixa de entrada de Senha*/
		JLabel senha = new JLabel("Senha");
		JPasswordField entrada_senha = new JPasswordField(25);
		painel.add(senha,new GridBagConstraints(0,4,1,1,1,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,0,0),0,0));
		painel.add(entrada_senha,new GridBagConstraints(0,5,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,5,5),0,0));
		
		/*Introduzindo Label de avisos*/
		JLabel aviso = new JLabel(" ");
        aviso.setForeground(new Color(255, 100, 100));
        painel.add(aviso,new GridBagConstraints(0,6,2,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(0,5,5,5),0,0));

        /*Introduzindo Botao Entrar*/
		JButton entrar = new JButton ("Entrar");
		painel.add(entrar,new GridBagConstraints(0,7,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0));

		/*Centralizando a janela*/
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();  
    	janela.setLocation((tela.width-janela.getSize().width)/2,(tela.height-janela.getSize().height)/2); 

		janela.setVisible(true);
        janela.setResizable(false);
	}
}
