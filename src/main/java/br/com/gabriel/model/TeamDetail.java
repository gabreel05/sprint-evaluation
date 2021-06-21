package br.com.gabriel.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class TeamDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TeamDetailPK teamDetailPK;

	public TeamDetailPK getTeamDetailPK() {
		return teamDetailPK;
	}

	public void setTeamDetailPK(TeamDetailPK teamDetailPK) {
		this.teamDetailPK = teamDetailPK;
	}

}
