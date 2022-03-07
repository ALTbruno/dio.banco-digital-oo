package com.ALTbruno.dio.bancodigitaloo.interfaces;

import java.math.BigDecimal;

public interface ContaInterface {

	void sacar(BigDecimal valor);

	void depositar(BigDecimal valor);

	void transferir(BigDecimal valor, ContaInterface contaDestino);

	void imprimirExtrato();

}
