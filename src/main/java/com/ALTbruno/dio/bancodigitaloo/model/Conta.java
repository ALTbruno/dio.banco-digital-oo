package com.ALTbruno.dio.bancodigitaloo.model;

import com.ALTbruno.dio.bancodigitaloo.interfaces.ContaInterface;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;

public class Conta implements ContaInterface {

	private static final int AGENCIA_PADRAO = 1;

	private static int SEQUENCIAL = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	protected Integer agencia;

	protected Integer numero;

	protected BigDecimal saldo;

	protected Cliente cliente;


	public Conta(Integer agencia, Integer numero, Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgencia() {
		return agencia;
	}

//	public void setAgencia(Integer agencia) {
//		this.agencia = agencia;
//	}

	public Integer getNumero() {
		return numero;
	}

//	public void setNumero(Integer numero) {
//		this.numero = numero;
//	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public void sacar(BigDecimal valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(BigDecimal valor) {
		saldo += valor;
	}

	@Override
	public void transferir(BigDecimal valor, ContaInterface contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

//	protected void imprimirInfosComuns() {
//		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
//		System.out.println(String.format("Agencia: %d", this.agencia));
//		System.out.println(String.format("Numero: %d", this.numero));
//		System.out.println(String.format("Saldo: %.2f", this.saldo));
//	}
}
