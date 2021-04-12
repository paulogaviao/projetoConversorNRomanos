package br.com.manageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.daoGenerico.DaoGenerico;
import br.com.entidades.Numero;

@ViewScoped
@ManagedBean(name = "numeroBean")
public class NumeroBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	/*INSTÂNCIO DA ENTIDADE QUE SERA USADA NO MANAGEBEAN*/
	private Numero numero = new Numero();
	private DaoGenerico<Numero> dao = new DaoGenerico<Numero>();
	private static final int[] DECIMAIS =
        {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANOS =
        {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
	
/*ESSE MÉTODO FAZ A CONVERSÃO CONFORME SOLICITADO EM TELA*/
	public String converter() {

		if (isInteger( numero.getElemento()) == false) {
			mostrarMsg("*Esse não é um número válido*");

		} else {

			int decimal = Integer.parseInt(numero.getElemento());

			String resultado= converterEmRomanos(decimal);   
            numero.setEmRomano(resultado);
            int i=0;
			/* LISTAS PARA CONTROLE DE CARACTERES */
			List<String> x = new ArrayList<String>();
			List<String> I = new ArrayList<String>();
			List<String> v = new ArrayList<String>();
			List<String> l = new ArrayList<String>();
			List<String> c = new ArrayList<String>();
			List<String> d = new ArrayList<String>();
			List<String> m = new ArrayList<String>();
			/* FIM DA LISTA DE CONTROLE*/
            /*ESSA ITERAÇÃO PERMITE CONTROLAR A QUANTIDADE DE CARACTERES DO N° ROMANO*/
			for (i = 0; i < resultado.length(); i++) {
				String j = String.valueOf(resultado.charAt(i));/*ENSIRO CADA CARACTERE DENTRO DA SUA RESPECTIVA LISTA*/

				if (j.equals("X")) {
					x.add(j);
				}
				if (j.equals("I")) {
					I.add(j);
				}
				if (j.equals("V")) {
					v.add(j);
				}
				if (j.equals("L")) {
					l.add(j);
				}
				if (j.equals("C")) {
					c.add(j);
				}

				if (j.equals("D")) {
					d.add(j);
				}
				if (j.equals("M")) {
					m.add(j);
				}
			}
			/*FORA DA ITERAÇÃO CRIA-SE A CONDIÇÃO SE TIVER LETRAS NA LISTA REFERIDA APRESENTA A MENSAGEM COM A QUANTIA CONTIDA NA LISTA*/
			if(resultado.length()>0)
				if(x.size()>0) {
			      mostrarMsg("A quantia de Caracterer(s) X no numero Romano é: " + x.size());
				}
			       if(I.size()>0) {
			    	   mostrarMsg("A quantia de Caracterer(s) I no numero Romano é: " + I.size());
			        }
			        	if(v.size()>0) {
				    	   mostrarMsg("A quantia de Caracterer(s) V no numero Romano é: " + v.size());
				        } 
				        	if(l.size()>0) {
						    	   mostrarMsg("A quantia de Caracterer(s) L no numero Romano é: " + l.size());
						        }  
						        	if(c.size()>0) {
								    	   mostrarMsg("A quantia de Caracterer(s) C no numero Romano é: " + c.size());
								        }  
								        	if(d.size()>0) {
										    	   mostrarMsg("A quantia de Caracterer(s) D no numero Romano é: " + d.size());
										        } 
										        	if(m.size()>0) {
												    	   mostrarMsg("A quantia de M no numero Romano é: " + m.size());
												        }
            }
		      
		   /*RETORNA PARA A MESMA TELA*/
		return "";
	}
    /*METODO RECEBE UM PARAMETRO VINDA DA TELA E VERIFICA SE É UM NÚMERO OU NÃO*/
	private static boolean isInteger(String str) {
		return str != null && str.matches("[0-9]*");
	}
    /*ESSE MÉTODO APRESENTA UMA MENSAGEM NA TELA DO USUÁRIO CONFORME FOR SOLICITADO*/
	private void mostrarMsg(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(null, message);
	}
	/*MÉTODO QUE RECEBE O NUMERO VINDO DA TELA E FAZ A CONVERSÃO PARA ROMANOS*/
	public static String converterEmRomanos(int decimal) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < DECIMAIS.length; i++) {
            int parteInteira = decimal / DECIMAIS[i];
            decimal -= DECIMAIS[i] * parteInteira;
            resultado.append(String.join("",Collections.nCopies(parteInteira, ROMANOS[i])));
        }
        return resultado.toString();
    }
	/*LIMPA A TELA PARA UMA UMA NOVA CONVERSÃO*/
	public String limpar() {
	numero = new Numero();
		return"";
	}
	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}
	public String salvar() { /*METODO SALVAR NO BANCO DE DADOS*/
		dao.salvar(numero);
		
		return"";
	}
	

}
