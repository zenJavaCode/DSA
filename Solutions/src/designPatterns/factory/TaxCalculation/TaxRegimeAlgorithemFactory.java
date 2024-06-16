package designPatterns.factory.TaxCalculation;

public class TaxRegimeAlgorithemFactory {


    static{
        System.out.println("Hello before main method");
    }



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
