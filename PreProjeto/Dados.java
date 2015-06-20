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

        while (i.hasNext()){
            aux=(Consulta)i.next(); 
            if ((aux.medico==c.medico)||(aux.paciente==c.paciente)){
                if (aux.dataHora.equals(c.dataHora)){
                    return false;
                }
            }
        }
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