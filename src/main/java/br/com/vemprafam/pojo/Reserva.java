package br.com.vemprafam.pojo;

public class Reserva {
    private int id;
    private int carroId;
    private int locatarioId;
    private Date dataInicioReserva;
    private Date dataFimReserva;
    private String status;

    public Reserva() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Reserva(int id, int carroId,String status, int locatarioId, Date dataInicioReserva, Date dataFimReserva) {
        super();
        this.id = id;
        this.carroId = carroId;
        this.locatarioId = locatarioId;
        this.dataInicioReserva = dataInicioReserva;
        this.dataFimReserva = dataFimReserva;
        this.status = status;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCarroId() { return carroId; }
    public void setCarroId(int carroId) { this.carroId = carroId; }
    public int getLocatarioId() { return locatarioId; }
    public void setLocatarioId(int locatarioId) { this.locatarioId = locatarioId; }
    public String getStatus() { this.status = status; }
    public void setStatus(String status) { this.status = status; }
    public Date getDataInicioReserva() { return dataInicioReserva; }
    public String getDataInicioReservaFormat() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataInicioReserva);
    }
    public void setDataInicioReserva(Date dataInicioReserva) { this.dataInicioReserva = dataInicioReserva;}

    public Date getDataFimReserva() { return dataFimReserva; }
    public String getDataFimReeservaFormat() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataFimReserva);
    }
    public void setDataFimReserva(Date dataFimReserva) { this.dataFimReserva = dataFimReserva; }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", carroId=" + carroId + ", locatarioId=" + locatarioId + ", dataInicioReserva=" +
                dataInicioReserva + ", dataFimReserva=" + dataFimReserva + ", status=" + dataInicioReserva + "]";
    }
}

