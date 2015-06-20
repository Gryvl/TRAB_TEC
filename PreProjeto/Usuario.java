import java.util.*;
import java.io.*;

abstract class Usuario extends java.util.Observable implements Serializable{
	int nivelacesso;
	String nome;
	String senha;
	Dados dados;

	Usuario(Dados d){
		this.dados = d;
	}

	void setAcesso(int na){
		this.nivelacesso = na;
	}
	void setNome(String nome){
		this.nome = nome;
	}
	void setSenha(String senha){
		this.senha = senha;
	}

	int getAcesso(){
		return nivelacesso;
	}
	String getNome(){
		return nome;
	}
	String getSenha(){
		return senha;
	}
    
    abstract void pesquisar(String x);

    void visualizarHorario(int dia, int mes, int ano){}
    
}