package designPatterns.factory.TaxCalculation;

public class TaxCalculator {

    public static void main(String[] args) {



    }
   public static  int calculateTax(SalaryDetails salaryDetails,TaxRegime regime){

    TaxCalculationAlgorithm taxCalculationAlgorithm  = TaxRegimeAlgorithemFactory.getTaxCalculationAlgorithmForRegime(regime) ;

    return taxCalculationAlgorithm.calculateTax(salaryDetails);

    }
}
