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
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;


class Medico extends JFrame {
	//private static final long serialVersionUID = -1113582265865921787L;
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
		janela.setExtendedState(MAXIMIZED_BOTH); 
		
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
		painel.add(painel_Oeste,c.setConstraints(0,0,10,20,1,1,0,1,GridBagConstraints.VERTICAL,10,0,0,0,0));
		
		/*Criando um label para se introduzir a imagem e introduzir
		no Painel painel_Oeste*/
		ImageIcon imagem_Logo = new ImageIcon("logo.jpg"); //Somente esta linha foi alterada  
		imagem_Logo.setImage(imagem_Logo.getImage().getScaledInstance(200, 250, 100));
		JLabel logo = new JLabel(imagem_Logo);
		painel_Oeste.add(logo,c.setConstraints(0,0,0,0,1,1,0,0,2,10,5,20,0,15));
		
		/*Criando o Painel de perfil e colocalndo ele no centro 
		 do nosso Painel painel_Oeste*/		 
		Container perfil = new Container();
		perfil.setLayout(new GridBagLayout());
		painel_Oeste.add(perfil,c.setConstraints(0,1,0,0,1,1,0,0,2,10,5,10,0,5));
		
		/*Criando o Label para conter o titulo e introduzindo ele
		 ao Norte do Painel perfil*/
		JLabel titulo_Perfil = new JLabel("Perfil",SwingConstants.CENTER);
		perfil.add(titulo_Perfil,c.setConstraints(0,0,0,0,1,1,0,0,2,10,5,0,0,5));
		
		/*Criando um novo Painel quer sera introduzido no Painel
		perfil para conter os Campos de texto (Usuario), (Senha)
		e o botao de (Entrar)*/
		JPanel foto_Perfil = new JPanel();
		foto_Perfil.setLayout(new GridBagLayout());
		foto_Perfil.setBorder(BorderFactory.createLineBorder(Color.gray));
		ImageIcon foto = new ImageIcon("medico.jpg"); //Somente esta linha foi alterada  
		foto.setImage(foto.getImage().getScaledInstance(140, 160, 150));
		JLabel imagem_Perfil = new JLabel(foto);
		foto_Perfil.add(imagem_Perfil);
		perfil.add(foto_Perfil,c.setConstraints(0,1,0,0,1,1,0,0,2,10,5,0,0,0));
    
		/*Criando  Painel que sera introduzido no Painel painel_Oeste e contera 
		 o calendario*/

		Calendario_Login calendario = new Calendario_Login();
		calendario.setBackground(Color.WHITE);
		painel_Oeste.add(calendario,c.setConstraints(0,2,0,220,1,1,0,0,2,10,10,10,0,0));
		
		JTabbedPane escolhas = new JTabbedPane();
		JPanel centro = new JPanel();
		centro.setLayout(new GridBagLayout());
		centro.setBorder(BorderFactory.createLineBorder(Color.gray));
		centro.setBackground(Color.white);
		JPanel consultas = new JPanel();
		consultas.setLayout(new GridBagLayout());

        //Criar controles
        JComboBox<String> caixa_Tipo_Pesquisa = new JComboBox<>();
        JButton botao_Pesquisa = new JButton ("Pesquisar");
        DefaultTableModel modelo_Consultas = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        JTable tabela_Calendario = new JTable(modelo_Consultas);
        JScrollPane scroll_Consultas = new JScrollPane(tabela_Calendario);
        final TextField pesquisa = new TextField("Entre aqui sua pesquisa",20);
        //pesquisa.setForeground(Color.gray);
        
        //Registrar ações dos Listener
        //caixa_Tipo_Pesquisa.addActionListener(new acao_Caixa_Tipo_Pesquisa());

        scroll_Consultas.setPreferredSize(new Dimension(600,540));
        
        //Setar as bordas //setBounds(x,y,largura,altura);
        consultas.add(caixa_Tipo_Pesquisa,c.setConstraints(0,0,0,0,1,1,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.EAST,10,10,10,10));
        consultas.add(pesquisa,c.setConstraints(1,0,0,0,1,1,1,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.EAST,10,10,10,10));
        consultas.add(botao_Pesquisa,c.setConstraints(2,0,0,0,1,1,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.EAST,10,10,10,10));

        pesquisa.setForeground(Color.gray);
		pesquisa.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	if(pesquisa.getText().equals("Entre aqui sua pesquisa")){
            		pesquisa.setText("");
            		pesquisa.setForeground(Color.black);
            	}
            }
            @Override
            public void focusLost(FocusEvent e) {
            	if(pesquisa.getText().equals("")){
            		pesquisa.setForeground(Color.gray);
            		pesquisa.setText("Entre aqui sua pesquisa");
            	}
            }
        });

        caixa_Tipo_Pesquisa.addItem("Paciente");
        caixa_Tipo_Pesquisa.addItem("Hora");
        caixa_Tipo_Pesquisa.addItem("Data");

        modelo_Consultas.addColumn("Data");
        modelo_Consultas.addColumn("Hora");
        modelo_Consultas.addColumn("Paciente");
	  
	    //JTableHeader header = jTable.getTableHeader();   
	    //header.setPreferredSize(new Dimension(0, 35));   
	    //TableColumnModel modeloDaColuna = jTable.getColumnModel();  
	    
	    TableColumnModel columnModel = tabela_Calendario.getColumnModel();
		
		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setPreferredWidth(50);
		columnModel.getColumn(2).setPreferredWidth(150);
		//table.getColumnModel().getColumn(1).setMinWidth();
		//table.getColumnModel().getColumn(2).  
	    //tabela_Calendario.getColumnModel().getColumn(3).setMaxWidth(195);
        
        //Adicionar linhas e colunas
        //tabela_Calendario.setTableHeader(null);
        tabela_Calendario.setRowHeight(40);
        modelo_Consultas.setColumnCount(3);
        modelo_Consultas.setRowCount(20);

        consultas.add(scroll_Consultas,c.setConstraints(0,1,0,0,3,1,1,1,GridBagConstraints.BOTH,10,20,10,10,10));
        consultas.setBackground(Color.white);

		escolhas.add( consultas, "     Consultas     ");

		centro.add(escolhas,c.setConstraints(0,0,0,0,1,1,1,1,2,10,0,20,0,20));
		painel.add(centro,c.setConstraints(1,0,0,0,3,0,1,1,GridBagConstraints.BOTH,10,0,0,0,0));

		//janela.setResizable(false);
		
				
        //janela.pack();
        janela.setVisible(true);
	}
}