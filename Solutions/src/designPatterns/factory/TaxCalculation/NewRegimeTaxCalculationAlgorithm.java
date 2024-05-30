package designPatterns.factory.TaxCalculation;

public class NewRegimeTaxCalculationAlgorithm implements TaxCalculationAlgorithm{
    @Override
    public int calculateTax(SalaryDetails salaryDetails) {
        return 0;
    }
}
