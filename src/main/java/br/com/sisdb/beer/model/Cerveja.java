package br.com.sisdb.beer.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.sisdb.beer.validation.Sku;


@Entity
@Table(name = "cerveja")
public class Cerveja implements Serializable{	
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Sku
		@NotBlank(message = "SKU é obrigatório.")
		private String sku;
		@NotBlank(message = "Nome é obrigatório.")
		private String nome;
		
		@Size(max = 50, min = 2, message = "A descrição deve ter de 1 à 50 caracteres.")
		private String descricao;
		
		
		private BigDecimal valor;
		
		@Column(name =  "teor_alcoolico")
		private BigDecimal teorAlcoolico;
		
		private BigDecimal comissao;
		
		@Column(name = "quantidade_estoque")
		private Integer qtdEstoque;
		
		@Enumerated(EnumType.STRING)
		private Origem origem;
		
		//@NotBlank(message = "Sabor é obrigatório.")
		@Enumerated(EnumType.STRING)
		private Sabor sabor;	
		
		@ManyToOne
		@JoinColumn(name = "id_estilo")
		private Estilo estilo;
				
		public Cerveja() {
			super();
		}
		public String getSku() {
			return sku;
		}
		public void setSku(String sku) {
			this.sku = sku;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public BigDecimal getValor() {
			return valor;
		}
		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}
		public BigDecimal getTeorAlcoolico() {
			return teorAlcoolico;
		}
		public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
			this.teorAlcoolico = teorAlcoolico;
		}
		public BigDecimal getComissao() {
			return comissao;
		}
		public void setComissao(BigDecimal comissao) {
			this.comissao = comissao;
		}
		public Integer getQtdEstoque() {
			return qtdEstoque;
		}
		public void setQtdEstoque(Integer qtdEstoque) {
			this.qtdEstoque = qtdEstoque;
		}
		public Origem getOrigem() {
			return origem;
		}
		public void setOrigem(Origem origem) {
			this.origem = origem;
		}
		public Sabor getSabor() {
			return sabor;
		}
		public void setSabor(Sabor sabor) {
			this.sabor = sabor;
		}
		public Estilo getEstilo() {
			return estilo;
		}
		public void setEstilo(Estilo estilo) {
			this.estilo = estilo;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((comissao == null) ? 0 : comissao.hashCode());
			result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
			result = prime * result + ((estilo == null) ? 0 : estilo.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			result = prime * result + ((origem == null) ? 0 : origem.hashCode());
			result = prime * result + ((qtdEstoque == null) ? 0 : qtdEstoque.hashCode());
			result = prime * result + ((sabor == null) ? 0 : sabor.hashCode());
			result = prime * result + ((sku == null) ? 0 : sku.hashCode());
			result = prime * result + ((teorAlcoolico == null) ? 0 : teorAlcoolico.hashCode());
			result = prime * result + ((valor == null) ? 0 : valor.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cerveja other = (Cerveja) obj;
			if (comissao == null) {
				if (other.comissao != null)
					return false;
			} else if (!comissao.equals(other.comissao))
				return false;
			if (descricao == null) {
				if (other.descricao != null)
					return false;
			} else if (!descricao.equals(other.descricao))
				return false;
			if (estilo == null) {
				if (other.estilo != null)
					return false;
			} else if (!estilo.equals(other.estilo))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (origem != other.origem)
				return false;
			if (qtdEstoque == null) {
				if (other.qtdEstoque != null)
					return false;
			} else if (!qtdEstoque.equals(other.qtdEstoque))
				return false;
			if (sabor != other.sabor)
				return false;
			if (sku == null) {
				if (other.sku != null)
					return false;
			} else if (!sku.equals(other.sku))
				return false;
			if (teorAlcoolico == null) {
				if (other.teorAlcoolico != null)
					return false;
			} else if (!teorAlcoolico.equals(other.teorAlcoolico))
				return false;
			if (valor == null) {
				if (other.valor != null)
					return false;
			} else if (!valor.equals(other.valor))
				return false;
			return true;
		}	
	
	
}
