package es.upm.dit.isst.tucomunidadapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "neighbour_votes")
public class NeighbourVotes {

    @Id
    @GeneratedValue
    @Column(name = "id_neighbour_votes")
    private Integer idNeighbourVote;

    @ManyToOne
    @JoinColumn(name = "id_neighbour")
    private Neighbour neighbour;

    @ManyToOne
    @JoinColumn(name = "id_vote")
    private Vote vote;

    public Integer getIdNeighbourVote() {
        return idNeighbourVote;
    }

    public void setIdNeighbourVote(Integer idNeighbourVote) {
        this.idNeighbourVote = idNeighbourVote;
    }

    public Neighbour getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(Neighbour neighbour) {
        this.neighbour = neighbour;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idNeighbourVote == null) ? 0 : idNeighbourVote.hashCode());
        result = prime * result + ((neighbour == null) ? 0 : neighbour.hashCode());
        result = prime * result + ((vote == null) ? 0 : vote.hashCode());
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
        NeighbourVotes other = (NeighbourVotes) obj;
        if (idNeighbourVote == null) {
            if (other.idNeighbourVote != null)
                return false;
        } else if (!idNeighbourVote.equals(other.idNeighbourVote))
            return false;
        if (neighbour == null) {
            if (other.neighbour != null)
                return false;
        } else if (!neighbour.equals(other.neighbour))
            return false;
        if (vote == null) {
            if (other.vote != null)
                return false;
        } else if (!vote.equals(other.vote))
            return false;
        return true;
    }

}
