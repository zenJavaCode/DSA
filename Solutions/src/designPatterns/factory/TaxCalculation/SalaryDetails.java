package designPatterns.factory.TaxCalculation;


public class SalaryDetails {

    int basepay;
    int hra;
    int etf;
    int lta;

    public int getBasepay() {
        return basepay;
    }

    public void setBasepay(int basepay) {
        this.basepay = basepay;
    }

    public int getHra() {
        return hra;
    }

    public void setHra(int hra) {
        this.hra = hra;
    }

    public int getEtf() {
        return etf;
    }

    public void setEtf(int etf) {
        this.etf = etf;
    }

    public int getLta() {
        return lta;
    }

    public void setLta(int lta) {
        this.lta = lta;
    }
}
