import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.*;
import javax.swing.*;
import java.util.*;

class Main{
	static Dados bancoDados;
	static TelaLogin login;
    
    public static void main(String[] args){
		//carregarDados();
		//adicionar usuario por meio de codigo
		bancoDados = new Dados(); 
		try{
			Administrador admin = new Administrador(bancoDados);
			admin.setAcesso(1);
			admin.setNome("admin");
			admin.setSenha(sha1(""));
			bancoDados.adicionarPerfil(admin);
			Atendente atend = new Atendente(bancoDados);
			atend.setAcesso(2);
			atend.setNome("atend");
			atend.setSenha(sha1(""));
			bancoDados.adicionarPerfil(atend);
			Medico med = new Medico(bancoDados);
			med.setAcesso(4);
			med.setNome("Jose");
			med.setSenha(sha1(""));
			bancoDados.adicionarPerfil(med);
			Paciente pac = new Paciente(bancoDados);
			pac.setAcesso(3);
			pac.setNome("Toin");
			pac.setSenha(sha1(""));
			bancoDados.adicionarPerfil(pac);
			Paciente pac2 = new Paciente(bancoDados);
			pac2.setAcesso(3);
			pac2.setNome("Toinha");
			pac2.setSenha(sha1(""));
			bancoDados.adicionarPerfil(pac2);

			Consulta c1 = new Consulta();
			c1.setMedico("Jose");
			c1.setPaciente("Toin");
			c1.setDataHora(16,5,2015,16);
			bancoDados.adicionarConsulta(c1);

			Consulta c2 = new Consulta();
			c2.setMedico("Jose");
			c2.setPaciente("Toinha");
			c2.setDataHora(16,5,2015,14);
			bancoDados.adicionarConsulta(c2);

		}catch(Exception e){
			e.printStackTrace();
		}
		login = new TelaLogin(bancoDados);
		JFrame tLogin = login.componentes();

		salvarDados();
	}
    
	static void carregarDados(){
		try{
			File file = new File("Dados.tmp");
			FileInputStream fi_perfils = new FileInputStream(file);
			ObjectInputStream oi_perfils = new ObjectInputStream(fi_perfils);
			bancoDados = (Dados)oi_perfils.readObject();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    
	static void salvarDados(){
		Collections.sort(bancoDados.consultas);
		try{
			FileOutputStream fo_perfils = new FileOutputStream("Dados.tmp");	//salvando arquivo de objeto perfils
			ObjectOutputStream oo_perfils = new ObjectOutputStream(fo_perfils);
			oo_perfils.writeObject(bancoDados);
			oo_perfils.close();
			fo_perfils.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
    
	public static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
    
}