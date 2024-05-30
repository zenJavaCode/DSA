package designPatterns.factory.TaxCalculation;

public class TaxCalculator {


    int calculateTax(SalaryDetails salaryDetails,TaxRegime regime){

    TaxCalculationAlgorithm taxCalculationAlgorithm  = TaxRegimeAlgorithemFactory.getTaxCalculationAlgorithmForRegime(regime) ;

    return taxCalculationAlgorithm.calculateTax(salaryDetails);

    }
}
