import java.util.*;
import java.io.*;


class Consulta implements Serializable, Comparable<Consulta> {
    
    String medico;
    String paciente;
    int[] dataHora = new int[4];
    
    void setMedico (String x){
        this.medico=x;
    }
    
    void setPaciente (String x){
        this.paciente=x;
    }
    
    void setDataHora (int dia, int mes, int ano, int hora){
        this.dataHora[0]=dia;
        this.dataHora[1]=mes;
        this.dataHora[2]=ano;
        this.dataHora[3]=hora;
    }
    
    String getPaciente(){        
        return this.paciente;        
    } 
    
    String getMedico(){        
        return this.medico;       
    }
    
    int getDia(){        
        return this.dataHora[0];        
    }
    int getMes(){        
        return this.dataHora[1];        
    }
    int getAno(){        
        return this.dataHora[2];        
    }
    int getHora(){        
        return this.dataHora[3];        
    }

    public int compareTo (Consulta c){
        if (this.dataHora[2]<c.dataHora[2]){
            return -1;
        }
        else {
            
            if (this.dataHora[2]>c.dataHora[2]) {
                return 1;
            }

            if (this.dataHora[1]<c.dataHora[1]) {
                return -1;
            }

            else {
                
                if (this.dataHora[1]>c.dataHora[1]){
                    return 1;
                }

                if (this.dataHora[0]<c.dataHora[0]) {
                    return -1;
                }

                else {

                    if (this.dataHora[0]>c.dataHora[0]) {
                        return 1;
                    }

                    if (this.dataHora[3]<c.dataHora[3]){
                        return -1;
                    }

                    else {
                        
                        if (this.dataHora[3]<c.dataHora[3]){
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }
}