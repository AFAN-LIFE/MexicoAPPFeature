package appscore;

import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScoreResult {

    /**
     * 计算并返回结果（JSON 字符串）
     * @param orderNo 订单号
     * @param appList 用户的 app 列表
     * @return JSON 格式的结果
     */
    public static String calculate(String orderNo, List<String> appList) {
        try {
            // 调用 ScoreCalculator 进行计算
            Map<String, Object> resultMap = ScoreCalculator.calculateScores(orderNo, appList);
            // 转成 JSON
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(resultMap);
        } catch (Exception e) {
            throw new RuntimeException("计算失败: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) throws IOException {
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

        System.out.println(calculate("2025033119BAUNMQL8",
                Arrays.asList(
                        "ai.powerup.stori",
                        "cash.efectivo.okredito.prestamos.tala.credito.oxxo",
                        "com.app.dinero.hoy.loan.mx",
                        "com.baubap",
                        "com.coppel.coppelapp",
                        "com.dinero.fd.mx.loan",
                        "com.efectivohoy.mx.loan",
                        "com.elaworld.mexloan",
                        "com.finanzasagiles.credito",
                        "com.fintopia.mxcredmex",
                        "com.globalhitss.claro.pay",
                        "com.google.android.apps.walletnfcrel",
                        "com.mercadopago.wallet",
                        "com.mexicash.app",
                        "com.mexico.prestamoloan.mexiplus",
                        "com.movilcash.prestamo",
                        "com.mx.lalanitaplus",
                        "com.mx.venga.credit",
                        "com.nu.production",
                        "com.okredito.cash.credito.tala.prestamo.crediti",
                        "com.palpresta.credito",
                        "com.presta.go",
                        "com.prestamo.credito.dinero.efectivo.facil.rapido.noroplus",
                        "com.prestamo.creditos.prestamocash.online.instant",
                        "com.todocredito.mx",
                        "coop.cpm.cpmenlinea.mobile",
                        "fastapply.mx.loan.ne",
                        "mx.com.miapp",
                        "mx.com.paramia",
                        "mx.klar.app",
                        "mx.novacard",
                        "pop.prestamo.plus",
                        "ppcredito.loan.thouisparkme.com",
                        "prestamos.creditoya.urgente.dinero.peso.cash.credito.rapido",
                        "walletmi.mex.aparato.mone.mw"
                )));

        System.out.println(calculate("20250521197WQTWHTP",
                Arrays.asList(
                        "agency.equilibrio.sodexomexico",
                        "cash.meprestamo.tala.credito.oxxo.efectivo.okreditopeso.cashcash.prestamo",
                        "cash.prestamos.credit.instalacion.kueski.plapla",
                        "com.baubap",
                        "com.dinero.fd.mx.loan",
                        "com.elaworld.mexloan",
                        "com.fintopia.mxcredmex",
                        "com.google.android.apps.walletnfcrel",
                        "com.kaby",
                        "com.kueski.os",
                        "com.mercadopago.wallet",
                        "com.mexicash.app",
                        "finance.empower.mx",
                        "mx.com.tala",
                        "mx.hsbc.hsbcmexico"
                )));

        System.out.println(calculate("20250521197WQTWHTP",
                Arrays.asList(
                        "agency.equilibrio.sodexomexico",
                        "cash.meprestamo.tala.credito.oxxo.efectivo.okreditopeso.cashcash.prestamo",
                        "cash.prestamos.credit.instalacion.kueski.plapla",
                        "com.baubap",
                        "com.dinero.fd.mx.loan",
                        "com.elaworld.mexloan",
                        "com.fintopia.mxcredmex",
                        "com.google.android.apps.walletnfcrel",
                        "com.kaby",
                        "com.kueski.os",
                        "com.mercadopago.wallet",
                        "com.mexicash.app",
                        "finance.empower.mx",
                        "mx.com.tala",
                        "mx.hsbc.hsbcmexico"
                )));


        System.out.println(calculate("20250708089OR3275R",
                Arrays.asList(
                        "cash.efectivo.okredito.prestamos.tala.credito.oxxo",
                        "com.baubap",
                        "com.fintopia.mxcredmex",
                        "com.google.android.apps.walletnfcrel",
                        "com.mexicash.app",
                        "com.nu.production",
                        "com.sggaanalista.cashmex",
                        "mx.klar.app"
                )));

        System.out.println(calculate("20250717137FCVJ8DH",
                Arrays.asList(
                        "cash.efectivo.okredito.prestamos.tala.credito.oxxo",
                        "com.bancomer.mbanking",
                        "com.mercadopago.wallet",
                        "com.nu.production",
                        "mx.aplazo.mobile.customer",
                        "mx.com.bancoazteca.bazdigitalmovil",
                        "mx.com.tala"
                )));

        System.out.println(calculate("2025070721ZX73S9CH",
                Arrays.asList(
                        "cash.efectivo.okredito.prestamos.tala.credito.oxxo",
                        "com.bancomer.mbanking",
                        "com.google.android.apps.walletnfcrel",
                        "com.nu.production",
                        "mx.com.bancoazteca.bazdigitalmovil"
                )));

        System.out.println(calculate("2025070721ZX73S9CH",
                Arrays.asList(
                        "cash.efectivo.okredito.prestamos.tala.credito.oxxo  ",
                        "  com.Bancomer.mbanking",
                        "com.google.android.apps.Walletnfcrel",
                        "com.nu.production  ",
                        "mx.com.bancoazteca.bazdigitalmovil  "
                )));
        System.out.println(calculate("2025070721ZX73S9CH",
                Arrays.asList(
                        "cash.efectivo.okr edito.prestamos.tala.credito.oxxo  ",
                        "  com. Bancomer.mbanking",
                        "com.google.an droid.apps.Walletnfcrel",
                        "com.nu.produ ction  ",
                        "mx.com.bancoa zteca.bazdigitalmovil  "
                )));
        System.out.println(calculate("nomatch",
                Arrays.asList(
                        "cash123 "
                )));
//        System.out.println(calculate("nolist",
//                Arrays.asList(
//                )));
        System.out.println(calculate("",
                Arrays.asList("cash123 "
                )));
    }
}