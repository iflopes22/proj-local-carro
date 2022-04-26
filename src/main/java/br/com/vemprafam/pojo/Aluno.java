package br.com.vemprafam.pojo;

import java.util.Date;

public class Aluno {
	private int ra;
	private String nome;
	private double renda;
	private Date dataNascimento;
	public Aluno(int ra, String nome, double renda, Date dataNascimento) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.renda = renda;
		this.dataNascimento = dataNascimento;
	}
	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + ", renda=" + renda + ", dataNascimento=" + dataNascimento + "]";
	}
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}