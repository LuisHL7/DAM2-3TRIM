package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CurrentAccount extends Account implements Serializable {
    private List<Movement> movements;

    public CurrentAccount() {
        movements = new ArrayList<Movement>();
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                super.toString() +
                "movements=" + movements +
                "} ";
    }
}
