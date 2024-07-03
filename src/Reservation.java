public class Reservation {
    private int oId;
    private int uId;
    private String oTime;
    private String oTotal;
    private String oStatus;

    public int getoId() {
        return oId;
    }

    public int getuId() {
        return uId;
    }

    public String getoStatus() {
        return oStatus;
    }

    public String getoTime() {
        return oTime;
    }

    public String getoTotal() {
        return oTotal;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public void setoTime(String oTime) {
        this.oTime = oTime;
    }

    public void setoTotal(String oTotal) {
        this.oTotal = oTotal;
    }

    public void setoStatus(String oStatus) {
        this.oStatus = oStatus;
    }
}

