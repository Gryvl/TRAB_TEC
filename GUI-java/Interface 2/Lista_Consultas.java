import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Lista_Consultas{
    static JLabel titulo_Mes, titulo_Ano;
    static JButton botao_Pesquisa, botao_Predecessor;
    static JTable tabela_Calendario;
    static JComboBox caixa_Tipo_Pesquisa;
    static JFrame janela_Calendario;
    static Container container_Consultas;
    static DefaultTableModel modelo_Consultas; 
    static JScrollPane scroll_Consultas; 
    static int real_Ano, real_Mes, real_Dia, atual_Ano, atual_Mes;
    static JPanel painel;
    final TextField pesquisa;
    final JTabbedPane escolhas;
    public Lista_Consultas(){
        //Tratamento
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
        //Configurando Janela
        painel = new JPanel();
        painel.setBorder(BorderFactory.createLineBorder(Color.gray));
        janela_Calendario = new JFrame ("Lista de consultas"); //Criar janela
        janela_Calendario.setSize(600,800); //Setar o tamanho
        container_Consultas = janela_Calendario.getContentPane();
        container_Consultas.setLayout(null);
        janela_Calendario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechar quando apertar X 
        
        
        //Criar controles
        caixa_Tipo_Pesquisa = new JComboBox();
        botao_Pesquisa = new JButton ("Pesq");
        modelo_Consultas = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tabela_Calendario = new JTable(modelo_Consultas);
        scroll_Consultas = new JScrollPane(tabela_Calendario);
        escolhas = new JTabbedPane();
        pesquisa = new TextField("pesquisa",25);
        pesquisa.setForeground(Color.gray);
        
        //Registrar ações dos Listener
        caixa_Tipo_Pesquisa.addActionListener(new acao_Caixa_Tipo_Pesquisa());
        
        //Adicionar controle ao painel
        container_Consultas.add(caixa_Tipo_Pesquisa);
        container_Consultas.add(pesquisa);
        container_Consultas.add(botao_Pesquisa);
        escolhas.add( painel, "     Consultas     ");
        //painel.add(escolhas);
        container_Consultas.add(scroll_Consultas);
        container_Consultas.add(escolhas);
        
        //Setar as bordas //setBounds(x,y,largura,altura);
        container_Consultas.setBounds(0, 0, 320, 335);
        caixa_Tipo_Pesquisa.setBounds(200, 60, 250, 20);//Selecionar ano
        pesquisa.setBounds(550, 60, 250, 20);//Selecionar pesquisa
        painel.setBounds(150,50,750,650);//Borda da lista de contatos
        botao_Pesquisa.setBounds(810, 60, 80, 20);//Botão anterior
        scroll_Consultas.setBounds(200, 100, 650, 550);
        modelo_Consultas.addColumn("Consultas");
        
        //Configuração da janela
        janela_Calendario.setResizable(false);
        janela_Calendario.setVisible(false);
        
        //Obter o ano,o mês e o dia
        GregorianCalendar cal = new GregorianCalendar(); //Criar calendario
        real_Dia = cal.get(GregorianCalendar.DAY_OF_MONTH); //Obter dia
        real_Mes = cal.get(GregorianCalendar.MONTH); //Obter mês
        real_Ano = cal.get(GregorianCalendar.YEAR); //Obter ano
        atual_Mes = real_Mes; //Match month and year
        atual_Ano = real_Ano;

        caixa_Tipo_Pesquisa.addItem("Paciente");
        caixa_Tipo_Pesquisa.addItem("Hora");
        caixa_Tipo_Pesquisa.addItem("Data");
        
        //Adicionar linhas e colunas
        tabela_Calendario.setRowHeight(45);
        modelo_Consultas.setColumnCount(1);
        modelo_Consultas.setRowCount(15);
        
        
    } 
    
    static class acao_Caixa_Tipo_Pesquisa implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (caixa_Tipo_Pesquisa.getSelectedItem() != null){
                String b = caixa_Tipo_Pesquisa.getSelectedItem().toString();
            }
        }
    }
    static void setBackground(Color e){
        container_Consultas.setBackground(e);
    }
}