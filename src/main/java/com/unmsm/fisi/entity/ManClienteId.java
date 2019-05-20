package com.unmsm.fisi.entity;
// Generated 19/05/2019 11:40:02 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ManClienteId generated by hbm2java
 */
@Embeddable
public class ManClienteId implements java.io.Serializable {

	private String manPersonaVNumeroDocumento;
	private String manPersonaVTipoDocumento;

	public ManClienteId() {
	}

	public ManClienteId(String manPersonaVNumeroDocumento, String manPersonaVTipoDocumento) {
		this.manPersonaVNumeroDocumento = manPersonaVNumeroDocumento;
		this.manPersonaVTipoDocumento = manPersonaVTipoDocumento;
	}

	@Column(name = "man_persona_vNumeroDocumento", nullable = false, length = 20)
	public String getManPersonaVNumeroDocumento() {
		return this.manPersonaVNumeroDocumento;
	}

	public void setManPersonaVNumeroDocumento(String manPersonaVNumeroDocumento) {
		this.manPersonaVNumeroDocumento = manPersonaVNumeroDocumento;
	}

	@Column(name = "man_persona_vTipoDocumento", nullable = false, length = 20)
	public String getManPersonaVTipoDocumento() {
		return this.manPersonaVTipoDocumento;
	}

	public void setManPersonaVTipoDocumento(String manPersonaVTipoDocumento) {
		this.manPersonaVTipoDocumento = manPersonaVTipoDocumento;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ManClienteId))
			return false;
		ManClienteId castOther = (ManClienteId) other;

		return ((this.getManPersonaVNumeroDocumento() == castOther.getManPersonaVNumeroDocumento())
				|| (this.getManPersonaVNumeroDocumento() != null && castOther.getManPersonaVNumeroDocumento() != null
						&& this.getManPersonaVNumeroDocumento().equals(castOther.getManPersonaVNumeroDocumento())))
				&& ((this.getManPersonaVTipoDocumento() == castOther.getManPersonaVTipoDocumento())
						|| (this.getManPersonaVTipoDocumento() != null
								&& castOther.getManPersonaVTipoDocumento() != null
								&& this.getManPersonaVTipoDocumento().equals(castOther.getManPersonaVTipoDocumento())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getManPersonaVNumeroDocumento() == null ? 0 : this.getManPersonaVNumeroDocumento().hashCode());
		result = 37 * result
				+ (getManPersonaVTipoDocumento() == null ? 0 : this.getManPersonaVTipoDocumento().hashCode());
		return result;
	}

}
