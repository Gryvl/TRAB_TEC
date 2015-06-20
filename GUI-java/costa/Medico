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
		SetterConstraints c = new SetterConstraints();


		/*Instanciado o painel painel_Oeste 
		 Setado o gerenciador de layout vertical  */
		JPanel painel_Oeste = new JPanel();
		painel_Oeste.setBorder(BorderFactory.createLineBorder(Color.gray));	
		painel_Oeste.setLayout(new GridBagLayout());
		painel_Oeste.setBackground(Color.white);
		painel.add(painel_Oeste,c.setConstraints(0,0,10,20,1,1,0,0,2,10,0,0,0,0));
		
		/*Criando um label para se introduzir a imagem e introduzir
		no Painel painel_Oeste*/
		ImageIcon imagem_Logo = new ImageIcon("logo.jpg"); //Somente esta linha foi alterada  
		imagem_Logo.setImage(imagem_Logo.getImage().getScaledInstance(230, 250, 100));
		JLabel logo = new JLabel(imagem_Logo);
		painel_Oeste.add(logo,c.setConstraints(0,0,0,0,1,1,0,0,2,10,10,0,0,0));
		
		/*Criando o Painel de perfil e colocalndo ele no centro 
		 do nosso Painel painel_Oeste*/		 
		Container perfil = new Container();
		perfil.setLayout(new GridBagLayout());
		painel_Oeste.add(perfil,c.setConstraints(0,1,0,0,1,1,0,0,2,10,0,0,0,0));
		
		/*Criando o Label para conter o titulo e introduzindo ele
		 ao Norte do Painel perfil*/
		JLabel titulo_Perfil = new JLabel("Perfil",SwingConstants.CENTER);
		perfil.add(titulo_Perfil,c.setConstraints(0,0,0,0,1,1,0,0,2,10,10,0,0,0));
		
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
		
		perfil.add(foto_Perfil,c.setConstraints(0,1,0,0,1,1,0,0,2,10,0,0,0,0));
    
		
		/*Criando  Painel que sera introduzido no Painel painel_Oeste e contera 
		 o calendario*/

		Calendario_Login calendario = new Calendario_Login();
		calendario.setBackground(Color.white);
		painel_Oeste.add(calendario.container_Calendario,c.setConstraints(0,2,270,300,1,1,0,0,2,10,0,0,0,0));
		
		JTabbedPane escolhas = new JTabbedPane();
		JPanel centro = new JPanel();
		centro.setLayout(new GridBagLayout());
		//centro.setPreferredSize(new Dimension(800, 800));
		centro.setBorder(BorderFactory.createLineBorder(Color.gray));
		centro.setBackground(Color.white);
		JPanel consultas = new JPanel();
		consultas.setLayout(new GridBagLayout());

    	JTable tabela_Calendario;
    	JComboBox caixa_Tipo_Pesquisa;
    	DefaultTableModel modelo_Consultas; 
    	JScrollPane scroll_Consultas; 
    	final TextField pesquisa;
    	JButton botao_Pesquisa;
        //Configurando Janela

        //Criar controles
        caixa_Tipo_Pesquisa = new JComboBox();
        botao_Pesquisa = new JButton ("Pesq");
        modelo_Consultas = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tabela_Calendario = new JTable(modelo_Consultas);
        scroll_Consultas = new JScrollPane(tabela_Calendario);
        pesquisa = new TextField("Pesquisa",25);
        //pesquisa.setForeground(Color.gray);
        
        //Registrar ações dos Listener
        //caixa_Tipo_Pesquisa.addActionListener(new acao_Caixa_Tipo_Pesquisa());

        scroll_Consultas.setPreferredSize(new Dimension(800,600));
        
        //Setar as bordas //setBounds(x,y,largura,altura);
        consultas.add(caixa_Tipo_Pesquisa,c.setConstraints(0,0,0,0,1,1,1,0,GridBagConstraints.BOTH,10,10,10,10,10));
        consultas.add(pesquisa,c.setConstraints(1,0,0,0,1,1,1,0,GridBagConstraints.BOTH,10,10,10,10,10));
        consultas.add(botao_Pesquisa,c.setConstraints(2,0,0,0,1,1,0,0,GridBagConstraints.BOTH,10,10,10,10,10));

        pesquisa.setForeground(Color.gray);
		pesquisa.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	if(pesquisa.getText().equals("Pesquisa")){
            		pesquisa.setText("");
            		pesquisa.setForeground(Color.black);
            	}
            }
            @Override
            public void focusLost(FocusEvent e) {
            	if(pesquisa.getText().equals("")){
            		pesquisa.setForeground(Color.gray);
            		pesquisa.setText("Pesquisa");
            	}
            }
        });

        caixa_Tipo_Pesquisa.addItem("Paciente");
        caixa_Tipo_Pesquisa.addItem("Hora");
        caixa_Tipo_Pesquisa.addItem("Data");
        
        //Adicionar linhas e colunas
        tabela_Calendario.setTableHeader(null);
        tabela_Calendario.setRowHeight(40);
        modelo_Consultas.setColumnCount(1);
        modelo_Consultas.setRowCount(20);

        consultas.add(scroll_Consultas,c.setConstraints(0,1,0,0,3,1,1,1,GridBagConstraints.BOTH,10,0,10,10,10));

		escolhas.add( consultas, "     Consultas     ");

		centro.add(escolhas,c.setConstraints(0,0,0,0,1,1,1,1,2,10,0,0,0,0));
		painel.add(centro,c.setConstraints(1,0,0,0,3,0,1,1,GridBagConstraints.BOTH,10,0,0,0,0));

		janela.setExtendedState(MAXIMIZED_BOTH); 
		janela.setVisible(true);		
        //janela.setResizable(false);
        //janela.pack();
	}
}