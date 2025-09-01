package appscore;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
/* loaded from: ScoreResult.class */
public class ScoreResult {
    public static String calculate(String str, List list) {
        try {
            return new ObjectMapper().writeValueAsString(ScoreCalculator.a(str, list));
        } catch (Exception e) {
            throw new RuntimeException("计算失败: " + e.getMessage(), e);
        }
    }

    public static void main(String[] strArr) {

        System.out.println(calculate("2025062212Q5D8K0D6",
                Arrays.asList(
                        "cash.meprestamo.tala.credito.oxxo.efectivo.okreditopeso.cashcash.prestamo",
                        "com.bancomer.mbanking",
                        "com.citibanamex.banamexmobile",
                        "com.globalhitss.claro.pay",
                        "com.google.android.apps.walletnfcrel",
                        "com.mercadopago.wallet",
                        "com.mexicash.app",
                        "com.nu.production",
                        "com.pagopopmobile",
                        "mx.com.procesar.aforemovil.citi",
                        "mx.openbank.modelbank"
                )));
    }
}