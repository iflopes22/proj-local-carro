package br.com.vemprafam.pojo;

public class Carro {
    private int id;
    private String modelo;
    private int ano;
    private String cor;
    private int porta;
    private int km;
    private boolean locado;

    public carro() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Carro(int id, String modelo, int ano, String cor, int porta, int km, boolean locado) {
        super();
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.porta = porta;
        this.km = km;
        this.locado = locado;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public int getPorta() { return porta; }
    public void setPorta(int porta) { this.porta = porta; }
    public int getKm() { return km; }
    public void setKm(int km) { this.km = km; }
    public boolean getLocado() { return locado; }
    public void setLocado(boolean locado) { this.locado = locado; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }


    @Override
    public String toString() {
        return "Carro [id=" + id + ", modelo=" + modelo + ", ano=" + ano + ", cor=" + cor + ", porta="
                + porta + ",km" + km + ", locado=" + locado + "]";
    }
}
