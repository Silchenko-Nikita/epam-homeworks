import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value=Parameterized.class)
public class TemperatureConverterTests {
    TemperatureConverter temperatureConverter = new TemperatureConverter();
    @Parameterized.Parameter(0)
    public ConversionType conversionType;
    @Parameterized.Parameter(1)
    public double temperatureValue;
    @Parameterized.Parameter(2)
    public double expectedResult;


    enum ConversionType {F_TO_C, F_TO_K, K_TO_F, K_TO_C, C_TO_F, C_TO_K};

    @Parameterized.Parameters(name="{index}:{0}({1})={2}")
    public static Collection data() {
        return Arrays.asList( new Object[][] {
                { ConversionType.F_TO_C, 0, -17.7778},
                { ConversionType.F_TO_C, 100, 37.7778},
                { ConversionType.F_TO_C, 212.0, 100.0},
                { ConversionType.F_TO_C, -50.0, -45.5556},

                { ConversionType.F_TO_K, 0, 255.3889},
                { ConversionType.F_TO_K, 100, 310.9444},
                { ConversionType.F_TO_K, 212.0, 373.1667},
                { ConversionType.F_TO_K, -50.0, 227.6111},

                { ConversionType.K_TO_F, 0, -459.7},
                { ConversionType.K_TO_F, 280, 44.3},
                { ConversionType.K_TO_F, 373.2, 212.06},
                { ConversionType.K_TO_F, 173.2, -147.94},

                { ConversionType.K_TO_C, 0, -273.2},
                { ConversionType.K_TO_C, 280, 6.80},
                { ConversionType.K_TO_C, 373.2, 100.0},
                { ConversionType.K_TO_C, 173.2, -100.0},

                { ConversionType.C_TO_F, 0, 32.0},
                { ConversionType.C_TO_F, 100, 212.0},
                { ConversionType.C_TO_F, -100, -148.0},
                { ConversionType.C_TO_F, 25, 77.0},

                { ConversionType.C_TO_K, 0, 273.2},
                { ConversionType.C_TO_K, 100, 373.2},
                { ConversionType.C_TO_K, -100, 173.2},
                { ConversionType.C_TO_K, 25, 298.2},
        });

    }

    @Test
    public void testConvertFtoC() {
        if (conversionType != ConversionType.F_TO_C) return;

        double actualResult = temperatureConverter.convertFtoC(temperatureValue);
        Assert.assertEquals("Результат(" + expectedResult + ") не равен " + actualResult,
                expectedResult, actualResult, 0.001);
    }

    @Test
    public void testConvertFtoK() {
        if (conversionType != ConversionType.F_TO_K) return;

        double actualResult = temperatureConverter.convertFtoK(temperatureValue);
        Assert.assertEquals("Результат(" + expectedResult + ") не равен " + actualResult,
                expectedResult, actualResult, 0.001);
    }

    @Test
    public void testConvertKtoF() {
        if (conversionType != ConversionType.K_TO_F) return;

        double actualResult = temperatureConverter.convertKtoF(temperatureValue);
        Assert.assertEquals("Результат(" + expectedResult + ") не равен " + actualResult,
                expectedResult, actualResult, 0.001);
    }

    @Test
    public void testConvertKtoC() {
        if (conversionType != ConversionType.K_TO_C) return;

        double actualResult = temperatureConverter.convertKtoC(temperatureValue);
        Assert.assertEquals("Результат(" + expectedResult + ") не равен " + actualResult,
                expectedResult, actualResult, 0.001);
    }

    @Test
    public void testConvertCtoF() {
        if (conversionType != ConversionType.C_TO_F) return;

        double actualResult = temperatureConverter.convertCtoF(temperatureValue);
        Assert.assertEquals("Результат(" + expectedResult + ") не равен " + actualResult,
                expectedResult, actualResult, 0.001);
    }

    @Test
    public void testConvertCtoK() {
        if (conversionType != ConversionType.C_TO_K) return;

        double actualResult = temperatureConverter.convertCtoK(temperatureValue);
        Assert.assertEquals("Результат(" + expectedResult + ") не равен " + actualResult,
                expectedResult, actualResult, 0.001);
    }
}
