import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;


class TelaMedico extends JFrame {
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
		janela.setMinimumSize(new Dimension(888, 690));

		//Iniciando Painel principal
		JPanel painel = new JPanel();
		janela.setContentPane(painel);
		painel.setLayout(new GridBagLayout());

		/*Instanciado o painel painel_Oeste 
		 Setado o gerenciador de layout vertical  */
		JPanel painel_Oeste = new JPanel();
		//painel_Oeste.setBorder(BorderFactory.createLineBorder(Color.gray));	
		painel_Oeste.setLayout(new GridBagLayout());
		painel_Oeste.setBackground(Color.white);
		painel.add(painel_Oeste,new GridBagConstraints(0,0,1,1,0,1,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL,new Insets(0,0,0,0),0,0));
		
		/*Criando um label para se introduzir a imagem e introduzir
		no Painel painel_Oeste*/
		ImageIcon imagem_Logo = new ImageIcon("logo.jpg"); //Somente esta linha foi alterada  
		imagem_Logo.setImage(imagem_Logo.getImage().getScaledInstance(200, 250, 100));
		JLabel logo = new JLabel(imagem_Logo);
		painel_Oeste.add(logo,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,20,0,15),0,0));
		
		/*Criando o Painel de perfil e colocalndo ele no centro 
		 do nosso Painel painel_Oeste*/		 
		Container perfil = new Container();
		perfil.setLayout(new GridBagLayout());
		painel_Oeste.add(perfil,new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,10,0,5),0,0));
		
		/*Criando o Label para conter o titulo e introduzindo ele
		 ao Norte do Painel perfil*/
		JLabel titulo_Perfil = new JLabel("Perfil",SwingConstants.CENTER);
		perfil.add(titulo_Perfil,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,0,0,5),0,0));
		
		/*Criando um novo Painel quer sera introduzido no Painel
		perfil para conter os Campos de texto (Usuario), (Senha)
		e o botao de (Entrar)*/
		JPanel foto_Perfil = new JPanel();
		foto_Perfil.setLayout(new GridBagLayout());
		foto_Perfil.setBorder(BorderFactory.createLineBorder(Color.gray));
		ImageIcon foto = new ImageIcon("medico.jpg"); 
		foto.setImage(foto.getImage().getScaledInstance(160, 160, 150));
		JLabel imagem_Perfil = new JLabel(foto);
		foto_Perfil.add(imagem_Perfil);
		perfil.add(foto_Perfil,new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,0,0,0),0,0));
    
		/*Criando  Painel que sera introduzido no Painel painel_Oeste e contera 
		 o calendario*/
		Calendario calendario = new Calendario();
		calendario.setBackground(Color.WHITE);
		painel_Oeste.add(calendario,new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(10,10,0,0),0,223));
		
		JTabbedPane escolhas = new JTabbedPane();
		JPanel centro = new JPanel();
		centro.setLayout(new GridBagLayout());
		//centro.setBorder(BorderFactory.createLineBorder(Color.gray));
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
        
        //Registrar ações dos Listener
        //caixa_Tipo_Pesquisa.addActionListener(new acao_Caixa_Tipo_Pesquisa());

        scroll_Consultas.setPreferredSize(new Dimension(600,540));
        
        //Setar as bordas //GridBsgLayout(x,y,largura,altura);
        consultas.add(caixa_Tipo_Pesquisa,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        consultas.add(pesquisa,new GridBagConstraints(1,0,1,1,1,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        consultas.add(botao_Pesquisa,new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        
        //Propriedade da caixa de pesquisa com texto padrao
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
		caixa_Tipo_Pesquisa.addItem("Data");
		caixa_Tipo_Pesquisa.addItem("Hora");
        caixa_Tipo_Pesquisa.addItem("Paciente");
        
        modelo_Consultas.addColumn("Data");
        modelo_Consultas.addColumn("Hora");
        modelo_Consultas.addColumn("Paciente");
	    
        //Adicionar linhas e colunas
        //tabela_Calendario.setTableHeader(null);
        tabela_Calendario.setRowHeight(40);
        modelo_Consultas.setColumnCount(3);
        modelo_Consultas.setRowCount(20);

        consultas.add(scroll_Consultas,new GridBagConstraints(0,1,3,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(20,10,10,10),0,0));
        consultas.setBackground(Color.white);

		escolhas.add( consultas, "     Consultas     ");

		centro.add(escolhas,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(10,5	,20,20),0,0));
		painel.add(centro,new GridBagConstraints(1,0,3,0,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));

		//janela.setResizable(true);		
        //janela.pack();
        janela.setVisible(true);
	}
}