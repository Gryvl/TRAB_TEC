import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


class Inicio extends JFrame {
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
		JPanel pane = new JPanel();
		janela.setContentPane(pane);
		pane.setLayout(new GridBagLayout());
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
		pane.add(painel_Oeste,restricoes_Grid);
		
		/*Criando um label para se introduzir a imagem e introduzir
		no Painel painel_Oeste*/
		JLabel logo = new JLabel(new ImageIcon("logo.jpg"));
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 0;
		restricoes_Grid.ipadx = 0;
		restricoes_Grid.ipady = 0;
		restricoes_Grid.insets = new Insets(0,0,0,0);
		painel_Oeste.add(logo,restricoes_Grid);
		
		/*Criando o Painel de login e colocalndo ele no centro 
		 do nosso Painel painel_Oeste*/		 
		Container login = new Container();
		//login.setBorder(BorderFactory.createLineBorder(Color.gray));
		login.setLayout(new GridBagLayout());
		//restricoes_Grid.weighty = 1;
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 1;
		restricoes_Grid.insets = new Insets(0,0,0,0);
		painel_Oeste.add(login,restricoes_Grid);
		
		/*Criando o Label para conter o titulo e introduzindo ele
		 ao Norte do Painel Login*/
		JLabel titulo_login = new JLabel("LOGIN",SwingConstants.CENTER);
		//restricoes_Grid.weighty = 1;
		restricoes_Grid.insets = new Insets(10,0,0,0);
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 0;
		login.add(titulo_login,restricoes_Grid);
		
		/*Criando um novo Painel quer sera introduzido no Painel
		login para conter os Campos de texto (Usuario), (Senha)
		e o botao de (Entrar)
		*/
		Container entradas = new Container();
		entradas.setLayout(new GridBagLayout());

		restricoes_Grid.insets = new Insets(5,0,5,0);
		final TextField usuario = new TextField("Usuario",25);
		usuario.setForeground(Color.gray);
		usuario.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	if(usuario.getText().equals("Usuario")){
            		usuario.setText("");
            		usuario.setForeground(Color.black);
            	}
            }
            @Override
            public void focusLost(FocusEvent e) {
            	if(usuario.getText().equals("")){
            		usuario.setForeground(Color.gray);
            		usuario.setText("Usuario");
            	}
            }
        });
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 0;
		entradas.add(usuario,restricoes_Grid);

		final TextField senha = new TextField("Senha",25);
		senha.setForeground(Color.gray);
		senha.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	if(senha.getText().equals("Senha")){
            		senha.setText("");
            		senha.setForeground(Color.black);
            	}
                senha.setEchoChar('*');
            }
            @Override
            public void focusLost(FocusEvent e) {
            	if(senha.getText().equals("")){
            		senha.setEchoChar((char)0);
            		senha.setForeground(Color.gray);
            		senha.setText("Senha");
            	}
            }
        });
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 1;
		entradas.add(senha,restricoes_Grid);

		GridBagConstraints a = new GridBagConstraints();
		JButton entrar = new JButton ("Entrar");
		a.gridx = 0;
		a.gridy = 2;
		entradas.add(entrar,a);

		a.gridx = 0;
		a.gridy = 1;
		a.insets = new Insets(0,0,0,0);
		login.add(entradas,a);
        
        JLabel aviso = new JLabel("*Se usuario ou senha incorretos");
        aviso.setForeground(new Color(255, 100, 100));
        restricoes_Grid.gridx = 0;
        restricoes_Grid.gridy = 2;
        restricoes_Grid.insets = new Insets(0,0,5,0);
        login.add(aviso,restricoes_Grid);
		
		/*Criando  Painel que sera introduzido no Painel painel_Oeste e contera 
		 o calendario*/

		/*Calendario_Login calendario = new Calendario_Login();
		calendario.setBackground(Color.white);
		restricoes_Grid.gridx = 0;
		restricoes_Grid.gridy = 2;
		restricoes_Grid.ipadx = 270;
		restricoes_Grid.ipady = 300;
		restricoes_Grid.insets = new Insets(0,0,0,0);
		painel_Oeste.add(calendario.container_Calendario,restricoes_Grid);
		*/

		
		JPanel centro = new JPanel();
		centro.setBorder(BorderFactory.createLineBorder(Color.gray));
		JLabel logo_centro = new JLabel(new ImageIcon("centro.jpg"));
		centro.setBackground(Color.white);
		restricoes_Grid.weightx = 1;
		restricoes_Grid.fill = GridBagConstraints.BOTH;
		restricoes_Grid.gridx = 1;
		restricoes_Grid.gridy = 0;
		restricoes_Grid.insets = new Insets(0,0,0,0);
		centro.setPreferredSize(new Dimension(800, 100));
		centro.add(logo_centro);
		pane.add(centro,restricoes_Grid);

		janela.pack();
		janela.setVisible(true);
	}
}
