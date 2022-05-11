package es.upm.dit.isst.tucomunidadapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue
    @Column(name = "id_vote")
    private Integer idVote;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "id_manager")
    private Manager manager;

    @Column(name = "number_of_votes_in_favour")
    private Integer numberOfVotesInFavour;

    @Column(name = "number_of_votes_against")
    private Integer numberOfVotesAgainst;

    public Integer getIdVote() {
        return idVote;
    }

    public void setIdVote(Integer idVote) {
        this.idVote = idVote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Integer getNumberOfVotesInFavour() {
        return numberOfVotesInFavour;
    }

    public void setNumberOfVotesInFavour(Integer numberOfVotesInFavour) {
        this.numberOfVotesInFavour = numberOfVotesInFavour;
    }

    public Integer getNumberOfVotesAgainst() {
        return numberOfVotesAgainst;
    }

    public void setNumberOfVotesAgainst(Integer numberOfVotesAgainst) {
        this.numberOfVotesAgainst = numberOfVotesAgainst;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((idVote == null) ? 0 : idVote.hashCode());
        result = prime * result + ((manager == null) ? 0 : manager.hashCode());
        result = prime * result + ((numberOfVotesAgainst == null) ? 0 : numberOfVotesAgainst.hashCode());
        result = prime * result + ((numberOfVotesInFavour == null) ? 0 : numberOfVotesInFavour.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        Vote other = (Vote) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (idVote == null) {
            if (other.idVote != null)
                return false;
        } else if (!idVote.equals(other.idVote))
            return false;
        if (manager == null) {
            if (other.manager != null)
                return false;
        } else if (!manager.equals(other.manager))
            return false;
        if (numberOfVotesAgainst == null) {
            if (other.numberOfVotesAgainst != null)
                return false;
        } else if (!numberOfVotesAgainst.equals(other.numberOfVotesAgainst))
            return false;
        if (numberOfVotesInFavour == null) {
            if (other.numberOfVotesInFavour != null)
                return false;
        } else if (!numberOfVotesInFavour.equals(other.numberOfVotesInFavour))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    
}
