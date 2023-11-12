import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTests {

    //mvn -Dtest=TestCircle#mytest test
    //maven-surefire-pluging
    //mvn clean test

    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})  //no objects for ValueSource. only Strings and primitives
    void testCase1(String args){
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9})  //no objects for ValueSource. only Strings and primitives
    void testCase2(int number){
        Assertions.assertEquals(0, number % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
    @EmptySource
    @NullSource
    void testCase3(String args){
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String arg){
        Assertions.assertNotNull(arg);
    }

    static String[] stringProvider(){
        return new String[]{"Java","JS","TS"};
    }

    @ParameterizedTest
    @CsvSource({"10,20,30","20,40,60","30,20,100"})
    void testCase5(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1,num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1,num2));
    }
}
