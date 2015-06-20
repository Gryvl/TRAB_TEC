import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calendario extends JPanel{
    static JLabel tituloMes, tituloAno;
    static JButton botaoAnterior, botaoPredecessor;
    static JTable tabelaCalendario;
    static JComboBox<String> caixaAno;
    static DefaultTableModel modeloCalendario; 
    static JScrollPane scrollCalendario; 
    static int realAno, realMes, realDia, atualAno, atualMes,atualDia,r=-1,c=-1;

    //private static final long serialVersionUID = -1113582265865921786L;

    public Calendario(){
        //Tratamento
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
        this.setLayout(null);        
        
        //Criar controles
        tituloMes = new JLabel ("Janeiro");
        tituloAno = new JLabel ("Selecione o ano:");
        caixaAno = new JComboBox<String>();
        ImageIcon foto = new ImageIcon("medico.jpg"); 
        foto.setImage(foto.getImage().getScaledInstance(50, 50, 50));
        botaoAnterior = new JButton ("<-");
        botaoPredecessor = new JButton ("->");
        modeloCalendario = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tabelaCalendario = new JTable(modeloCalendario);
        scrollCalendario = new JScrollPane(tabelaCalendario);
        
        //Registrar ações dos Listener
        botaoAnterior.addActionListener(new acaoBotaoAnterior());
        botaoPredecessor.addActionListener(new acaoBotaoPredecessor());
        caixaAno.addActionListener(new acaoCaixaAno());
        
        //Adicionar controle ao painel
        this.add(tituloMes);
        this.add(tituloAno);
        this.add(caixaAno);
        this.add(botaoAnterior);
        this.add(botaoPredecessor);
        this.add(scrollCalendario);
        
        //Setar as bordas
        //this.setBounds(0, 0, 320, 335);
        tituloMes.setBounds(110-tituloMes.getPreferredSize().width/2, 0, tituloMes.getPreferredSize().width, 25);// Titulo mês
        tituloAno.setBounds(10, 200, 200, 25);//Titulo ano
        caixaAno.setBounds(140, 203, 70, 20);//Selecionar ano
        botaoAnterior.setBounds(10, 0, botaoAnterior.getPreferredSize().width, 25);//Botão anterio
        botaoPredecessor.setBounds(165, 0, botaoPredecessor.getPreferredSize().width, 25);//Botão predecessor
        scrollCalendario.setBounds(10, 30, 200, 165);
        
        //Obter o ano,o mês e o dia
        GregorianCalendar cal = new GregorianCalendar(); //Criar calendario
        realDia = cal.get(GregorianCalendar.DAY_OF_MONTH); //Obter dia
        realMes = cal.get(GregorianCalendar.MONTH); //Obter mês
        realAno = cal.get(GregorianCalendar.YEAR); //Obter ano
        atualMes = realMes; //Match month and year
        atualAno = realAno;
        
        //Todos os dias da semana
        String[] headers = {"D", "S", "T", "Q", "Q", "S", "S"}; //Todos os dias da semana
        for (int i=0; i<7; i++){
            modeloCalendario.addColumn(headers[i]);
        }
        
        tabelaCalendario.getParent().setBackground(tabelaCalendario.getBackground()); //Adicionar Background
        
        //No resize/reorder
        tabelaCalendario.getTableHeader().setResizingAllowed(false);
        tabelaCalendario.getTableHeader().setReorderingAllowed(false);
        
        //Celula selecionada
        tabelaCalendario.setColumnSelectionAllowed(true);
        tabelaCalendario.setRowSelectionAllowed(true);
        tabelaCalendario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Adicionar linhas e colunas
        tabelaCalendario.setRowHeight(23);
        tabelaCalendario.setCellSelectionEnabled(true);
        modeloCalendario.setColumnCount(7);
        modeloCalendario.setRowCount(6);
        
        //Popular a tabela
        for (int i=realAno-10; i<=realAno+100; i++){
            caixaAno.addItem(String.valueOf(i));
        }
        
        //Atualizar calendario
        atualizarCalendario (realMes, realAno); //Atualizar calendario

        MouseListener calendarioListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                r = tabelaCalendario.rowAtPoint(e.getPoint());//get mouse-selected row
                c = tabelaCalendario.columnAtPoint(e.getPoint());//get mouse-selected col
                if(tabelaCalendario.getModel().getValueAt(r, c)!=null){
                    atualDia = Integer.parseInt(tabelaCalendario.getModel().getValueAt(r, c).toString());
                    atualizarCalendario (atualMes, atualAno);
                }
            }
        };
        tabelaCalendario.addMouseListener(calendarioListener);
    }
    public void addController(Controller controller){
       tabelaCalendario.addMouseListener(controller);
    }
    public static void atualizarCalendario(int mes, int ano){
        //Variables
        String[] meses =  {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        int nod, som; //número de dias e o começo do mês
        
        //Acionar os botões
        botaoAnterior.setEnabled(true);
        botaoPredecessor.setEnabled(true);
        if (mes == 0 && ano <= realAno-10){botaoAnterior.setEnabled(false);} 
        if (mes == 11 && ano >= realAno+100){botaoPredecessor.setEnabled(false);} 
        tituloMes.setText(meses[mes]); //Atualizar o mês
        tituloMes.setBounds(110-tituloMes.getPreferredSize().width/2,0, tituloMes.getPreferredSize().width, 25); //Realinhar os titulos com o calendario
        caixaAno.setSelectedItem(String.valueOf(ano)); //Selecionar o ano correto
        
        //Limpar tabela
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                modeloCalendario.setValueAt(null, i, j);
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
            modeloCalendario.setValueAt(i, row, column);
        }
        
        //Aplicar redenrização
        tabelaCalendario.setDefaultRenderer(tabelaCalendario.getColumnClass(0), new renderizarTabelaCalendario());
    }
    
    static class renderizarTabelaCalendario extends DefaultTableCellRenderer{
        
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6){ //Final de semana
                setBackground(new Color(255, 220, 220));//vermelho
            }
            else{ //Semana
                setBackground(new Color(255, 255, 255));//branco
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDia && atualMes == realMes && atualAno == realAno){ //Today
                    setBackground(new Color(220, 220, 255));//azul
                    if(c==-1&&r== -1){
                        setBackground(new Color(180, 240, 180));//verde
                    }
                }
            }
            if(column == c&&row ==r&&value!=null){
                setBackground(new Color(180, 240, 180));//verde
            }
            setBorder(null);
            setHorizontalAlignment(JLabel.CENTER);
            setForeground(Color.black);
            return this;
        }
    }
    
    static class acaoBotaoAnterior implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (atualMes == 0){ //Voltar um ano
                atualMes = 11;
                atualAno -= 1;
            }
            else{ //Voltar um mês
                atualMes -= 1;
            }
            atualizarCalendario(atualMes, atualAno);
        }
    }
    static class acaoBotaoPredecessor implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (atualMes == 11){ //Avançar um ano
                atualMes = 0;
                atualAno += 1;
            }
            else{ //Avançar um mês
                atualMes += 1;
            }
            atualizarCalendario(atualMes, atualAno);
        }
    }
    static class acaoCaixaAno implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (caixaAno.getSelectedItem() != null){
                String b = caixaAno.getSelectedItem().toString();
                atualAno = Integer.parseInt(b);
                atualizarCalendario(atualMes, atualAno);
            }
        }
    }
}
