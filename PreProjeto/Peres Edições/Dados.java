/*
    * adicionarConsulta foi melhorado, agora checa se o paciente e o médico existem no programa;
*/

import java.util.*;
import java.io.*;

class Dados implements Serializable{
    
    List<Consulta> consultas = new ArrayList<>();    
    public List[] perfis= new ArrayList[4];
    
    
    public Dados(){
		for(int i=0; i<4;i++){
			perfis[i] = new ArrayList<Usuario>();
		}
	}
	public void adicionarPerfil(Usuario u){
		perfis[u.getAcesso()-1].add(u);
	}

    public boolean adicionarConsulta(Consulta c){
        Iterator i = consultas.iterator();
        Consulta aux;
        //checando disponibilidade do horário e do médico
        while (i.hasNext()){
            aux=(Consulta)i.next(); 
            if ((aux.medico==c.medico)||(aux.paciente==c.paciente)){
                if (aux.dataHora.equals(c.dataHora)){
                    return false;
                }
            }
        }

        //checando existência do médico e paciente
        boolean exist=false;
        Usuario aux2;
        i= perfis[2].iterator(); // pacientes
        while (i.hasNext() && (exist==false)){
            aux2=(Usuario)i.next();
            if (aux2.getNome()==c.getPaciente())
                exist=true;
        }
        if (exist==false)
            return false;

        exist=false;
        i= perfis[3].iterator(); // medicos
        while (i.hasNext() && (exist==false)){
            aux2=(Usuario)i.next();
            if (aux2.getNome()==c.getMedico())
                exist=true;
        }
        if (exist==false)
            return false;

        consultas.add(c);
        return true;
    }

	public Collection<Consulta> consultasDoDia(int dia, int mes, int ano){
        Collection<Consulta> consulta = new ArrayList<>();
        for (Consulta c : consultas){
            if(c.dataHora[0]==dia&&c.dataHora[1]==mes&&c.dataHora[2]==ano){
                consulta.add(c);
            }
        }
        return consulta;
    }
   
    
    
    /*Usuario retirarDadosU(String x){
        Iterator i = datau.iterator()
        Usuario z;
        while (i.hasNext()){
            z = i.next();
            if (z.nome == x)
                return z;
        }
    }
    
    Consulta retirarDadosC(String x){
        Iterator i = datac.iterator()
        Usuario z;
        while (i.hasNext()){
            z = i.next();
            if (z.nome == x)
                return z;
            if (z.hora == x)
                return z;
            if (z.data == x)
                return z;
            if (z.paciente == x)
                return z;
        }        
    }*/
    
    
}