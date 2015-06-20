import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Calendario_Login{
    static JLabel titulo_Mes, titulo_Ano;
    static JButton botao_Anterior, botao_Predecessor;
    static JTable tabela_Calendario;
    static JComboBox caixa_Ano;
    static JFrame janela_Calendario;
    static Container container_Calendario;
    static DefaultTableModel modelo_Calendario; 
    static JScrollPane scroll_Calendario; 
    static int real_Ano, real_Mes, real_Dia, atual_Ano, atual_Mes;
    public Calendario_Login(){
        //Tratamento
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
        //Configurando Janela
        janela_Calendario = new JFrame ("Calendario"); //Criar janela
        janela_Calendario.setSize(270,300); //Setar o tamanho
        container_Calendario = janela_Calendario.getContentPane();
        container_Calendario.setLayout(null);
        janela_Calendario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechar quando apertar X 
        
        
        //Criar controles
        titulo_Mes = new JLabel ("Janeiro");
        titulo_Ano = new JLabel ("Selecione o ano:");
        caixa_Ano = new JComboBox();
        botao_Anterior = new JButton ("<-");
        botao_Predecessor = new JButton ("->");
        modelo_Calendario = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tabela_Calendario = new JTable(modelo_Calendario);
        scroll_Calendario = new JScrollPane(tabela_Calendario);
        
        //Registrar ações dos Listener
        botao_Anterior.addActionListener(new acao_Botao_Anterior());
        botao_Predecessor.addActionListener(new acao_Botao_Predecessor());
        caixa_Ano.addActionListener(new acao_Caixa_Ano());
        
        //Adicionar controle ao painel
        container_Calendario.add(titulo_Mes);
        container_Calendario.add(titulo_Ano);
        container_Calendario.add(caixa_Ano);
        container_Calendario.add(botao_Anterior);
        container_Calendario.add(botao_Predecessor);
        container_Calendario.add(scroll_Calendario);
        
        //Setar as bordas
        container_Calendario.setBounds(0, 0, 320, 335);
        titulo_Mes.setBounds(135-titulo_Mes.getPreferredSize().width/2, 25, 50, 25);// Titulo mês
        titulo_Ano.setBounds(10, 250, 80, 20);//Titulo ano
        caixa_Ano.setBounds(180, 250, 80, 20);//Selecionar ano
        botao_Anterior.setBounds(10, 25, 50, 25);//Botão anterior
        botao_Predecessor.setBounds(210, 25, 50, 25);//Botão predecessor
        scroll_Calendario.setBounds(10, 50, 250, 200);
        
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
        
        //Todos os dias da semana
        String[] headers = {"D", "S", "T", "Q", "Q", "S", "S"}; //Todos os dias da semana
        for (int i=0; i<7; i++){
            modelo_Calendario.addColumn(headers[i]);
        }
        
        tabela_Calendario.getParent().setBackground(tabela_Calendario.getBackground()); //Adicionar Background
        
        //No resize/reorder
        tabela_Calendario.getTableHeader().setResizingAllowed(false);
        tabela_Calendario.getTableHeader().setReorderingAllowed(false);
        
        //Celula selecionada
        tabela_Calendario.setColumnSelectionAllowed(true);
        tabela_Calendario.setRowSelectionAllowed(true);
        tabela_Calendario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Adicionar linhas e colunas
        tabela_Calendario.setRowHeight(38);
        modelo_Calendario.setColumnCount(7);
        modelo_Calendario.setRowCount(6);
        
        //Popular a tabela
        for (int i=real_Ano-10; i<=real_Ano+100; i++){
            caixa_Ano.addItem(String.valueOf(i));
        }
        
        //Atualizar calendario
        atualizar_Calendario (real_Mes, real_Ano); //Atualizar calendario
    } 
    public static void atualizar_Calendario(int mes, int ano){
        //Variables
        String[] meses =  {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        int nod, som; //número de dias e o começo do mês
        
        //Acionar os botões
        botao_Anterior.setEnabled(true);
        botao_Predecessor.setEnabled(true);
        if (mes == 0 && ano <= real_Ano-10){botao_Anterior.setEnabled(false);} 
        if (mes == 11 && ano >= real_Ano+100){botao_Predecessor.setEnabled(false);} 
        titulo_Mes.setText(meses[mes]); //Atualizar o mês
        titulo_Mes.setBounds(135-titulo_Mes.getPreferredSize().width/2, 25, 100, 25); //Realinhar os titulos com o calendario
        caixa_Ano.setSelectedItem(String.valueOf(ano)); //Selecionar o ano correto
        
        //Limpar tabela
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                modelo_Calendario.setValueAt(null, i, j);
            }
        }
        
        //Pegar o primeiro dia do mês e o número do primeiro dia
        GregorianCalendar cal = new GregorianCalendar(ano, mes, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        //Desenhar calendario
        for (int i=1; i<=nod; i++){
            int row = new Integer((i+som-2)/7);
            int column  =  (i+som-2)%7;
            modelo_Calendario.setValueAt(i, row, column);
        }
        
        //Aplicar redenrização
        tabela_Calendario.setDefaultRenderer(tabela_Calendario.getColumnClass(0), new renderizar_Tabela_Calendario());
    }
    
    static class renderizar_Tabela_Calendario extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6){ //Final de semana
                setBackground(new Color(255, 220, 220));
            }
            else{ //Semana
                setBackground(new Color(255, 255, 255));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == real_Dia && atual_Mes == real_Mes && atual_Ano == real_Ano){ //Today
                    setBackground(new Color(220, 220, 255));
                }
            }
            setBorder(null);
            setHorizontalAlignment(JLabel.CENTER);
            setForeground(Color.black);
            return this;
        }
    }
    
    static class acao_Botao_Anterior implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (atual_Mes == 0){ //Voltar um ano
                atual_Mes = 11;
                atual_Ano -= 1;
            }
            else{ //Voltar um mês
                atual_Mes -= 1;
            }
            atualizar_Calendario(atual_Mes, atual_Ano);
        }
    }
    static class acao_Botao_Predecessor implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (atual_Mes == 11){ //Avançar um ano
                atual_Mes = 0;
                atual_Ano += 1;
            }
            else{ //Avançar um mês
                atual_Mes += 1;
            }
            atualizar_Calendario(atual_Mes, atual_Ano);
        }
    }
    static class acao_Caixa_Ano implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (caixa_Ano.getSelectedItem() != null){
                String b = caixa_Ano.getSelectedItem().toString();
                atual_Ano = Integer.parseInt(b);
                atualizar_Calendario(atual_Mes, atual_Ano);
            }
        }
    }
    static void setBackground(Color e){
        container_Calendario.setBackground(e);
    }
}