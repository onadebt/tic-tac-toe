package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import java.util.List;

public interface MoveParameterGatherer {

    /**
     * Gather move parameters from user.
     *
     * @return list of move parameters
     */
    List<Long> gatherMoveParameters();
}
