import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;

public class Tela implements java.util.Observer{
 	
 	JFrame janela;
	JPanel painel;
	JPanel painelOeste;
	ImageIcon imagemLogo;
	JLabel logo;
	Container perfil;
	JLabel tituloPerfil;
	String nomeUsuario;
	JPanel fotoPerfil;
	ImageIcon foto;
	JLabel imagemPerfil;
	JTabbedPane escolhas;
	JPanel centro;
	Controller controller;

	TextField pesquisaConsulta;
	TextField pesquisaPaciente;
	TextField pesquisaAtendente;
	TextField pesquisaMedico;

	DefaultTableModel modeloConsultas;

	JButton botaoPesquisa;

 	public Calendario calendario;

 	public Tela(Usuario a){
		addComponenteBasico(a.getNome());
		switch(a.getAcesso()){
			case 1:
				addAbaConsultas();
				addAbaPacientes();
				addAbaAtendentes();
				addAbaMedicos();
				break;
			case 2:
				addAbaConsultas();
				addAbaPacientes();
				break;
			case 3:
				addAbaConsultas();
				break;
			case 4:
				addAbaConsultas();
				break;
		}
		tornarVisivel();
	}

    public void addComponenteBasico(String n){

    	nomeUsuario = n;

		janela = new JFrame("Clinica GRYVL");
		janela.setIconImage(new ImageIcon("icone.jpg").getImage());
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setMinimumSize(new Dimension(888, 690));

		//Iniciando Painel principal
		painel = new JPanel();
		janela.setContentPane(painel);
		painel.setLayout(new GridBagLayout());

		/*Instanciado o painel painelOeste 
		 Setado o gerenciador de layout vertical  */
		painelOeste = new JPanel();
		//painelOeste.setBorder(BorderFactory.createLineBorder(Color.gray));	
		painelOeste.setLayout(new GridBagLayout());
		painelOeste.setBackground(Color.white);
		painel.add(painelOeste,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		/*Criando um label para se introduzir a imagem e introduzir
		no Painel painelOeste*/
		imagemLogo = new ImageIcon("logo.jpg"); //Somente esta linha foi alterada  
		imagemLogo.setImage(imagemLogo.getImage().getScaledInstance(200, 250, 100));
		logo = new JLabel(imagemLogo);
		painelOeste.add(logo,new GridBagConstraints(0,0,1,1,0,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,20,0,15),0,0));
		
		/*Criando o Painel de perfil e colocalndo ele no centro 
		 do nosso Painel painelOeste*/		 
		perfil = new Container();
		perfil.setLayout(new GridBagLayout());
		painelOeste.add(perfil,new GridBagConstraints(0,1,1,1,0,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,10,0,5),0,0));
		
