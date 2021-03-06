package com.matheus.demo.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Cidade implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String nome;
		
		@ManyToOne
		private Estado estado;
		
		public Estado getEst() {
			return estado;
		}
		public void setEst(Estado est) {
			this.estado = est;
		}
		public Cidade() {
			super();
		}
		public Cidade(Integer id, String nome,Estado estado) {
			super();
			this.id = id;
			this.nome = nome;
			this.estado = estado;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public int hashCode() {
			return Objects.hash(id);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cidade other = (Cidade) obj;
			return Objects.equals(id, other.id);
		}
		
		
}
