import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

class Medico extends Usuario{
	
	Medico(Dados d){
		super(d);
	}

    void pesquisar(String pequisa){
		setChanged();
		notifyObservers(1);
	}
    
	void visualizarHorario(int dia, int mes, int ano){
		setChanged();
		notifyObservers(dados.consultasDoDia(dia,mes,ano));
    }
}