package br.com.vemprafam.pojo;

public class Locatario {
    private int cpf;
    private String email;
    private String nome;
    private String telefone;
    public Locatario() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Locatario(int cpf, String email, String nome, String telefone) {
        super();
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getNome() {return nome; }
    public void setNome(String nome) {this.nome = nome; }
    public String getEmail() {return email; }
    public void setEmail(String email) {this.email = email; }
    public String getTelefone() {return telefone; }
    public void setTelefone(String telefone) {this.telefone = telefone;}

    @Override
    public String toString() {
        return "Locatario [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
                + "]";
    }
}
