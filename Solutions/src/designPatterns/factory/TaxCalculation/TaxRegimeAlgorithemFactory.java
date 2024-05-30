package designPatterns.factory.TaxCalculation;

public class TaxRegimeAlgorithemFactory {

    public static TaxCalculationAlgorithm getTaxCalculationAlgorithmForRegime(TaxRegime regime ){
        TaxCalculationAlgorithm taxCalculationAlgorithm;
        if(regime == TaxRegime.OLD){
        taxCalculationAlgorithm = new OldRegimeTaxCalculationAlgorithm();
        }else if(regime == TaxRegime.NEW){
            taxCalculationAlgorithm = new NewRegimeTaxCalculationAlgorithm();
        }else{
            throw  new IllegalArgumentException();
        }
       return taxCalculationAlgorithm;


    }
}