		/*Criando o Label para conter o titulo e introduzindo ele
		 ao Norte do Painel perfil*/
		tituloPerfil = new JLabel(nomeUsuario,SwingConstants.CENTER);
		perfil.add(tituloPerfil,new GridBagConstraints(0,0,1,1,0,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,0,0,5),0,0));
		
		/*Criando um novo Painel quer sera introduzido no Painel
		perfil para conter os Campos de texto (Usuario), (Senha)
		e o botao de (Entrar)*/
		fotoPerfil = new JPanel();
		fotoPerfil.setLayout(new GridBagLayout());
		fotoPerfil.setBorder(BorderFactory.createLineBorder(Color.gray));
		foto = new ImageIcon("medico.jpg"); 
		foto.setImage(foto.getImage().getScaledInstance(160, 160, 150));
		imagemPerfil = new JLabel(foto);
		fotoPerfil.add(imagemPerfil);
		perfil.add(fotoPerfil,new GridBagConstraints(0,1,1,1,0,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,0,0,0),0,0));

		calendario = new Calendario();
		calendario.setBackground(Color.WHITE);
		painelOeste.add(calendario,new GridBagConstraints(0,2,1,1,0,1,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(10,10,0,0),0,223));


		escolhas = new JTabbedPane();
		centro = new JPanel();
		centro.setLayout(new GridBagLayout());
		//centro.setBorder(BorderFactory.createLineBorder(Color.gray));
		centro.setBackground(Color.white);
	}

	public void addAbaConsultas(){

		JPanel consultas;
	    JTable tabelaConsultas;
	    JScrollPane scrollConsultas;
	    DefaultTableCellRenderer centerRenderer;
		
		escolhas = new JTabbedPane();
		centro = new JPanel();
		centro.setLayout(new GridBagLayout());
		//centro.setBorder(BorderFactory.createLineBorder(Color.gray));
		centro.setBackground(Color.white);
		consultas = new JPanel();
		consultas.setLayout(new GridBagLayout());

        //Criar controles
        //caixaTipoPesquisa = new JComboBox<>();      
        botaoPesquisa = new JButton ("Pesquisar");
        modeloConsultas = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tabelaConsultas = new JTable(modeloConsultas);
        scrollConsultas = new JScrollPane(tabelaConsultas);
        pesquisaConsulta = new TextField("Pesquisa por nome do paciente",20);
        
        //Registrar ações dos Listener
        //caixaTipoPesquisa.addActionListener(new acaoCaixaTipoPesquisa());

        scrollConsultas.setPreferredSize(new Dimension(600,540));
        
        //Setar as bordas //GridBsgLayout(x,y,largura,altura);
        //consultas.add(caixaTipoPesquisa,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        consultas.add(pesquisaConsulta,new GridBagConstraints(1,0,1,1,1,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        consultas.add(botaoPesquisa,new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        
        //Propriedade da caixa de pesquisa com texto padrao
        pesquisaConsulta.setForeground(Color.gray);
		pesquisaConsulta.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	if(pesquisaConsulta.getText().equals("Pesquisa por nome do paciente")){
            		pesquisaConsulta.setText("");
            		pesquisaConsulta.setForeground(Color.black);
            	}
            }
            @Override
            public void focusLost(FocusEvent e) {
            	if(pesquisaConsulta.getText().equals("")){
            		pesquisaConsulta.setForeground(Color.gray);
            		pesquisaConsulta.setText("Pesquisa por nome do paciente");
            	}
            }
        });
	    
        //Adicionar linhas e colunas
        tabelaConsultas.setTableHeader(null);
        tabelaConsultas.setRowHeight(40);
        modeloConsultas.setColumnCount(2);
        modeloConsultas.setRowCount(0);

        centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tabelaConsultas.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

        tabelaConsultas.getColumnModel().getColumn(0).setPreferredWidth(360);
        tabelaConsultas.getColumnModel().getColumn(1).setPreferredWidth(540);


        consultas.add(scrollConsultas,new GridBagConstraints(0,1,3,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(20,10,10,10),0,0));
        consultas.setBackground(Color.white);

		escolhas.add( consultas, "     Consultas     ");

		centro.add(escolhas,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,5	,20,20),0,0));
		painel.add(centro,new GridBagConstraints(1,0,3,0,10,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));

	}

	public void addAbaPacientes(){

		JPanel pacientes;
		JComboBox<String> caixaTipoPesquisa = new JComboBox<>();
	    JButton botaoPesquisa;
	    DefaultTableModel modeloPacientes;
	    JTable tabelaPacientes;
	    JScrollPane scrollPacientes;
	    DefaultTableCellRenderer centerRenderer;

		pacientes = new JPanel();
		pacientes.setLayout(new GridBagLayout());
        //Criar controles
        //caixaTipoPesquisa = new JComboBox<>();      
        botaoPesquisa = new JButton ("Pesquisar");
        modeloPacientes = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tabelaPacientes = new JTable(modeloPacientes);
        scrollPacientes = new JScrollPane(tabelaPacientes);
        pesquisaPaciente = new TextField("Pesquisa por nome do paciente",20);
        
        //Registrar ações dos Listener
        //caixaTipoPesquisa.addActionListener(new acaoCaixaTipoPesquisa());

        scrollPacientes.setPreferredSize(new Dimension(600,540));
        
        //Setar as bordas //GridBsgLayout(x,y,largura,altura);
        //Pacientes.add(caixaTipoPesquisa,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        pacientes.add(pesquisaPaciente,new GridBagConstraints(1,0,1,1,1,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        pacientes.add(botaoPesquisa,new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        
        //Propriedade da caixa de pesquisa com texto padrao
        pesquisaPaciente.setForeground(Color.gray);
		pesquisaPaciente.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	if(pesquisaPaciente.getText().equals("Pesquisa por nome do paciente")){
            		pesquisaPaciente.setText("");
            		pesquisaPaciente.setForeground(Color.black);
            	}
            }
            @Override
            public void focusLost(FocusEvent e) {
            	if(pesquisaPaciente.getText().equals("")){
            		pesquisaPaciente.setForeground(Color.gray);
            		pesquisaPaciente.setText("Pesquisa por nome do paciente");
            	}
            }
        });
		//caixaTipoPesquisa.addItem("Data");
		//caixaTipoPesquisa.addItem("Hora");
        //caixaTipoPesquisa.addItem("Paciente");
        
        //modeloPacientes.addColumn("Data");
        //modeloPacientes.addColumn("Hora");
        //modeloPacientes.addColumn("Paciente");
	    
        //Adicionar linhas e colunas
        tabelaPacientes.setTableHeader(null);
        tabelaPacientes.setRowHeight(40);
        modeloPacientes.setColumnCount(1);
        modeloPacientes.setRowCount(16);

        centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tabelaPacientes.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

        //tabelaPacientes.getColumnModel().getColumn(0).setPreferredWidth(60);
        //tabelaPacientes.getColumnModel().getColumn(1).setPreferredWidth(540);


        pacientes.add(scrollPacientes,new GridBagConstraints(0,1,3,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(20,10,10,10),0,0));
        pacientes.setBackground(Color.white);

		escolhas.add( pacientes, "     Pacientes     ");

		centro.add(escolhas,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,5	,20,20),0,0));
		painel.add(centro,new GridBagConstraints(1,0,3,0,10,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));

		//botaoPesquisa.addActionListener(controller);
	}

	public void addAbaAtendentes(){
		JPanel atendentes;
		JComboBox<String> caixaTipoPesquisa = new JComboBox<>();
	    JButton botaoPesquisa;
	    DefaultTableModel modeloAtendentes;
	    JTable tabelaAtendentes;
	    JScrollPane scrollAtendentes;
	    DefaultTableCellRenderer centerRenderer;

		atendentes = new JPanel();
		atendentes.setLayout(new GridBagLayout());
        //Criar controles
        //caixaTipoPesquisa = new JComboBox<>();      
        botaoPesquisa = new JButton ("Pesquisar");
        modeloAtendentes = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tabelaAtendentes = new JTable(modeloAtendentes);
        scrollAtendentes = new JScrollPane(tabelaAtendentes);
        pesquisaAtendente = new TextField("Pesquisa por nome do paciente",20);
        
        //Registrar ações dos Listener
        //caixaTipoPesquisa.addActionListener(new acaoCaixaTipoPesquisa());

        scrollAtendentes.setPreferredSize(new Dimension(600,540));
        
        //Setar as bordas //GridBsgLayout(x,y,largura,altura);
        //Atendentes.add(caixaTipoPesquisa,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        atendentes.add(pesquisaAtendente,new GridBagConstraints(1,0,1,1,1,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        atendentes.add(botaoPesquisa,new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        
        //Propriedade da caixa de pesquisa com texto padrao
        pesquisaAtendente.setForeground(Color.gray);
		pesquisaAtendente.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	if(pesquisaAtendente.getText().equals("Pesquisa por nome do paciente")){
            		pesquisaAtendente.setText("");
            		pesquisaAtendente.setForeground(Color.black);
            	}
            }
            @Override
            public void focusLost(FocusEvent e) {
            	if(pesquisaAtendente.getText().equals("")){
            		pesquisaAtendente.setForeground(Color.gray);
            		pesquisaAtendente.setText("Pesquisa por nome do paciente");
            	}
            }
        });
		//caixaTipoPesquisa.addItem("Data");
		//caixaTipoPesquisa.addItem("Hora");
        //caixaTipoPesquisa.addItem("Paciente");
        
        //modeloAtendentes.addColumn("Data");
        //modeloAtendentes.addColumn("Hora");
        //modeloAtendentes.addColumn("Paciente");
	    
        //Adicionar linhas e colunas
        tabelaAtendentes.setTableHeader(null);
        tabelaAtendentes.setRowHeight(40);
        modeloAtendentes.setColumnCount(1);
        modeloAtendentes.setRowCount(16);

        centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tabelaAtendentes.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

        //tabelaAtendentes.getColumnModel().getColumn(0).setPreferredWidth(60);
        //tabelaAtendentes.getColumnModel().getColumn(1).setPreferredWidth(540);


        atendentes.add(scrollAtendentes,new GridBagConstraints(0,1,3,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(20,10,10,10),0,0));
        atendentes.setBackground(Color.white);

		escolhas.add( atendentes, "     Atendentes     ");

		centro.add(escolhas,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,5	,20,20),0,0));
		painel.add(centro,new GridBagConstraints(1,0,3,0,10,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));

		//botaoPesquisa.addActionListener(controller);
	}

	public void addAbaMedicos(){
		JPanel medicos;
		JComboBox<String> caixaTipoPesquisa = new JComboBox<>();
	    JButton botaoPesquisa;
	    DefaultTableModel modeloMedicos;
	    JTable tabelaMedicos;
	    JScrollPane scrollMedicos;
	    DefaultTableCellRenderer centerRenderer;

		medicos = new JPanel();
		medicos.setLayout(new GridBagLayout());
        //Criar controles
        //caixaTipoPesquisa = new JComboBox<>();      
        botaoPesquisa = new JButton ("Pesquisar");
        modeloMedicos = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tabelaMedicos = new JTable(modeloMedicos);
        scrollMedicos = new JScrollPane(tabelaMedicos);
        pesquisaMedico = new TextField("Pesquisa por nome do paciente",20);
        
        //Registrar ações dos Listener
        //caixaTipoPesquisa.addActionListener(new acaoCaixaTipoPesquisa());

        scrollMedicos.setPreferredSize(new Dimension(600,540));
        
        //Setar as bordas //GridBsgLayout(x,y,largura,altura);
        //Medicos.add(caixaTipoPesquisa,new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        medicos.add(pesquisaMedico,new GridBagConstraints(1,0,1,1,1,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        medicos.add(botaoPesquisa,new GridBagConstraints(2,0,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL,new Insets(10,10,10,10),0,0));
        
        //Propriedade da caixa de pesquisa com texto padrao
        pesquisaMedico.setForeground(Color.gray);
		pesquisaMedico.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	if(pesquisaMedico.getText().equals("Pesquisa por nome do paciente")){
            		pesquisaMedico.setText("");
            		pesquisaMedico.setForeground(Color.black);
            	}
            }
            @Override
            public void focusLost(FocusEvent e) {
            	if(pesquisaMedico.getText().equals("")){
            		pesquisaMedico.setForeground(Color.gray);
            		pesquisaMedico.setText("Pesquisa por nome do paciente");
            	}
            }
        });
		//caixaTipoPesquisa.addItem("Data");
		//caixaTipoPesquisa.addItem("Hora");
        //caixaTipoPesquisa.addItem("Paciente");
        
        //modeloMedicos.addColumn("Data");
        //modeloMedicos.addColumn("Hora");
        //modeloMedicos.addColumn("Paciente");
	    
        //Adicionar linhas e colunas
        tabelaMedicos.setTableHeader(null);
        tabelaMedicos.setRowHeight(40);
        modeloMedicos.setColumnCount(1);
        modeloMedicos.setRowCount(16);

        centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tabelaMedicos.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

        //tabelaMedicos.getColumnModel().getColumn(0).setPreferredWidth(60);
        //tabelaMedicos.getColumnModel().getColumn(1).setPreferredWidth(540);


        medicos.add(scrollMedicos,new GridBagConstraints(0,1,3,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(20,10,10,10),0,0));
        medicos.setBackground(Color.white);

		escolhas.add( medicos, "     Medicos     ");

		centro.add(escolhas,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,5	,20,20),0,0));
		painel.add(centro,new GridBagConstraints(1,0,3,0,10,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));

		//botaoPesquisa.addActionListener(controller);
	}

	public void tornarVisivel(){
		janela.setVisible(true);
	}

	public void addController(Controller controller){
		this.controller = controller;
		botaoPesquisa.addActionListener(controller);
		calendario.tabelaCalendario.addMouseListener(controller);
	}

	public void update(Observable obs, Object obj) {
        Consulta procurado;
        int cont = 0;
        String alvo;
        //String[] texto = new String[300];
        //int cont =0;
        
        //medico.dados.pesquisar(pesquisa.getText())
		//System.out.println("Pesquizando....");
		cont=0;
		
		while(modeloConsultas.getRowCount()>0){
	        	modeloConsultas.removeRow(cont);
	    } 


	    if (obj instanceof Collection ){
	    	@SuppressWarnings("unchecked")
	    	ArrayList<Consulta> consultasDia = (ArrayList)obj;	
	    	//System.out.println("Entrou3!!!!");
	    	for(Consulta c : consultasDia){
				//System.out.println(c.paciente+" "+c.medico);
				modeloConsultas.addRow(new Object[]{"Data: "+c.dataHora[0]+"/"+c.dataHora[1]+"/"+c.dataHora[2]+"  Horario: "+c.dataHora[3]+":00"+"\n"});
				//modeloConsultas.setValueAt("Horario: "+c.dataHora[3]+":00"+"\n"+"  Data: "+c.dataHora[0]+"/"+c.dataHora[1]+"/"+c.dataHora[2] , (c.dataHora[3]-6) , 0);
	        	modeloConsultas.setValueAt(c.paciente,cont,1);
	        	cont++;
        	}
	    }       
	    else{
	    	//System.out.println("Entrou!!!!");
	        if ((int)obj == 1){
	        	alvo = pesquisaConsulta.getText();
	        	pesquisaConsulta.setText("Pesquisando...");
				/*for(int i=6;i<22;i++){	
		        	modeloConsultas.setValueAt("",i-6,1);
		        }*/
		        //System.out.println(alvo);
		        while(modeloConsultas.getRowCount()>0){
		        	modeloConsultas.removeRow(cont);	        	
		       	}

				/*for(Consulta c : consultasDia){
					System.out.println(c.paciente+" "+c.medico);
					if (pesquisa.getText().equals(c.paciente)){
						modeloConsultas.addRow(new Object[]{"Data: "+c.dataHora[0]+"/"+c.dataHora[1]+"/"+c.dataHora[2]+"  Horario: "+c.dataHora[3]+":00"+"\n"});
						//modeloConsultas.setValueAt("Horario: "+c.dataHora[3]+":00"+"\n"+"  Data: "+c.dataHora[0]+"/"+c.dataHora[1]+"/"+c.dataHora[2] , (c.dataHora[3]-6) , 0);
			        	modeloConsultas.setValueAt(c.paciente,cont,1);
			        	cont++;
		        	}
		        }*/
	        }
	    }
	    /*for(int i=6;i<22;i++){
        	modeloConsultas.setValueAt("",i-6,1);
        }*/
      
        /*
		for(Consulta c : consultasDia){
			System.out.println(c.paciente+" "+c.medico);
			modeloConsultas.addRow(new Object[]{"Data: "+c.dataHora[0]+"/"+c.dataHora[1]+"/"+c.dataHora[2]+"  Horario: "+c.dataHora[3]+":00"+"\n"});
			//modeloConsultas.setValueAt("Horario: "+c.dataHora[3]+":00"+"\n"+"  Data: "+c.dataHora[0]+"/"+c.dataHora[1]+"/"+c.dataHora[2] , (c.dataHora[3]-6) , 0);
        	modeloConsultas.setValueAt(c.paciente,cont,1);
        	cont++;
        }*/
		
        
		/*Iterator i = this.user.consutlas.iterator();
        while (i.hasNext()){
           procurado = (Consulta)i.next();
           if(pesquisa.getText() != ""){
                if (procurado.data.equals(pesquisa.getText())){
                    String[cont] = (String)(procurado.data + " "+ procurado.hora+" " + procurado.medico)
                    modeloconsultas.addRow(String[cont]);
                    cont++;
                    this.modeloConsultas.addRow(new String[]{procurado.data,procurado.hora,procurado.medico});
                }  
                          
                if (procurado.hora.equals(pesquisa.getText())){
                    this.modeloConsultas.addRow(new String[]{procurado.data,procurado.hora,procurado.medico}); 
                }  
               
                if (procurado.paciente.equals(pesquisa.getText())){
                    this.modeloConsultas.addRow(new String[]{procurado.data,procurado.hora,procurado.medico});
                }
           }
           else {   //printa tudo rapa!!!
               this.modeloConsultas.addRow(new String[]{procurado.data,procurado.hora,procurado.medico});
           }
                    
	    }*/
    }
}