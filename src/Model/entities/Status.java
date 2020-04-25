package Model.entities;

public enum Status {
    LIVRE("Livre"),DORMINDO("Dormindo"),EXECUCAO("Execução"), FINALIZADO("Finalizado");

    private String status = "";
    Status(String aStatus) {
        status = aStatus;
    }

    public String getStatus(){
        return status;
    }
    
    public void setStatus(Status aStatus){
        this.status = aStatus.status;
    }

}
