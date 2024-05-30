package designPatterns.factory.TaxCalculation;

public class OldRegimeTaxCalculationAlgorithm implements TaxCalculationAlgorithm{
    @Override
    public int calculateTax(SalaryDetails salaryDetails) {
        return 0;
    }
}
